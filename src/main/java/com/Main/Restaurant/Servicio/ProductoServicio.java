package com.Main.Restaurant.Servicio;

import com.Main.Restaurant.Entidades.Pedidos;
import com.Main.Restaurant.Entidades.Producto;
import com.Main.Restaurant.Repositorio.ProductoRepositorio;
import com.Main.Restaurant.Servicio.Base.ServicioBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductoServicio implements ServicioBase<Producto> {

    @Autowired
    protected ProductoRepositorio productoRepositorio;

    @Override
    public List<Producto> buscarTodos() throws Exception {
        try{
            List<Producto> productos = productoRepositorio.findAll();
            return productos;
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }



    @Override
    public Producto buscarPorId(Integer id) throws Exception {
        try{

            Optional<Producto> productoOptional = productoRepositorio.findById(id);
            if (productoOptional.isPresent()) {
                Producto producto = productoOptional.get();
                return producto;
            } else {
                throw new Exception("no existe registro con ese id");
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }


    @Override
    public Producto registrar(Producto entidad) throws Exception {
        try{
            Producto productoRegistrado = productoRepositorio.save(entidad);
            return productoRegistrado;

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }


    @Override
    public Producto actualizar(Integer id, Producto entidad) throws Exception {
        return null;
    }

    @Override
    public boolean borrar(Integer id) throws Exception {
        return false;
    }

}
