/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.clase13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author DELL
 */
@Controller
public class HomeController {
    
    @GetMapping("/")
    public String login(){
        return "login";
    }
    @PostMapping("/home")
    public String index(){
        return "index";
    }
    @PostMapping("/logout")
    public String logout(){
        return "login";
    }
}
