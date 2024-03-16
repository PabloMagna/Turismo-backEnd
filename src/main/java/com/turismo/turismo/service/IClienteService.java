package com.turismo.turismo.service;

import com.turismo.turismo.model.Cliente;

import java.util.List;

public interface IClienteService {
    void saveCliente(Cliente cliente);
    Cliente editCliente(Long idCliente, Cliente clienteModificado);
    void deleteCliente(Long idCliente);
    List<Cliente> listClientes();
    Cliente findClientePorId(Long idCliente);
}
