package com.gbatallas.backendbanco.service;


import com.gbatallas.backendbanco.entity.Cuenta;
import com.gbatallas.backendbanco.service.MovimientoService;
import com.gbatallas.backendbanco.entity.Movimiento;
import com.gbatallas.backendbanco.repository.MovimientoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimeintoServiceImpl implements MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;
    
    @Autowired
    private CuentaService cuentaService;
    
    @Override
    public List<Movimiento> findAll() {
      return (List<Movimiento>) movimientoRepository.findAll();
    
    }
    
    @Override
    public Movimiento findbyId(Long id) {
        return movimientoRepository.findById(id).get();
    }

    @Override
    public Movimiento save(Movimiento movimiento) {
        
         Cuenta cuentaActual = cuentaService.findbyId(movimiento.getIdcuenta().getIdcuenta());
         Movimiento ultimoMovimiento = movimientoRepository.findTopByIdcuenta_IdcuentaOrderByFechaDescIdmovimientoDesc(movimiento.getIdcuenta().getIdcuenta());

         Long saldoanterior ;

         if (ultimoMovimiento == null){
             
             saldoanterior= cuentaActual.getSaldoinicial();
             movimiento.setSaldo(saldoanterior + movimiento.getValor());
         }else{
             
             movimiento.setSaldo(ultimoMovimiento.getSaldo()+ movimiento.getValor());
         }
         
         if (movimiento.getSaldo()<0){
             throw new IllegalArgumentException("Saldo no disponible");
         }
             
       return movimientoRepository.save(movimiento);
    }

    @Override
    public void delete(Long id) {
        movimientoRepository.deleteById(id);
    }

    @Override
    public Movimiento update(Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }
    
 

    
}
