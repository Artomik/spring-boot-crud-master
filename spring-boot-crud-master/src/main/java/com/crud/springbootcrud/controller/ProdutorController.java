package com.crud.springbootcrud.controller;

import com.crud.springbootcrud.entities.Produtor;
import com.crud.springbootcrud.repositories.ProdutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/produtor")
public class ProdutorController {
	
	private final ProdutorRepository produtorRepository;

    @Autowired
    public ProdutorController(ProdutorRepository produtorRepository) {
        this.produtorRepository = produtorRepository;
    }

    @GetMapping("/signup")
    public String showSignUpForm(Produtor produtor) {
        return "add-produtor";
    }

    @PostMapping("/addprodutor")
    public String addProdutor(@Valid Produtor produtor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-produtor";
        }

        produtorRepository.save(produtor);
        model.addAttribute("produtors", produtorRepository.findAll());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Produtor produtor = produtorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid produtor Id:" + id));
        model.addAttribute("produtors", produtor);
        return "update-produtor";
    }

    @PostMapping("/update/{id}")
    public String updateProdutor(@PathVariable("id") long id, @Valid Produtor produtor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            produtor.setId(id);
            return "update-produtor";
        }

        produtorRepository.save(produtor);
        model.addAttribute("produtors", produtorRepository.findAll());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteProdutor(@PathVariable("id") long id, Model model) {
        Produtor produtor = produtorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid produtor Id:" + id));
        produtorRepository.delete(produtor);
        model.addAttribute("produtors", produtorRepository.findAll());
        return "index";
    }
}
