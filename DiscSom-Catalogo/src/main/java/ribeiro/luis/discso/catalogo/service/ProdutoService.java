package ribeiro.luis.discso.catalogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ribeiro.luis.discso.catalogo.model.Produto;
import ribeiro.luis.discso.catalogo.repository.ProdutoRepository;

@Service 
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> getProdutosPorEstado(String descricao) {
		return produtoRepository.findByDescricao(descricao);
	}

	
}
