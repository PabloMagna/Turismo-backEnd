package com.turismo.turismo.service;

import com.turismo.turismo.model.Cliente;
import com.turismo.turismo.model.Paquete;

import java.util.List;

public interface IPaqueteService {
    void savePaquete(Paquete paquete);
    Paquete editPaquete(Long idPaquete, Paquete paqueteModificado);
    void deletePaquete(Long idPaquete);
    List<Paquete> listPaquete();
    Paquete findPaquetePorId(Long idPaquete);
}
