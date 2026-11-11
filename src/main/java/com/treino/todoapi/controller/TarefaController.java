package com.treino.todoapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.treino.todoapi.service.TarefaService;

import jakarta.validation.Valid;

import com.treino.todoapi.dto.CriarTarefaDTO;
import com.treino.todoapi.dto.TarefaResponseDTO;
import com.treino.todoapi.entity.Tarefa;
import com.treino.todoapi.dto.AtualizarTarefaDTO;
import java.util.List;


@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public ResponseEntity<List<TarefaResponseDTO>> listarTodas() {
        List<TarefaResponseDTO> tarefas = tarefaService.ListarTodas().stream()
                .map(TarefaResponseDTO::new)
                .toList();
        return ResponseEntity.ok(tarefas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> buscarPorId(@PathVariable Long id) {
        Tarefa tarefa = tarefaService.buscarPorId(id);
        return ResponseEntity.ok(new TarefaResponseDTO(tarefa));
    }

    @PostMapping
    public ResponseEntity<TarefaResponseDTO> salvar(@Valid @RequestBody CriarTarefaDTO dto) {
        Tarefa tarefa = new Tarefa(
        dto.getTitulo(), dto.getDescricao()
        );
       
        Tarefa tarefaSalva = tarefaService.salvar(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(new TarefaResponseDTO(tarefaSalva));
    }

    @GetMapping("/status/{concluida}")
    public ResponseEntity<List<TarefaResponseDTO>> listarPorStatus(@PathVariable boolean concluida) {
        List<TarefaResponseDTO> tarefas = tarefaService.ListarPorStatus(concluida).stream()
                .map(TarefaResponseDTO::new)
                .toList();
        return ResponseEntity.ok(tarefas);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<TarefaResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody AtualizarTarefaDTO dto) {
        Tarefa tarefaAtualizada = tarefaService.atualizar(id, dto);
        return ResponseEntity.ok(new TarefaResponseDTO(tarefaAtualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        tarefaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
