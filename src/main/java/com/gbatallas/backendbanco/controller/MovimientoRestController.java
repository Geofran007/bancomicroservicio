/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gbatallas.backendbanco.controller;

import com.gbatallas.backendbanco.entity.Movimiento;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gbatallas.backendbanco.service.MovimientoService;
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
@RequestMapping("/movimiento")
public class MovimientoRestController {
    
    @Autowired
    private MovimientoService movimientoService;
    
    
    @GetMapping("/get")
    public List<Movimiento> index(){
        return movimientoService.findAll();
    }
    
    @GetMapping("/get/{id}")
    public Movimiento show(@PathVariable Long id){
        return movimientoService.findbyId(id);
    }
    
    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Movimiento create(@RequestBody Movimiento movimiento){
        return movimientoService.save(movimiento);
    }
    
    @PutMapping("/put")
    public Movimiento update(@RequestBody Movimiento movimiento){
        return movimientoService.update(movimiento);
    }
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        movimientoService.delete(id);
    }
    
}
