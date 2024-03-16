package com.turismo.turismo.servicetest;

import com.turismo.turismo.enums.EstadoCliente;
import com.turismo.turismo.model.Cliente;
import com.turismo.turismo.repository.ClienteRepository;
import com.turismo.turismo.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @Test
    public void testListClientes() {
        // Arrange
        Cliente cliente1 = Cliente.builder()
                .id(1L)
                .nombre("Juan")
                .apellido("Perez")
                .direccion("Direccion 1")
                .dni("123456789")
                .fechaNacimiento(LocalDate.now())
                .nacionalidad("Nacionalidad 1")
                .celular("123456789")
                .email("juan@example.com")
                .cargo("Cargo 1")
                .sueldo("1000")
                .estadoCliente(EstadoCliente.ACTIVO)
                .build();

        Cliente cliente2 = Cliente.builder()
                .id(2L)
                .nombre("Maria")
                .apellido("Gomez")
                .direccion("Direccion 2")
                .dni("987654321")
                .fechaNacimiento(LocalDate.now())
                .nacionalidad("Nacionalidad 2")
                .celular("987654321")
                .email("maria@example.com")
                .cargo("Cargo 2")
                .sueldo("2000")
                .estadoCliente(EstadoCliente.ACTIVO)
                .build();

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);

        // Mockear el método findAll() del clienteRepository
        when(clienteRepository.findAll()).thenReturn(clientes);

        // Llamar al método de servicio a ser probado
        List<Cliente> result = clienteService.listClientes();

        // Assert
        assertEquals(2, result.size());
    }

    @Test
    public void testEditCliente() {
        // Arrange
        Long idCliente = 1L;
        Cliente clienteExistente = Cliente.builder()
                .id(idCliente)
                .nombre("Juan")
                .apellido("Perez")
                .direccion("Direccion 1")
                .dni("123456789")
                .fechaNacimiento(LocalDate.now())
                .nacionalidad("Nacionalidad 1")
                .celular("123456789")
                .email("juan@example.com")
                .cargo("Cargo 1")
                .sueldo("1000")
                .estadoCliente(EstadoCliente.ACTIVO)
                .build();

        Cliente clienteModificado = Cliente.builder()
                .id(idCliente)
                .nombre("Juan Modificado")
                .apellido("Perez Modificado")
                .direccion("Nueva Direccion")
                .dni("987654321")
                .fechaNacimiento(LocalDate.now())
                .nacionalidad("Nueva Nacionalidad")
                .celular("987654321")
                .email("juan.modificado@example.com")
                .cargo("Nuevo Cargo")
                .sueldo("2000")
                .estadoCliente(EstadoCliente.INACTIVO) // Cambiar estado
                .build();

        // Cuando se busque un cliente por su ID, el repositorio devolverá el cliente existente que hemos creado.
        when(clienteRepository.findById(idCliente)).thenReturn(Optional.of(clienteExistente));

        //  cuando se guarde un cliente en el repositorio, el repositorio devolverá el mismo cliente que se le pasó como argumento
        when(clienteRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        Cliente clienteActualizado = clienteService.editCliente(idCliente, clienteModificado);

        // Assert
        assertEquals("Juan Modificado", clienteActualizado.getNombre());
        assertEquals("Perez Modificado", clienteActualizado.getApellido());
        assertEquals("Nueva Direccion", clienteActualizado.getDireccion());
        assertEquals("987654321", clienteActualizado.getDni());
        assertEquals("Nueva Nacionalidad", clienteActualizado.getNacionalidad());
        assertEquals("987654321", clienteActualizado.getCelular());
        assertEquals("juan.modificado@example.com", clienteActualizado.getEmail());
        assertEquals("Nuevo Cargo", clienteActualizado.getCargo());
        assertEquals("2000", clienteActualizado.getSueldo());
        assertEquals(EstadoCliente.INACTIVO, clienteActualizado.getEstadoCliente());

        // Verificar que se llamó a clienteRepository.save una vez
        verify(clienteRepository, times(1)).save(clienteExistente);
    }
}
