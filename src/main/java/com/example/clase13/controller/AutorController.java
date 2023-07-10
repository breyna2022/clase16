/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.clase13.controller;

import com.example.clase13.entity.Autor;
import com.example.clase13.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author DELL
 */
@Controller
@RequestMapping("/autores")
public class AutorController {
    @Autowired
    private AutorService aservice;
    
    @GetMapping("/listar")
    public String index(Model model){
        model.addAttribute("autores", aservice.readAll());
        return "autores/autor";
    }
    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("autor", new Autor());
        return "autores/add";
    }
    @PostMapping("/save")
    public String save(@Validated @ModelAttribute Autor autor, BindingResult result, Model model, RedirectAttributes attributes){
        aservice.create(autor);
        return "redirect:/autores/listar";
    }
}
