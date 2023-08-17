package vzan.demo.controller;

import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vzan.demo.domain.Produto;
import vzan.demo.service.ProdutoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    @ResponseStatus
    public ResponseEntity <List<Produto>> listaTodos() {
          List<Produto> produtos = service.listarTodos();
          return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{sku}")
    @ResponseStatus
    public ResponseEntity<Produto> buscarId(@PathVariable String sku) {
        Optional<Produto> optProduto = service.buscarId(sku);
        if (optProduto.isEmpty()) {
            return  ResponseEntity.notFound().build();
        }
            return ResponseEntity.ok(optProduto.get());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Produto> salvarById (@RequestBody Produto produto) {
        Produto novoProduto = service.salvar(produto);
        return  new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
    }

//    @PostMapping
//    public Produto adcionar (@RequestBody Produto produto) {
//        return service.adcionar(produto);
//    }
    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Produto> alterarById (@RequestBody Produto produto) {
        Produto produtoAlterado = service.salvar(produto);
        return ResponseEntity.ok(produtoAlterado);
    }

//    @PutMapping("/{sku}")
//    public Produto atualziar (@RequestBody Produto produto, @PathVariable String sku) {
//        return ProdutoService.atualizar(sku, produto);
//    }


    @DeleteMapping("/{sku}")
    public String deleteById(@PathVariable String sku) {
        service.delete(sku);
        return "Produto com id " + sku + " Foi deletado Com Sucesso!";
    }
}
