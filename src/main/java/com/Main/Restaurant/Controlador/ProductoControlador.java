package com.Main.Restaurant.Controlador;


import com.Main.Restaurant.Entidades.Producto;
import com.Main.Restaurant.Servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Producto")
public class ProductoControlador {



@Autowired

    protected ProductoServicio productoServicio;


    @PostMapping
    public ResponseEntity<Producto> registrar(@RequestBody Producto datosProducto) {
        try {
            Producto productoRegistrado = productoServicio.registrar(datosProducto);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(productoRegistrado);

        } catch (Exception error) {
            String errorMensaje = "Tenemos un error: " + error.getMessage();
            Producto autorError = new Producto();
            autorError.setErrorMessage(errorMensaje);
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(autorError);

        }


    }



    @GetMapping
    public ResponseEntity<List<Producto>> buscarTodos(){
        try{
            List<Producto> producto = productoServicio.buscarTodos();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(producto);
        }catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

}
