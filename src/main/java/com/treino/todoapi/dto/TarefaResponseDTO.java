package com.treino.todoapi.dto;

import java.time.LocalDateTime;

import com.treino.todoapi.entity.Tarefa;

public class TarefaResponseDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private boolean concluida;
    private LocalDateTime dataCriacao;


    public TarefaResponseDTO(Tarefa tarefa) {
        this.id = tarefa.getId();
        this.titulo = tarefa.getTitulo();
        this.descricao = tarefa.getDescricao();
        this.concluida = tarefa.getConcluida();
        this.dataCriacao = tarefa.getDataCriacao();
    }


    public Long getId() {
        return id;
    }


    public String getTitulo() {
        return titulo;
    }


    public String getDescricao() {
        return descricao;
    }


    public boolean getConcluida() {
        return concluida;
    }


    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    
}
