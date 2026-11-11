package com.treino.todoapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CriarTarefaDTO {
    
    @NotBlank(message = "O título é obrigatório")
    @Size (max = 100, message = "O título deve ter no máximo 100 caracteres")
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

     public CriarTarefaDTO() {
    }
    
}
