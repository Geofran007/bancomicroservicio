/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.gbatallas.backendbanco.repository;

import com.gbatallas.backendbanco.dto.MovimientoReporteDto;
import com.gbatallas.backendbanco.entity.Movimiento;
import jakarta.persistence.SqlResultSetMapping;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *s
 * @author gfbat
 */
public interface MovimientoRepository extends CrudRepository<Movimiento, Long> {
    
     Long countByIdcuenta_Idcuenta(Long idcuenta);
     
    Movimiento findTopByIdcuenta_IdcuentaOrderByFechaDescIdmovimientoDesc(Long idcuenta);
    
    List<Movimiento> findByFechaBetween(LocalDate inicio, LocalDate fin);
    

    
}
