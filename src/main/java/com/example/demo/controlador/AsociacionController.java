package com.example.demo.controlador;

import com.example.demo.entidades.Asociacion;
import com.example.demo.repositorios.AsociacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/asociaciones")
public class AsociacionController {

    @Autowired
    private AsociacionRepository repo;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("asociaciones", repo.findAll());
        return "asociaciones/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("asociacion", new Asociacion());
        return "asociaciones/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Asociacion asociacion) {
        repo.save(asociacion);
        return "redirect:/asociaciones";
    }
}