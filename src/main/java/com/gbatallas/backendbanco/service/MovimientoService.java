package com.gbatallas.backendbanco.service;


import com.gbatallas.backendbanco.dto.MovimientoReporteDto;
import com.gbatallas.backendbanco.entity.Movimiento;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gfbat
 */
public interface MovimientoService {

    public List<Movimiento> findAll();

    public Movimiento findbyId(Long id);

    public Movimiento save(Movimiento cuenta);

    public void delete(Long id);

    public Movimiento update(Movimiento movimiento);
    
    public List<MovimientoReporteDto> findByFechaBetween(LocalDate fecinicio, LocalDate fecfin);
    
      

}
