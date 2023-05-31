package com.Main.Restaurant.Servicio;

import com.Main.Restaurant.Entidades.Categoria;
import com.Main.Restaurant.Entidades.Producto;
import com.Main.Restaurant.Repositorio.CategoriaRepository;
import com.Main.Restaurant.Repositorio.ProductoRepositorio;
import com.Main.Restaurant.Servicio.Base.ServicioBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoriaServicio implements ServicioBase<Categoria>{


    @Autowired
    protected CategoriaRepository categoriaRepositorio;

    @Override
    public List< Categoria> buscarTodos() throws Exception {
        try{
            List<Categoria> categoria = categoriaRepositorio.findAll();
            return categoria;
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }



    @Override
    public  Categoria buscarPorId(Integer id) throws Exception {
        try{

            Optional<Categoria>  categoriaOptional = categoriaRepositorio.findById(id);
            if (categoriaOptional.isPresent()) {
                Categoria categoria = categoriaOptional.get();
                return categoria;
            } else {
                throw new Exception("no existe registro con ese id");
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }


    @Override
    public Categoria registrar(Categoria entidad) throws Exception {
        try{
            Categoria categoriaRegistrado = categoriaRepositorio.save(entidad);
            return categoriaRegistrado;

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }


    @Override
    public  Categoria actualizar(Integer id, Categoria entidad) throws Exception {
        return null;
    }

    @Override
    public boolean borrar(Integer id) throws Exception {
        return false;
    }


}
