package com.gbatallas.backendbanco.service;


import com.gbatallas.backendbanco.entity.Cuenta;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gfbat
 */
public interface CuentaService {

    public List<Cuenta> findAll();

    public Cuenta findbyId(Long id);

    public Cuenta save(Cuenta cuenta);

    public void delete(Long id);

    public Cuenta update(Cuenta cuenta);

}
