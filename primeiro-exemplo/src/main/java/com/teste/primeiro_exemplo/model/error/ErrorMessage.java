package com.teste.primeiro_exemplo.model.error;

public class ErrorMessage {
    private String titulo;
    private Integer status;
    private String mensagem;

    public ErrorMessage(String mensagem, Integer status, String titulo) {
        this.mensagem = mensagem;
        this.status = status;
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }


}
