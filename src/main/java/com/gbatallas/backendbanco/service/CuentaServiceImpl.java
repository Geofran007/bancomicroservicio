package com.gbatallas.backendbanco.service;


import com.gbatallas.backendbanco.service.CuentaService;
import com.gbatallas.backendbanco.entity.Cuenta;
import com.gbatallas.backendbanco.repository.CuentaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaServiceImpl implements CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;
    
    @Override
    public List<Cuenta> findAll() {
      return (List<Cuenta>) cuentaRepository.findAll();
    
    }
    
    @Override
    public Cuenta findbyId(Long id) {
        return cuentaRepository.findById(id).get();
    }

    @Override
    public Cuenta save(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @Override
    public void delete(Long id) {
        cuentaRepository.deleteById(id);
    }

    @Override
    public Cuenta update(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    
}
