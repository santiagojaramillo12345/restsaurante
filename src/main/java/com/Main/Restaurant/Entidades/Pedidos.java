package com.Main.Restaurant.Entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="pedidos")

public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;



    @ManyToMany
    @JoinTable(name = "Pedidos_Product",
            joinColumns = {@JoinColumn(name = "Pedidos_id")},
            inverseJoinColumns = {@JoinColumn(name = "Product_id")})
    private List<Producto> productos;


    @Column(name="direcion",nullable = false,length = 50)
    private String direcion;

    @Column(name="cantProduct")
    private Integer cantProduct;






    public Pedidos() {
    }

    public Pedidos(Integer id, String direcion, Integer cantProduct) {
        this.id = id;
        this.direcion = direcion;
        this.cantProduct = cantProduct;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    public Integer getCantProduct() {
        return cantProduct;
    }

    public void setCantProduct(Integer cantProduct) {
        this.cantProduct = cantProduct;
    }
}
