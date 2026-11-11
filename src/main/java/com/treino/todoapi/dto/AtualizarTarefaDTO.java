package com.treino.todoapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AtualizarTarefaDTO {

    @NotBlank(message = "O título da tarefa não pode ser vazio")
    @Size (max = 100, message = "O título da tarefa não pode ter mais de 100 caracteres")
    private String titulo;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @NotNull(message = "O status da tarefa não pode ser nulo")
    private Boolean concluida;

    public Boolean getConcluida() {
        return concluida;
    }

    public void setConcluida(Boolean concluida) {
        this.concluida = concluida;
    }

    public AtualizarTarefaDTO() {
    }

}
