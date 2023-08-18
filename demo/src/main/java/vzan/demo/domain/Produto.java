package vzan.demo.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id // vai transformar essa coluna em first key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String sku;
    private String nome;
    private String descricao;
    private Integer id;
    private Double valor;
    private Integer quantidade;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

}


