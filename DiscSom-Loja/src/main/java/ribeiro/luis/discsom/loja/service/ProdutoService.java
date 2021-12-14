package ribeiro.luis.discsom.loja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ribeiro.luis.discsom.loja.model.InfoProduto;
import ribeiro.luis.discsom.loja.model.ListaDeProdutos;

@Service
public class ProdutoService {

	@Autowired
	private RestTemplate client;
	@Autowired
	private DiscoveryClient eurekaClient;

	private InfoProduto converter(ResponseEntity<InfoProduto> exchange) {
		InfoProduto produto = new InfoProduto();

		produto.setDescricao(exchange.getBody().getDescricao());
		produto.setId(exchange.getBody().getId());
		produto.setImagem(exchange.getBody().getImagem());
		produto.setNome(exchange.getBody().getNome());
		produto.setQuantidade(exchange.getBody().getQuantidade());
		return produto;
	}

	private ListaDeProdutos converteLista(ResponseEntity<List<InfoProduto>> exchange) {
		ListaDeProdutos lista = new ListaDeProdutos();
		lista.setLista(exchange.getBody());
		return lista;
	}

	public InfoProduto getProdutoPorId(int id) {
		ResponseEntity<InfoProduto> exchange = client.exchange("http://catalogo/produto/Id/" + id, HttpMethod.GET, null,
				InfoProduto.class);
		return converter(exchange);
	}

	public InfoProduto getProdutoPorNome(String nome) {
		ResponseEntity<InfoProduto> exchange = client.exchange("http://catalogo/produto/nome/" + nome, HttpMethod.GET,
				null, InfoProduto.class);

		return converter(exchange);
	}

	public ListaDeProdutos getProdutoPorDescricao(String descricao) {
		ResponseEntity<List<InfoProduto>> exchange = client.exchange("http://catalogo/produto/" + descricao,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<InfoProduto>>() {
				});
		return converteLista(exchange);
	}

	public ListaDeProdutos getAllProduto() {
		ResponseEntity<List<InfoProduto>> exchange = client.exchange("http://catalogo/produto/catalogo", HttpMethod.GET,
				null, new ParameterizedTypeReference<List<InfoProduto>>() {
				});
		return converteLista(exchange);
	}

	public ListaDeProdutos getAllCategoria(long idCategoria) {
		ResponseEntity<List<InfoProduto>> exchange = client.exchange("http://catalogo/produto/categoria/"+idCategoria, HttpMethod.GET,
				null, new ParameterizedTypeReference<List<InfoProduto>>() {
				});
		return converteLista(exchange);
	}

	public int getMaxId() {
		ResponseEntity<Integer> exchange = client.exchange("http://catalogo/produto/maxId", HttpMethod.GET,
				null, Integer.class);
		int MaxId = exchange.getBody();
		return MaxId;
	}

}
