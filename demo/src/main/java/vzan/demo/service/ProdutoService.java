package vzan.demo.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vzan.demo.domain.Produto;
import vzan.demo.domain.exception.ResourceNotFoundException;
import vzan.demo.repository.ProdutoRepository;
import vzan.demo.shared.ProdutoDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<ProdutoDTO> listarTodos() {
        //Retorna uma lista de Produto modelo
         List<Produto> produtos = repository.findAll();

         return produtos.stream()
                 .map(produto -> new ModelMapper().map(produto, ProdutoDTO.class))
                 .collect(Collectors.toList());

    }

//    public Produto salvar(Produto produto){
//        return repository.save(produto);
//    }
    public ProdutoDTO adcionar(ProdutoDTO produtoDto){
        //Removendo o id para conseguir fazer o cadastro.
        produtoDto.setSku(null);

        //Criar um objeto de mapeamento
        ModelMapper mapper = new ModelMapper();

        //Converter o ProdutoDTO em um Produto
        Produto produto = mapper.map(produtoDto, Produto.class);

        //Salvar o produto no banco
        produto = repository.save(produto);
        produtoDto.setSku(produto.getSku());

        //Retornar o ProdutoDTO atualizado
        return produtoDto;
    }

    public Optional<ProdutoDTO> buscarId(String sku) {
        //Obtendo Optinal pela Sku
        Optional<Produto> produto = repository.findById(sku);
        //Se não encontrar, Lançar Exception
        if (produto.isEmpty()){
            throw new ResourceNotFoundException("Produto Com Sku " + sku + " não encontrado");
        }
        //Convertendo meu Optinal em um produtoDTO
        ProdutoDTO dto = new ModelMapper().map(produto.get(), ProdutoDTO.class);
        //Criando e retornando um optinal de produtoDTO
        return Optional.of(dto);
    }
    public ProdutoDTO atualizar (String sku, ProdutoDTO produtoDto) {
        //Passar o id para o produtoDto.
        produtoDto.setSku(sku);

        //Criar um objeto de mapeamento.
        ModelMapper mapper = new ModelMapper();

        //Conveerter o ProdutoDTO em um Produto.
        Produto produto = mapper.map(produtoDto, Produto.class);

        //Atualizar o produto no Bancos de dados.
        repository.save(produto);

        //Retornar o produto do dto atualizado.
        return produtoDto;
    }
    public void delete(String sku) {
        //Verificar se o Produto existe!
        Optional<Produto> produto = repository.findById(sku);

        //Se não existir lança uma exception
        if(produto.isEmpty()){
            throw new ResourceNotFoundException("Não foi Possivel Deletar o Produto com o sku " + sku + "Produto não existe");
        }
        //Deleta o produto pela sku
        repository.deleteById(sku);
    }

}
