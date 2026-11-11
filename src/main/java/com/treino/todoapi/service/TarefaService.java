package com.treino.todoapi.service;

import org.springframework.stereotype.Service;
import com.treino.todoapi.entity.Tarefa;
import com.treino.todoapi.repository.TarefaRepository;
import com.treino.todoapi.exception.RecursoNaoEncontradoException;
import com.treino.todoapi.dto.AtualizarTarefaDTO;
import java.util.List;

@Service
public class TarefaService {
    
    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public Tarefa salvar(Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> ListarTodas(){
        return tarefaRepository.findAll();
    }

    public List<Tarefa> ListarPorStatus(boolean concluida) {
        return tarefaRepository.findByConcluida(concluida);
    }

    public Tarefa atualizar(Long id, AtualizarTarefaDTO dto) {
        Tarefa tarefa = buscarPorId(id);
        tarefa.setTitulo(dto.getTitulo());
        tarefa.setDescricao(dto.getDescricao());    
        tarefa.setConcluida(dto.getConcluida());
        return tarefaRepository.save(tarefa);
    }

    public Tarefa buscarPorId(Long id) {
        return tarefaRepository.findById(id)
            .orElseThrow(() -> new RecursoNaoEncontradoException("Tarefa não encontrada com o ID: " + id));
    }

    public void excluir(Long id) {
        Tarefa tarefa = buscarPorId(id);
        tarefaRepository.delete(tarefa);
    }
}
