/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gbatallas.backendbanco.controller;

import com.gbatallas.backendbanco.dto.MovimientoReporteDto;
import com.gbatallas.backendbanco.service.MovimientoService;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gfbat
 */
@RestController
@RequestMapping("/reporte")
public class ReporteController {

    @Autowired
    MovimientoService movimientoService;

    @GetMapping
    public ResponseEntity<List<MovimientoReporteDto>> obtenerReporteMovimiento(
            @RequestParam("fechainicio") String fecinicio,
            @RequestParam("fechafin") String fecfin) {

        LocalDate fechaInicio;
        LocalDate fechaFin;

        try {
            fechaInicio = LocalDate.parse(fecinicio);
            fechaFin = LocalDate.parse(fecfin);
        } catch (DateTimeParseException e) {
            return ResponseEntity.badRequest().build();
        }

        List<MovimientoReporteDto> listaDto = movimientoService.findByFechaBetween(fechaInicio, fechaFin);
      
        return ResponseEntity.ok(listaDto);
    }

}
