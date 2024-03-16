package com.turismo.turismo.model;

import com.turismo.turismo.enums.EstadoCliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String dni;
    private LocalDate fechaNacimiento;
    private String nacionalidad;
    private String celular;
    private String email;
    private String cargo;
    private BigDecimal sueldo;
    @Enumerated(value = EnumType.STRING)
    private EstadoCliente estadoCliente;
}
