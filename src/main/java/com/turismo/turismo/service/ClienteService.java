package com.turismo.turismo.service;

import com.turismo.turismo.enums.EstadoCliente;
import com.turismo.turismo.model.Cliente;
import com.turismo.turismo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public void saveCliente(Cliente cliente){
        try {
            clienteRepository.save(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Cliente editCliente(Long idCliente, Cliente clienteModificado) {
        try {
            Cliente clienteExistente = clienteRepository.findById(idCliente).orElse(null);

            if (clienteExistente != null && clienteModificado != null) {
                clienteExistente.setNombre(clienteModificado.getNombre());
                clienteExistente.setApellido(clienteModificado.getApellido());
                clienteExistente.setDireccion(clienteModificado.getDireccion());
                clienteExistente.setDni(clienteModificado.getDni());
                clienteExistente.setFechaNacimiento(clienteModificado.getFechaNacimiento());
                clienteExistente.setNacionalidad(clienteModificado.getNacionalidad());
                clienteExistente.setCelular(clienteModificado.getCelular());
                clienteExistente.setEmail(clienteModificado.getEmail());
                clienteExistente.setCargo(clienteModificado.getCargo());
                clienteExistente.setSueldo(clienteModificado.getSueldo());
                clienteExistente.setEstadoCliente(clienteModificado.getEstadoCliente());

                return clienteRepository.save(clienteExistente);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteCliente(Long idCliente){
        try {
            Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
            if (cliente != null) {
                cliente.setEstadoCliente(EstadoCliente.INACTIVO);
                clienteRepository.save(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<Cliente> listClientes(){
        try {
            return clienteRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
           return null;
        }
    }

    public Cliente findClientePorId(Long idCliente){
        try {
            return clienteRepository.findById(idCliente).orElse(null);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
