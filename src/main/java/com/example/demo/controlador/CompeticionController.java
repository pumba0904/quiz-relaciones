package com.example.demo.controlador;

import com.example.demo.entidades.Competicion;
import com.example.demo.repositorios.CompeticionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/competiciones")
public class CompeticionController {

    @Autowired
    private CompeticionRepository repo;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("competiciones", repo.findAll());
        return "competiciones/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("competicion", new Competicion());
        return "competiciones/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Competicion competicion) {
        repo.save(competicion);
        return "redirect:/competiciones";
    }
}