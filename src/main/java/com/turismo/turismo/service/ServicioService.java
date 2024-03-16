package com.turismo.turismo.service;

import com.turismo.turismo.model.Servicio;
import com.turismo.turismo.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioService implements IServicioService {
    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public void saveServicio(Servicio servicio) {
        try {
            servicioRepository.save(servicio);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Servicio editServicio(Long idServicio, Servicio servicioModificado) {
        try {
            Servicio servicioExistente = servicioRepository.findById(idServicio).orElse(null);

            if (servicioExistente != null && servicioModificado != null) {
                servicioExistente.setNombre(servicioModificado.getNombre());
                servicioExistente.setDescripcion(servicioModificado.getDescripcion());
                servicioExistente.setDestino(servicioModificado.getDestino());
                servicioExistente.setFecha(servicioModificado.getFecha());
                servicioExistente.setPrecio(servicioModificado.getPrecio());
                servicioExistente.setImagen(servicioModificado.getImagen());
                servicioExistente.setEstadoServicio(servicioModificado.getEstadoServicio());

                return servicioRepository.save(servicioExistente);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteServicio(Long idServicio) {
        try {
            Servicio aux = servicioRepository.findById(idServicio).orElse(null);
            if (aux != null) {
                servicioRepository.delete(aux);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Servicio> listServicios() {
        try {
            return servicioRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Servicio findServicioPorId(Long idServicio) {
        try {
            return servicioRepository.findById(idServicio).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
