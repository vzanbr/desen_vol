package vzan.demo.view.controller;

import jakarta.persistence.PostUpdate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vzan.demo.domain.Produto;
import vzan.demo.service.ProdutoService;
import vzan.demo.shared.ProdutoDTO;
import vzan.demo.view.controller.model.ProdutoRequest;
import vzan.demo.view.controller.model.ProdutoResponse;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    @ResponseStatus
    public ResponseEntity<List<ProdutoResponse>> listarTodos() {
        List<ProdutoDTO> produtos = service.listarTodos();

        ModelMapper mapper = new ModelMapper();

        List<ProdutoResponse> resposta = produtos.stream()
        .map(produtoDto -> mapper.map(produtoDto, ProdutoResponse.class))
        .collect(Collectors.toList());

        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @GetMapping("/{sku}")
    @ResponseStatus
    public ResponseEntity<Optional<ProdutoResponse>> buscarId(@PathVariable String sku) {
        try {
            Optional<ProdutoDTO> dto = service.buscarId(sku);

            ProdutoResponse produto = new ModelMapper().map(dto.get(), ProdutoResponse.class);

            return new ResponseEntity<>(Optional.of(produto), HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
//    @PostMapping("/produtos/post")
//    public ResponseEntity<Produto> salvarById (@RequestBody Produto produto) {
//        Produto novoProduto = service.salvar(produto);
//        return  new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
//    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> adcionar (@RequestBody ProdutoRequest produtoReq) {
        ModelMapper mapper = new ModelMapper();

        ProdutoDTO produtoDto = mapper.map(produtoReq, ProdutoDTO.class);

        produtoDto = service.adcionar(produtoDto);

        return new ResponseEntity<>(mapper.map(produtoDto, ProdutoResponse.class), HttpStatus.CREATED);
    }
    @PutMapping("/{sku}")
    public ResponseEntity<ProdutoResponse> atualizar (@RequestBody ProdutoRequest produtoReq, @PathVariable String sku) {
        ModelMapper mapper = new ModelMapper();
        ProdutoDTO produtoDto = mapper.map(produtoReq, ProdutoDTO.class);

        produtoDto = service.atualizar(sku, produtoDto);

        return new ResponseEntity<>(
                mapper.map(produtoDto, ProdutoResponse.class),
                HttpStatus.OK);
    }
//
//    @PutMapping("/{id}")
//    public Produto update (@RequestBody Produto produto, @PathVariable Integer id) {
//        return ProdutoService.update(id, produto);
//    }


    @DeleteMapping("/{sku}")
    public ResponseEntity<?> deleteById(@PathVariable String sku) {
        service.delete(sku);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
