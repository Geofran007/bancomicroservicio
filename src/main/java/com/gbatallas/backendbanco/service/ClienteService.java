/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gbatallas.backendbanco.service;
import com.gbatallas.backendbanco.dto.ClientePersonaDto;
import com.gbatallas.backendbanco.entity.Cliente;
import java.util.List;

/**
 *
 * @author gfbat
 */
public interface ClienteService {
    
    public List<Cliente> findAll();
    
    public Cliente findbyId(Long id);
    
    public Cliente save(Cliente cliente);
    
    public Cliente saveClienteConPersona(ClientePersonaDto dto);
    
    public void delete(Long id);
    
    public Cliente update(Cliente cliente);
    
    
    public List<ClientePersonaDto> findAllClientesConPersona();
    
    public ClientePersonaDto findClienteconPersonabyId(Long id);
    
    public ClientePersonaDto deleteClienteConPersona(Long id); 
    
    public Cliente updateClientePersona(ClientePersonaDto dto);
}
