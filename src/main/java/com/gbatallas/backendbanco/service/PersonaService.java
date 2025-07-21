/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gbatallas.backendbanco.service;
import com.gbatallas.backendbanco.entity.Persona;
import java.util.List;

/**
 *
 * @author gfbat
 */
public interface PersonaService {
    
    public List<Persona> findAll();
    
    public Persona findbyId(Long id);
    
    public Persona save(Persona persona);
    
    public void delete (Long id);
    

    
}
