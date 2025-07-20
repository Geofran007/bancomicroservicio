/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gbatallas.backendbanco.service;

import com.gbatallas.backendbanco.dto.ClientePersonaDto;
import com.gbatallas.backendbanco.entity.Cliente;
import com.gbatallas.backendbanco.entity.Persona;
import com.gbatallas.backendbanco.repository.ClienteRepository;
import com.gbatallas.backendbanco.repository.PersonaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gfbat
 */

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PersonaRepository personaRepository;
    
    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll();
    }
    
        
@Override
public List<ClientePersonaDto> findAllClientesConPersona() {
    Iterable<Cliente> clientesIterable = clienteRepository.findAll();

    List<ClientePersonaDto> dtos = new ArrayList<>();
    clientesIterable.forEach(cliente -> {
        Persona persona = cliente.getIdpersona();

        ClientePersonaDto dto = new ClientePersonaDto();
        // No seteamos ids porque no están en el DTO
        dto.setContrasenia(cliente.getContrasenia());
        dto.setEstado(cliente.getEstado());

        dto.setNombre(persona.getNombre());
        dto.setGenero(persona.getGenero());
        dto.setEdad(persona.getEdad());
        dto.setIdentificacion(persona.getIdentificacion());
        dto.setDireccion(persona.getDireccion());
        dto.setTelefono(persona.getTelefono());

        dtos.add(dto);
    });

    return dtos;
}
                    
 
    @Override
    public Cliente findbyId(Long id) {
            return clienteRepository.findById(id).get();
    }
    
    

    @Override
    public Cliente save(Cliente cliente) {
           return clienteRepository.save(cliente);
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
    
    
/**
    @Override
    public Cliente updateClientePersona(ClientePersonaDto dto) {
    
        Cliente cliente = clienteRepository.findById(dto.getIdCliente())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Persona persona = personaRepository.findById(dto.getIdPersona())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        // Actualizar Persona
        persona.setNombre(dto.getNombre());
        persona.setGenero(dto.getGenero());
        persona.setEdad(dto.getEdad());
        persona.setIdentificacion(dto.getIdentificacion());
        persona.setDireccion(dto.getDireccion());
        persona.setTelefono(dto.getTelefono());
        personaRepository.save(persona);

        // Actualizar Cliente
        cliente.setContrasenia(dto.getContrasenia());
        cliente.setEstado(dto.getEstado());
        cliente.setIdpersona(persona); 
        return clienteRepository.save(cliente);
    }

*/

    @Override
    public ClientePersonaDto findClienteconPersona(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ClientePersonaDto saveClienteConPersona() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ClientePersonaDto deleteClienteConPersona(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente updateClientePersona(ClientePersonaDto dto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
