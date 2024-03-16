package com.turismo.turismo.model;

import com.turismo.turismo.enums.EstadoPaquete;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Paquete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Paquete_Servicio",
            joinColumns = @JoinColumn(name = "paquete_codigo"),
            inverseJoinColumns = @JoinColumn(name = "servicio_codigo")
    )
    private List<Servicio> servicios;

    private BigDecimal costoPaquete;

    @Enumerated(value = EnumType.STRING)
    private EstadoPaquete estadoPaquete;
}

