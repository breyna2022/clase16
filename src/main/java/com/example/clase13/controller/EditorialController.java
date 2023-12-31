/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.clase13.controller;

import com.example.clase13.entity.Autor;
import com.example.clase13.entity.Editorial;
import com.example.clase13.service.AutorService;
import com.example.clase13.service.EditorialService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping(value="/editorial")
public class EditorialController {
    @Autowired
    private EditorialService eservice;
    
    @GetMapping("/listar")
    public List<Editorial> index(){
        return eservice.readAll();
    }
    @GetMapping("/autor/{id}")
    public ResponseEntity<Editorial> autorId(@PathVariable Integer id){
        try {
            Editorial editorial = eservice.read(id);
            return new ResponseEntity<>(editorial, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }
    @PostMapping("/autor")
    public void saveAutor(@RequestBody Editorial editorial){
        eservice.create(editorial);
    }
    @DeleteMapping("/{id}")
    public void deleteEditorial(@PathVariable Integer id){
        eservice.delete(id);
    }

    @PutMapping("/autor/{id}")
    public ResponseEntity<?> updateAutor(@RequestBody Editorial editorial, @PathVariable Integer id){
        try {
            //Autor autor1 = aservice.read(id);
            eservice.update(editorial);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
