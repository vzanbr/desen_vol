package vzan.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vzan.demo.domain.Produto;

import java.util.InputMismatchException;
import java.util.Optional;


@Repository
public interface ProdutoRepository extends CrudRepository<Produto, String> {
//    public Produto adcionar(Produto produto){
//        ultimoSku++;
//
//        produto.setSku(ultimoSku);
//        produtos.add(produto);
//            return produto;
//    }
//
//    public  atualizar(Produto produto){
//        Optional<Produto> produtosEncontrado = obterPorSku(produto.getSku());
//
//        if(produtosEncontrado.isEmpty()){
//            throw new InputMismatchException("Produto não encontrado!");
//        }
    }
