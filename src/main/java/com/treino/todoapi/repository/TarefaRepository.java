package com.treino.todoapi.repository;

import com.treino.todoapi.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    
    List<Tarefa> findByConcluida(boolean concluida);
}