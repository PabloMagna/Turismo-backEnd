package com.turismo.turismo.model;

import com.turismo.turismo.enums.EstadoServicio;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private String imagen;
    private String destino;
    private LocalDate fecha;
    @Enumerated(value = EnumType.STRING)
    private EstadoServicio estadoServicio;
}