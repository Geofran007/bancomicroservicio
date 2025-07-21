/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.gbatallas.backendbanco.repository;

import com.gbatallas.backendbanco.entity.Persona;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author gfbat
 */
public interface PersonaRepository extends CrudRepository<Persona, Long> {
    
}
