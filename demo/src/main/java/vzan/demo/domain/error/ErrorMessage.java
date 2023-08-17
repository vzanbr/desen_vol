package vzan.demo.domain.error;

public class ErrorMessage {
    private String titulo;
    private String descricao;
    private String mensagem;
    private Integer status;

    public ErrorMessage(String titulo, String descricao, String mensagem, Integer status) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.mensagem = mensagem;
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
