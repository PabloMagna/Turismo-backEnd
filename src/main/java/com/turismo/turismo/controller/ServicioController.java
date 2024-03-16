package com.turismo.turismo.controller;

import com.turismo.turismo.model.Servicio;
import com.turismo.turismo.service.IServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicio")
public class ServicioController {
    @Autowired
    private IServicioService servicioService;

    @PostMapping("/saveServicio")
    public ResponseEntity<String> saveServicio(@RequestBody Servicio servicio){
        servicioService.saveServicio(servicio);
        return ResponseEntity.ok("Servicio agregado correctamente");
    }

    @PutMapping("/editServicio/{codigo}")
    public ResponseEntity<Servicio> editServicio(@PathVariable Long codigo,
                                                 @RequestBody Servicio servicioModif){
        return ResponseEntity.ok(servicioService.editServicio(codigo, servicioModif));
    }

    @PutMapping("/deleteServicio/{codigo}")
    public ResponseEntity<String> deleteServicio(@PathVariable Long codigo){
        servicioService.deleteServicio(codigo);
        return ResponseEntity.ok("Servicio "+codigo+" inactivado correctamente");
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Servicio>> listServicios(){
        return ResponseEntity.ok(servicioService.listServicios());
    }

    @GetMapping("/findServicioPorCodigo/{codigo}")
    public ResponseEntity<Servicio> findServicio(@PathVariable Long codigo){
        return ResponseEntity.ok(servicioService.findServicioPorId(codigo));
    }
}
