/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gbatallas.backendbanco.controller;

import com.gbatallas.backendbanco.entity.Cuenta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gbatallas.backendbanco.service.CuentaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author gfbat
 */
@RestController
@RequestMapping("/cuenta")
public class CuentaRestController {
    
    @Autowired
    private CuentaService cuentaService;
    
    
    @GetMapping("/get")
    public List<Cuenta> index(){
        return cuentaService.findAll();
    }
    
    @GetMapping("/get/{id}")
    public Cuenta show(@PathVariable Long id){
        return cuentaService.findbyId(id);
    }
    
    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Cuenta create(@RequestBody Cuenta cuenta){
        return cuentaService.save(cuenta);
    }
    
    @PutMapping("/put")
    public Cuenta update(@RequestBody Cuenta cuenta){
        return cuentaService.update(cuenta);
    }
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        cuentaService.delete(id);
    }
    
}
