package vzan.demo.controller;

import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vzan.demo.domain.Produto;
import vzan.demo.service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<Produto> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{sku}")
    public Produto buscarId(@PathVariable String sku) {
        Produto produto = service.buscarId(sku);

        if (produto == null) {
            return  null;
        }
            return produto;
    }

    @PostMapping
    public Produto salvar (@RequestBody Produto produto) {
        return service.salvar(produto);
    }

    @PutMapping
    public Produto atualizar (@RequestBody Produto produto) {
        return service.salvar(produto);
    }

    @DeleteMapping("{sku}")
    public void delete(@PathVariable String sku) {
        service.delete(sku);
    }
}
