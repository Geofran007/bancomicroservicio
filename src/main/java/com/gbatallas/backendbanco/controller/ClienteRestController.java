/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gbatallas.backendbanco.controller;

import com.gbatallas.backendbanco.entity.Cliente;
import com.gbatallas.backendbanco.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gfbat
 */
@RestController
@RequestMapping("")
public class ClienteRestController {
    
    @Autowired
    private ClienteService clienteService;
    
       @GetMapping("/cliente") 
       public List<Cliente> index(){
           return clienteService.findAll();
       }
       
       @GetMapping("/cliente/{id}")
       public Cliente show(@PathVariable Long id ){
           return clienteService.findbyId(id);
       }
       
       @PostMapping("/cliente")
       @ResponseStatus(HttpStatus.CREATED)//201
       public Cliente create(@RequestBody Cliente cliente){
           return clienteService.save(cliente);
       }
       
       
}
