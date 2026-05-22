package com.example.demo.controlador;

import com.example.demo.entidades.Jugador;
import com.example.demo.repositorios.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorRepository repo;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("jugadores", repo.findAll());
        return "jugadores/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("jugador", new Jugador());
        return "jugadores/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Jugador jugador) {
        repo.save(jugador);
        return "redirect:/jugadores";
    }
}