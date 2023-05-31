package com.Main.Restaurant.Servicio;

import com.Main.Restaurant.Entidades.Pedidos;
import com.Main.Restaurant.Repositorio.PedidosRepositorio;
import com.Main.Restaurant.Servicio.Base.ServicioBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class PedidosServicio implements ServicioBase<Pedidos>{


    @Autowired
    protected PedidosRepositorio  pedidosRepositorio;
    @Override
    public List<Pedidos> buscarTodos() throws Exception {
        try{
            List<Pedidos> pedidos = pedidosRepositorio.findAll();
            return pedidos;
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }



    @Override
    public Pedidos buscarPorId(Integer id) throws Exception {
        try{

            Optional<Pedidos> pedidosOptional = pedidosRepositorio.findById(id);
            if (pedidosOptional.isPresent()) {
                Pedidos pedidos = pedidosOptional.get();
                return pedidos;
            } else {
                throw new Exception("no existe registro con ese id");
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }


    @Override
    public Pedidos registrar(Pedidos entidad) throws Exception {
        try{
            Pedidos pedidosRegistrado = pedidosRepositorio.save(entidad);
            return pedidosRegistrado;

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Pedidos actualizar(Integer id, Pedidos entidad) throws Exception {
        return null;
    }

    @Override
    public boolean borrar(Integer id) throws Exception {
        return false;
    }

}
