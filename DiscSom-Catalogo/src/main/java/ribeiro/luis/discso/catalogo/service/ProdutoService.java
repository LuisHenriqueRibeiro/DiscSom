package ribeiro.luis.discso.catalogo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ribeiro.luis.discso.catalogo.model.Produto;
import ribeiro.luis.discso.catalogo.repository.ProdutoRepository;

@Service 
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> getProdutosPorDescricao(String descricao) {
		return produtoRepository.findByDescricao(descricao);
		
	}

	public List<Produto> getProdutosDoCatalogo() {
		List<Produto> produtos = new ArrayList<>();
		Iterable<Produto> findAll = produtoRepository.findAll();
		findAll.forEach(produto -> {
			produtos.add(produto);
		});
		return produtos;
	}

	public List<Produto> getProdutosPorCategoria(String idCategoria) {
		Integer inteiro = Integer.parseInt(idCategoria);
		return produtoRepository.buscarCategoria(inteiro);
	}

	
}
