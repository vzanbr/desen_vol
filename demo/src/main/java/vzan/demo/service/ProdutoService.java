package vzan.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vzan.demo.domain.Produto;
import vzan.demo.repository.ProdutoRepository;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;
    public List<Produto> listarTodos() {
        return (List<Produto>) repository.findAll();
    }

    public Produto salvar(Produto produto){
        return repository.save(produto);
    }

    public Produto buscarId(String sku) {
        return repository.findById(sku).get();
    }

    public void delete(String sku) {
        repository.deleteById(sku);
    }

}
