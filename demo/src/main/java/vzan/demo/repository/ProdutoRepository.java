package vzan.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vzan.demo.domain.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, String> {
}
