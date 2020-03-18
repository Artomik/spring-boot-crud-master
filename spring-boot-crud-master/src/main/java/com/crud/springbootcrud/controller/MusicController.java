package com.crud.springbootcrud.controller;

import com.crud.springbootcrud.entities.Music;
import com.crud.springbootcrud.repositories.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MusicController {
	
	private final MusicRepository musicRepository;

    @Autowired
    public MusicController(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @GetMapping("/signup")
    public String showSignUpForm(Music music) {
        return "add-music";
    }

    @PostMapping("/addmusic")
    public String addMusic(@Valid Music music, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-music";
        }

        musicRepository.save(music);
        model.addAttribute("musics", musicRepository.findAll());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Music music = musicRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid music Id:" + id));
        model.addAttribute("musics", music);
        return "update-music";
    }

    @PostMapping("/update/{id}")
    public String updateMusic(@PathVariable("id") long id, @Valid Music music, BindingResult result, Model model) {
        if (result.hasErrors()) {
            music.setId(id);
            return "update-music";
        }

        musicRepository.save(music);
        model.addAttribute("musics", musicRepository.findAll());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteMusic(@PathVariable("id") long id, Model model) {
        Music music = musicRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        musicRepository.delete(music);
        model.addAttribute("musics", musicRepository.findAll());
        return "index";
    }
}
