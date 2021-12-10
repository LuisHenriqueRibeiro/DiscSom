package ribeiro.luis.discso.catalogo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ribeiro.luis.discso.catalogo.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
	List<Produto> findByDescricao(String descricao);

	List<Produto> findByIdIn(List<Long> ids);
	@Query(value = "SELECT p.id, p.nome, p.descricao,p.imagem, p.preco,p.categoria_id FROM Produto p "
			+ "WHERE p.categoria_id = :IDCATEGORIA",nativeQuery = true)
	List<Produto> buscarCategoria(@Param("IDCATEGORIA") Integer inteiro);
}
