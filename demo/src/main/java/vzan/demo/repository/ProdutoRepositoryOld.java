package vzan.demo.repository;//package vzan.demo.repository;
//
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//import vzan.demo.domain.Produto;
//import vzan.demo.domain.exception.ResourceNotFoundException;
//
//import java.util.InputMismatchException;
//import java.util.Optional;
//
//
//@Repository
//public interface ProdutoRepository extends CrudRepository<Produto, String> {
//    //    public Produto adcionar(Produto produto){
////        ultimoSku++;
////
////        produto.setSku(ultimoSku);
////        produtos.add(produto);
////            return produto;
////    }
////
////    public Produto update(Produto produto) {
////        Optional<Produto> produtosEncontrado = obterPorId(produto.getId());
////
////        if (produtosEncontrado.isEmpty()) {
////            throw new ResourceNotFoundException("Produto não encontrado!");
////
////        }
//   }