package com.turismo.turismo.controller;

import com.turismo.turismo.model.Cliente;
import com.turismo.turismo.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private IClienteService clienteService;

    @PostMapping("/saveCliente")
    public ResponseEntity<String> saveCliente(@RequestBody Cliente cliente){
        clienteService.saveCliente(cliente);
        return ResponseEntity.ok("Cliente Agregado correctamente");
    }

    @PutMapping("/editCliente/{idCliente}")
    public ResponseEntity<Cliente> editCliente(@PathVariable Long id,
                                               @RequestBody Cliente clienteModif){
        return ResponseEntity.ok(clienteService.editCliente(id,clienteModif));
    }

    @PutMapping("/deleteCliente/{idCliente}")
    public ResponseEntity<String> deleteCliente(@PathVariable Long id){
        clienteService.deleteCliente(id);
        return ResponseEntity.ok("Cliente"+id+"inactivado correctamente");
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Cliente>> listClientes(){
        return ResponseEntity.ok(clienteService.listClientes());
    }

    @GetMapping("/findClientePorId/{id}")
    public ResponseEntity<Cliente> findCliente(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.findClientePorId(id));
    }

}
