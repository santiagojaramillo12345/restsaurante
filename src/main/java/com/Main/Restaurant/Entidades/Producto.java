package com.Main.Restaurant.Entidades;

import jakarta.persistence.*;

@Entity
@Table(name="producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;


    @ManyToOne
    @JoinColumn(name="categoria_id")
    private Categoria categoria;


    @Column(name="descricion",nullable = false,length = 50)
    private String descricion;

    @Column(name="precio",nullable = false,length = 50)
    private String precio;


    @Column(name="nombre",nullable = false,length = 50)
    private String nombre;



    @Column(name="telefono",nullable = false,length = 50)
    private String telefono;

    @Column(name="email",nullable = false,length = 50)
    private String email;

    public Producto() {
    }

    public Producto(Integer id, String descricion, String precio, String categoria, String nombre, String telefono, String email) {
        this.id = id;
        this.descricion = descricion;
        this.precio = precio;

        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;





    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricion() {
        return descricion;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setErrorMessage(String errorMensaje) {
    }
}
