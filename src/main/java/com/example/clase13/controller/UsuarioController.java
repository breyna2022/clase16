/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.clase13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author DELL
 */
@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    @GetMapping("/listar")
    public String index(){
        return "usuarios/user";
    }
    @GetMapping("/listar2")
    public String aa(){
        return "usuarios/user";
    }
}
