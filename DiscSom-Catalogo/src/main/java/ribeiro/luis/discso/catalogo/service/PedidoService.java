package ribeiro.luis.discso.catalogo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ribeiro.luis.discso.catalogo.dto.ItemDoPedidoDTO;
import ribeiro.luis.discso.catalogo.model.Pedido;
import ribeiro.luis.discso.catalogo.model.PedidoItem;
import ribeiro.luis.discso.catalogo.model.Produto;
import ribeiro.luis.discso.catalogo.repository.PedidoRepository;
import ribeiro.luis.discso.catalogo.repository.ProdutoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	public Pedido realizaPedido(List<ItemDoPedidoDTO> itens) {

		if (itens == null) {
			return null;
		}

		List<PedidoItem> pedidoItens = toPedidoItem(itens);
		Pedido pedido = new Pedido(pedidoItens);
		pedido.setTempoDePreparo(itens.size());
		return pedidoRepository.save(pedido);
	}

	public Pedido getPedidoPorId(Long id) {
		return this.pedidoRepository.findById(id).orElse(new Pedido());
	}

	private List<PedidoItem> toPedidoItem(List<ItemDoPedidoDTO> itens) {

		List<Long> idsProdutos = itens.stream().map(item -> item.getId()).collect(Collectors.toList());

		List<Produto> produtosDoPedido = produtoRepository.findByIdIn(idsProdutos);

		List<PedidoItem> pedidoItens = itens.stream().map(item -> {
			Produto produto = produtosDoPedido.stream().filter(p -> p.getId() == item.getId()).findFirst().get();

			PedidoItem pedidoItem = new PedidoItem();
			pedidoItem.setProduto(produto);
			pedidoItem.setQuantidade(item.getQuantidade());
			return pedidoItem;
		}).collect(Collectors.toList());
		return pedidoItens;
	}

	public boolean baixaNoEstque(List<ItemDoPedidoDTO> produtos) {
		boolean conseguiu = conferirValores(produtos);
		if (conseguiu) {
			for (ItemDoPedidoDTO pdt : produtos) {
				produtoRepository.baixaNoEstoque(pdt.getQuantidade(),pdt.getId());
			}
		}
		return conseguiu;
	}

	public boolean conferirValores(List<ItemDoPedidoDTO> produtos) {
		boolean aprova = true;
		for (ItemDoPedidoDTO pdt : produtos) {
			List<Produto> dadosRecebidos = produtoRepository.trazerEstoque(pdt.getId());
			for (Produto prod : dadosRecebidos) {
				if ((prod.getQuantidade() - pdt.getQuantidade()) > 0) {
					aprova = true;
				} else {
					aprova = false;
				}
			}

		}
		return aprova;
	}

}
