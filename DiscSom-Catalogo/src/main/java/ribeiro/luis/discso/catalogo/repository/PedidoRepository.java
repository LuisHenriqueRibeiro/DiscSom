package ribeiro.luis.discso.catalogo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ribeiro.luis.discso.catalogo.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {
	@Query(value = "SELECT MAX(p.id) FROM Pedido p",nativeQuery = true)
	int getMaxIdPedido();

}