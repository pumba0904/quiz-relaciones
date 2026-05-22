package com.example.demo.controlador;

import com.example.demo.entidades.Club;
import com.example.demo.repositorios.AsociacionRepository;
import com.example.demo.repositorios.ClubRepository;
import com.example.demo.repositorios.CompeticionRepository;
import com.example.demo.repositorios.EntrenadorRepository;
import com.example.demo.repositorios.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clubes")
public class ClubController {

    @Autowired
    private ClubRepository repo;
    @Autowired
    private EntrenadorRepository entrenadorRepo;
    @Autowired
    private AsociacionRepository asociacionRepo;
    @Autowired
    private CompeticionRepository competicionRepo;
    @Autowired
    private JugadorRepository jugadorRepo;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("clubes", repo.findAll());
        return "clubes/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("club", new Club());
        model.addAttribute("entrenadores", entrenadorRepo.findAll());
        model.addAttribute("asociaciones", asociacionRepo.findAll());
        model.addAttribute("competiciones", competicionRepo.findAll());
        model.addAttribute("jugadores", jugadorRepo.findAll());
        return "clubes/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Club club) {
        repo.save(club);
        return "redirect:/clubes";
    }
}