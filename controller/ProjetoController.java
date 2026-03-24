package com.example.projeto.controller;

import com.example.projeto.entity.Projeto;
import com.example.projeto.service.ProjetoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    private final ProjetoService service;

    public ProjetoController(ProjetoService service) {
        this.service = service;
    }

    @PostMapping
    public Projeto criar(@RequestBody Projeto projeto) {
        return service.salvar(projeto);
    }

    @GetMapping
    public List<Projeto> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Projeto buscar(@PathVariable Long id) {
        return service.buscarPorId(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
