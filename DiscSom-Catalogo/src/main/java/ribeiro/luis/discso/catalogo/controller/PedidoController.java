package ribeiro.luis.discso.catalogo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ribeiro.luis.discso.catalogo.dto.ItemDoPedidoDTO;
import ribeiro.luis.discso.catalogo.model.Pedido;
import ribeiro.luis.discso.catalogo.service.PedidoService;

@RestController
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@RequestMapping(method = RequestMethod.POST)
	public Pedido realizaPedido(@RequestBody List<ItemDoPedidoDTO> produtos) {
		boolean realizou = pedidoService.baixaNoEstque(produtos);
		if(realizou)
		{
			return pedidoService.realizaPedido(produtos);
		}
		return null;
	}
	
	@RequestMapping("/{id}")
	public Pedido getPedidoPorId(@PathVariable Long id) {
		return pedidoService.getPedidoPorId(id);
	}
}
	
