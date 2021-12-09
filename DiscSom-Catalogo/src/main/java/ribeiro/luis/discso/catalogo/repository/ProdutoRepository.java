package ribeiro.luis.discso.catalogo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ribeiro.luis.discso.catalogo.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
	List<Produto> findByDescricao(String descricao);

	List<Produto> findByIdIn(List<Long> ids);
}
