/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.gbatallas.backendbanco.repository;

import com.gbatallas.backendbanco.entity.Movimiento;
import org.springframework.data.repository.CrudRepository;

/**
 *s
 * @author gfbat
 */
public interface MovimientoRepository extends CrudRepository<Movimiento, Long> {
    
     Long countByIdcuenta_Idcuenta(Long idcuenta);
     
    Movimiento findTopByIdcuenta_IdcuentaOrderByFechaDescIdmovimientoDesc(Long idcuenta);
    
}
