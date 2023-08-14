package vzan.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vzan.demo.domain.Produto;
//import vzan.demo.systemdb.SqlQuery;

import java.util.List;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, String> {

//    @SqlQuery
//    List findByiD(@Param("id") long id);
}
