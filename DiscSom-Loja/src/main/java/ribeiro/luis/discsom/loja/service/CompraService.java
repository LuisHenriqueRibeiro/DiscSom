package ribeiro.luis.discsom.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ribeiro.luis.discsom.loja.dto.CompraDTO;
import ribeiro.luis.discsom.loja.dto.InfoPedido;
import ribeiro.luis.discsom.loja.model.Compra;

@Service
public class CompraService {
	@Autowired
	private RestTemplate client;
	@Autowired
	private DiscoveryClient eurekaClient;

	public Compra realizaCompra(CompraDTO compra) {
		ResponseEntity<InfoPedido> pedido = client.postForEntity("http://catalogo/pedido", compra.getItens(),
				InfoPedido.class);

		/*
		 * eurekaClient.getInstances("fornecedor").stream().forEach(fornecedor -> {
		 * System.out.println("localhost:"+fornecedor.getPort()); });
		 */
		Compra infoCompra = new Compra();
		infoCompra.setPedidoId(pedido.getBody().getId());
		infoCompra.setTempoDePreparo(pedido.getBody().getTempoDePreparo());
		infoCompra.setEnderecoDestino(compra.getEndereco().toString());

		// System.out.println(exchange.getBody().getEndereco());
		return infoCompra;
	}
}
