package com.turismo.turismo.service;

import com.turismo.turismo.enums.EstadoPaquete;
import com.turismo.turismo.model.Paquete;
import com.turismo.turismo.repository.PaqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaqueteService implements IPaqueteService {
    @Autowired
    private PaqueteRepository paqueteRepository;
    @Override
    public void savePaquete(Paquete paquete) {
        try {
            paqueteRepository.save(paquete);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Paquete editPaquete(Long idPaquete, Paquete paqueteModificado) {
        try {
            Paquete paqueteExistente = paqueteRepository.findById(idPaquete).orElse(null);

            if (paqueteExistente != null && paqueteModificado != null) {
                paqueteExistente.setServicios(paqueteModificado.getServicios());
                paqueteExistente.setCostoPaquete(paqueteModificado.getCostoPaquete());
                paqueteExistente.setEstadoPaquete(paqueteModificado.getEstadoPaquete());

                return paqueteRepository.save(paqueteExistente);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deletePaquete(Long idPaquete) {
        try {
            Paquete aux = paqueteRepository.findById(idPaquete).orElse(null);
            if (aux != null) {
                aux.setEstadoPaquete(EstadoPaquete.INACTIVO);
                paqueteRepository.save(aux);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Paquete> listPaquete() {
        try {
            return paqueteRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Paquete findPaquetePorId(Long idPaquete) {
        try {
            return paqueteRepository.findById(idPaquete).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
