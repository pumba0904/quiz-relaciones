package com.example.demo.controlador;

import com.example.demo.entidades.Entrenador;
import com.example.demo.repositorios.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorRepository repo;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("entrenadores", repo.findAll());
        return "entrenadores/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("entrenador", new Entrenador());
        return "entrenadores/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Entrenador entrenador) {
        repo.save(entrenador);
        return "redirect:/entrenadores";
    }
}