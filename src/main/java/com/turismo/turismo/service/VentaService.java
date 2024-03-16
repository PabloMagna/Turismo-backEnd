package com.turismo.turismo.service;

import com.turismo.turismo.model.Venta;
import com.turismo.turismo.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService implements IVentaService {
    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public void saveVenta(Venta venta) {
        try {
            ventaRepository.save(venta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Venta editVenta(Long numeroVenta, Venta ventaModificada) {
        try {
            Venta ventaExistente = ventaRepository.findById(numeroVenta).orElse(null);

            if (ventaExistente != null && ventaModificada != null) {
                ventaExistente.setFecha(ventaModificada.getFecha());
                ventaExistente.setMedioPago(ventaModificada.getMedioPago());
                ventaExistente.setCliente(ventaModificada.getCliente());
                ventaExistente.setPaquete(ventaModificada.getPaquete());
                ventaExistente.setEmpleado(ventaModificada.getEmpleado());
                ventaExistente.setEstadoVenta(ventaModificada.getEstadoVenta());

                return ventaRepository.save(ventaExistente);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteVenta(Long numeroVenta) {
        try {
            Venta venta = ventaRepository.findById(numeroVenta).orElse(null);
            if (venta != null) {
                ventaRepository.delete(venta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Venta> listVentas() {
        try {
            return ventaRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Venta findVentaPorNumero(Long numeroVenta) {
        try {
            return ventaRepository.findById(numeroVenta).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

