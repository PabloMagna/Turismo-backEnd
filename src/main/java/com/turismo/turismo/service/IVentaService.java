package com.turismo.turismo.service;

import com.turismo.turismo.model.Venta;

import java.util.List;

public interface IVentaService {
    void saveVenta(Venta venta);

    Venta editVenta(Long numeroVenta, Venta ventaModificada);

    void deleteVenta(Long numeroVenta);

    List<Venta> listVentas();

    Venta findVentaPorNumero(Long numeroVenta);
}
