package com.turismo.turismo.service;


import com.turismo.turismo.model.Servicio;

import java.util.List;

public interface IServicioService {
    void saveServicio(Servicio servicio);

    Servicio editServicio(Long idServicio, Servicio servicioModificado);

    void deleteServicio(Long idServicio);

    List<Servicio> listServicios();

    Servicio findServicioPorId(Long idServicio);
}
