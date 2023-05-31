package com.Main.Restaurant.Entidades;


import jakarta.persistence.*;

@Entity
@Table(name="categoria")

public class Categoria {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;


    @ManyToOne
    @JoinColumn(name="categoria_id")
    private Categoria categoria;

    @Column(name="tipo_de_producto",nullable = false,length = 50)
    private String tipo_de_producto;


}
