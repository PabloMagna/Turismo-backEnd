package com.turismo.turismo.model;

import com.turismo.turismo.enums.EstadoVenta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Venta {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long numero;
   private LocalDate fecha;

   @ManyToOne
   private MedioPago medioPago;

   @ManyToOne
   private Cliente cliente;

   @ManyToOne
   private Paquete paquete;

   @ManyToOne
   private Cliente empleado;

   @Enumerated(EnumType.STRING)
   private EstadoVenta estadoVenta;
}
