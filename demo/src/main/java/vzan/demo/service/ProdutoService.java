package vzan.demo.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vzan.demo.domain.Produto;
import vzan.demo.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository   repository;
    public List<Produto> listarTodos() {
        return (List<Produto>) repository.findAll();
    }

    public Produto salvar(Produto produto){
        return repository.save(produto);
    }

    public Optional<Produto> buscarId(String sku) {
        return repository.findById(sku);
    }

    public void delete(String sku) {
        repository.deleteById(sku);
    }

}
