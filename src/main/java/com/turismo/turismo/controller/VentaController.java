package com.turismo.turismo.controller;

import com.turismo.turismo.model.Venta;
import com.turismo.turismo.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venta")
public class VentaController {
    @Autowired
    private IVentaService ventaService;

    @PostMapping("/saveVenta")
    public ResponseEntity<String> saveVenta(@RequestBody Venta venta){
        ventaService.saveVenta(venta);
        return ResponseEntity.ok("Venta agregada correctamente");
    }

    @PutMapping("/editVenta/{numero}")
    public ResponseEntity<Venta> editVenta(@PathVariable Long numero,
                                           @RequestBody Venta ventaModif){
        return ResponseEntity.ok(ventaService.editVenta(numero, ventaModif));
    }

    @PutMapping("/deleteVenta/{numero}")
    public ResponseEntity<String> deleteVenta(@PathVariable Long numero){
        ventaService.deleteVenta(numero);
        return ResponseEntity.ok("Venta "+numero+" inactivada correctamente");
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Venta>> listVentas(){
        return ResponseEntity.ok(ventaService.listVentas());
    }

    @GetMapping("/findVentaPorNumero/{numero}")
    public ResponseEntity<Venta> findVenta(@PathVariable Long numero){
        return ResponseEntity.ok(ventaService.findVentaPorNumero(numero));
    }
}

