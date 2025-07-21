/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gbatallas.backendbanco.dto;

import java.util.Date;

/**
 *
 * @author gfbat
 */
public class MovimientoReporteDto {
    

    //Tabla Movimiento
    private Date fecha;
    private String cliente;
    private Long numeroCuenta;
    private Long valor;
    private Boolean estado;
    private Long saldoDisponible;

    //Tabla Cuenta

    private String tipo;

    
    
}
