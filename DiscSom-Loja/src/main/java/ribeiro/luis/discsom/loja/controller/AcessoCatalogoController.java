package ribeiro.luis.discsom.loja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ribeiro.luis.discsom.loja.model.InfoProduto;
import ribeiro.luis.discsom.loja.model.ListaDeProdutos;
import ribeiro.luis.discsom.loja.service.ProdutoService;
@CrossOrigin
@RestController
@RequestMapping("produtos")
public class AcessoCatalogoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping("/buscaId/{id}")
	public InfoProduto getProdutoPorId(@PathVariable int id)
	{
		return produtoService.getProdutoPorId(id);
	}
	
	@RequestMapping("/buscaNome/{nome}")
	public InfoProduto getProdutoPorNome(@PathVariable String nome)
	{
		return produtoService.getProdutoPorNome(nome);
	}
	
	@RequestMapping("/buscaDescricao/{descricao}")
	public ListaDeProdutos getProdutoPorDescricao(@PathVariable String descricao)
	{
		return produtoService.getProdutoPorDescricao(descricao);
	}
	
	@RequestMapping("/all")
	public ListaDeProdutos getProdutoPorDescricao()
	{
		return produtoService.getAllProduto();
	}
	
	@RequestMapping("/categoria/{idCategoria}")
	public ListaDeProdutos getProdutoPorCategoria(@PathVariable long idCategoria)
	{
		return produtoService.getAllCategoria(idCategoria);
	}
	@RequestMapping("/maiorId")
	public int getMaxId()
	{
		return produtoService.getMaxId();
	}
	
	
	

}
