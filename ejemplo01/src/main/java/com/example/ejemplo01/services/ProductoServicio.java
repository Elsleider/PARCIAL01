package com.example.ejemplo01.services;


import com.example.ejemplo01.entity.ProductoEntidad;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")

@Service
public class ProductoServicio {


    private List<ProductoEntidad> listaproductos = new ArrayList<>();

    public ProductoServicio() {
        listaproductos.add(new ProductoEntidad("1", "leche", "lacteos", 20000, 10));
        listaproductos.add(new ProductoEntidad("2", "pechuga", "carnes", 30000, 5));
        listaproductos.add(new ProductoEntidad("3", "carne", "carnes", 45000, 4));
        listaproductos.add(new ProductoEntidad("4", "queso", "lacteos", 45200, 6));
        listaproductos.add(new ProductoEntidad("5", "crema", "lacteos", 1000, 4));
    }

    public List<ProductoEntidad> mostrarproductos() {
        return listaproductos;
    }

    public ProductoEntidad busquedaID(String referencia) {
        for (ProductoEntidad g : listaproductos) {
            if (g.getReferencia() == referencia) {
                return g;
            }
        }
        return null;
    }

    public void actualizarCategoria(String referencia, String nuevaCategoria) {
        for (ProductoEntidad producto : listaproductos) {
            if (producto.getReferencia().equals(referencia)) {
                producto.setCategoria(nuevaCategoria);
                // Si estás utilizando una base de datos o alguna estructura de datos persistente,
                // aquí deberías guardar los cambios para que se reflejen en los datos almacenados.
                break;
            }
        }
    }

    public List<ProductoEntidad> calcularTotalPorCategoriaProducto(String categoria) {
        List<ProductoEntidad> productosCategoria = new ArrayList<>();
        double totalPorCategoria = 0.0;

        for (ProductoEntidad producto : listaproductos) {
            if (producto.getCategoria().equals(categoria)) {
                double precioUnitario = producto.getPreciounitario();
                double cantidad = producto.getCantidad();
                double totalProducto = precioUnitario * cantidad;

                producto.setDescuento10(0.0F);
                producto.setTotal((float) totalProducto);

                totalPorCategoria += totalProducto;

                productosCategoria.add(producto);
            }
        }

        // Asignar el totalPorCategoria a cada producto en la lista
        for (ProductoEntidad producto : productosCategoria) {
            producto.setTotal((float) (producto.getTotal() / totalPorCategoria * totalPorCategoria));
        }

        return productosCategoria;
    }


}