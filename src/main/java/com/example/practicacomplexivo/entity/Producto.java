package com.example.practicacomplexivo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private String imagen;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private String ubicacion;

    @Column(nullable = false)
    private String fecha_caducidad;

    @ManyToOne(fetch = FetchType.EAGER) // Cambia a EAGER para la carga temprana
    @JoinColumn(name = "id_categoria", referencedColumnName = "id", nullable = true)
    private Categoria id_categoria;
}
