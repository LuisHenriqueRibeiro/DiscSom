package ribeiro.luis.discso.catalogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ribeiro.luis.discso.catalogo.model.Produto;
import ribeiro.luis.discso.catalogo.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping("/{descricao}")
	public List<Produto> getProdutosPorEstado(@PathVariable("descricao") String descricao) {
		return produtoService.getProdutosPorEstado(descricao);
	}
}