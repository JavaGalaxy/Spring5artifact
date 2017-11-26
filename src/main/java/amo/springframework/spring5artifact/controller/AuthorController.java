package amo.springframework.spring5artifact.controller;

import amo.springframework.spring5artifact.model.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthorNames(Model model) {
        model.addAttribute("authorsName", authorRepository.findAll());
        return "authorsName";

    }
}
