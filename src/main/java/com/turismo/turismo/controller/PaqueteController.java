package com.turismo.turismo.controller;

import com.turismo.turismo.model.Paquete;
import com.turismo.turismo.service.IPaqueteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paquete")
public class PaqueteController {
    @Autowired
    private IPaqueteService paqueteService;

    @PostMapping("/savePaquete")
    public ResponseEntity<String> savePaquete(@RequestBody Paquete paquete){
        paqueteService.savePaquete(paquete);
        return ResponseEntity.ok("Paquete agregado correctamente");
    }

    @PutMapping("/editPaquete/{id}")
    public ResponseEntity<Paquete> editPaquete(@PathVariable Long id,
                                               @RequestBody Paquete paqueteModif){
        return ResponseEntity.ok(paqueteService.editPaquete(id, paqueteModif));
    }

    @PutMapping("/deletePaquete/{id}")
    public ResponseEntity<String> deletePaquete(@PathVariable Long id){
        paqueteService.deletePaquete(id);
        return ResponseEntity.ok("Paquete "+id+" inactivado correctamente");
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Paquete>> listPaquetes(){
        return ResponseEntity.ok(paqueteService.listPaquete());
    }

    @GetMapping("/findPaquetePorId/{id}")
    public ResponseEntity<Paquete> findPaquete(@PathVariable Long id){
        return ResponseEntity.ok(paqueteService.findPaquetePorId(id));
    }
}

