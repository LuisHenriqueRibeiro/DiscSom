package ribeiro.luis.discso.catalogo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ribeiro.luis.discso.catalogo.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
	List<Produto> findByDescricao(String descricao);

	List<Produto> findByIdIn(List<Long> ids);

	@Query(value = "SELECT p.id, p.nome, p.descricao,p.imagem,p.quantidade, p.preco,p.categoria_id FROM Produto p "
			+ "WHERE p.categoria_id = :IDCATEGORIA", nativeQuery = true)
	List<Produto> buscarCategoria(@Param("IDCATEGORIA") Integer inteiro);
	
	@Modifying
	@Transactional
	@Query("UPDATE Produto p SET p.quantidade = p.quantidade - :QUANTIDADE WHERE p.id = :ID")
	void baixaNoEstoque(@Param("QUANTIDADE") int quantidade, @Param("ID") long id);

	@Query(value="SELECT p.id, p.nome, p.descricao,p.imagem,p.quantidade, p.preco,p.categoria_id FROM Produto p "
			+ "WHERE p.id = :ID",nativeQuery = true)
	List<Produto> trazerEstoque(@Param("ID") long id);
}
