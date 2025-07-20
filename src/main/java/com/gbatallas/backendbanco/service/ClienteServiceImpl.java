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
    public ClientePersonaDto findClienteconPersonabyId(Long id) {
        
        Cliente cliente = clienteRepository.findById(id).get();

        Persona persona = cliente.getIdpersona();

        ClientePersonaDto dto = new ClientePersonaDto();
        dto.setContrasenia(cliente.getContrasenia());
        dto.setEstado(cliente.getEstado());

        dto.setNombre(persona.getNombre());
        dto.setGenero(persona.getGenero());
        dto.setEdad(persona.getEdad());
        dto.setIdentificacion(persona.getIdentificacion());
        dto.setDireccion(persona.getDireccion());
        dto.setTelefono(persona.getTelefono());

        return dto;
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    
    @Override
    public Cliente saveClienteConPersona(ClientePersonaDto dto) {

        Persona persona = new Persona();
        persona.setNombre(dto.getNombre());
        persona.setGenero(dto.getGenero());
        persona.setEdad(dto.getEdad());
        persona.setIdentificacion(dto.getIdentificacion());
        persona.setDireccion(dto.getDireccion());
        persona.setTelefono(dto.getTelefono());

        Persona personaGuardada = personaRepository.save(persona);

        Cliente cliente = new Cliente();
        cliente.setContrasenia(dto.getContrasenia());
        cliente.setEstado(dto.getEstado());
        cliente.setIdpersona(personaGuardada); // Asocia la persona

        return clienteRepository.save(cliente);
    }
    
        @Override
    public Cliente update(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente updateClientePersona(ClientePersonaDto dto) {

        // Buscar cliente existente por id
        Cliente clienteExistente = clienteRepository.findById(dto.getIdcliente()).get();

        // Obtener la persona asociada y actualizar campos
        Persona personaExistente = clienteExistente.getIdpersona();

        personaExistente.setNombre(dto.getNombre());
        personaExistente.setGenero(dto.getGenero());
        personaExistente.setEdad(dto.getEdad());
        personaExistente.setIdentificacion(dto.getIdentificacion());
        personaExistente.setDireccion(dto.getDireccion());
        personaExistente.setTelefono(dto.getTelefono());

        personaRepository.save(personaExistente);

        // Actualizar campos de cliente
        clienteExistente.setContrasenia(dto.getContrasenia());
        clienteExistente.setEstado(dto.getEstado());

        return clienteRepository.save(clienteExistente);
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
    
    
    @Override
    public ClientePersonaDto deleteClienteConPersona(Long id) {
    
    Cliente clienteExistente = clienteRepository.findById(id).get();
    Persona persona = clienteExistente.getIdpersona();


    ClientePersonaDto dto = new ClientePersonaDto();
    //dto.setIdCliente(clienteExistente.getIdcliente());
    dto.setContrasenia(clienteExistente.getContrasenia());
    dto.setEstado(clienteExistente.getEstado());
    //dto.setIdPersona(persona.getIdpersona());
    dto.setNombre(persona.getNombre());
    dto.setGenero(persona.getGenero());
    dto.setEdad(persona.getEdad());
    dto.setIdentificacion(persona.getIdentificacion());
    dto.setDireccion(persona.getDireccion());
    dto.setTelefono(persona.getTelefono());

    // Primero eliminamos el cliente
    clienteRepository.delete(clienteExistente);

    // (Opcional) Eliminar persona si no tiene más clientes
    if (persona.getClienteList().isEmpty()) {
        personaRepository.delete(persona);
    }

    return dto;
    }

    /**
     * @Override public Cliente updateClientePersona(ClientePersonaDto dto) {
     *
     * Cliente cliente = clienteRepository.findById(dto.getIdCliente())
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










}
