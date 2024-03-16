package com.turismo.turismo.servicetest;

import com.turismo.turismo.enums.EstadoPaquete;
import com.turismo.turismo.model.Paquete;
import com.turismo.turismo.repository.PaqueteRepository;
import com.turismo.turismo.service.PaqueteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PaqueteServiceTest {

    @Mock
    private PaqueteRepository paqueteRepository;

    @InjectMocks
    private PaqueteService paqueteService;

    @Test
    public void testDeletePaquete() {
        // Arrange
        Long idPaquete = 1L;
        Paquete paquete = new Paquete();
        paquete.setCodigo(idPaquete);

        when(paqueteRepository.findById(idPaquete)).thenReturn(Optional.of(paquete));

        // Act
        paqueteService.deletePaquete(idPaquete);

        // Assert
        verify(paqueteRepository, times(1)).findById(idPaquete);
        verify(paqueteRepository, times(1)).save(paquete);
        assertEquals(EstadoPaquete.INACTIVO, paquete.getEstadoPaquete());
    }



}
