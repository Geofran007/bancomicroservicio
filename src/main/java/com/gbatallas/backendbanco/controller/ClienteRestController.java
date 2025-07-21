/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gbatallas.backendbanco.controller;

import com.gbatallas.backendbanco.dto.ClientePersonaDto;
import com.gbatallas.backendbanco.entity.Cliente;
import com.gbatallas.backendbanco.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("cliente")
public class ClienteRestController {
    
    @Autowired
    private ClienteService clienteService;
    
       @GetMapping("/get") 
       public List<ClientePersonaDto> index(){
           return clienteService.findAllClientesConPersona();
       }
       
       @GetMapping("/get/{id}")
       public ClientePersonaDto show(@PathVariable Long id) {
        return clienteService.findClienteconPersonabyId(id);
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente createClienteConPersona(@RequestBody ClientePersonaDto dto) {
        return clienteService.saveClienteConPersona(dto);
    }

    @PutMapping("/put/{id}")
    public Cliente updateClienteConPersona(@RequestBody ClientePersonaDto dto) {
        return clienteService.updateClientePersona(dto);
    }
    
    @DeleteMapping("/delete/{id}")
    public ClientePersonaDto deleteClienteConPersona(@PathVariable Long id) {
        return clienteService.deleteClienteConPersona(id);
    }


}
