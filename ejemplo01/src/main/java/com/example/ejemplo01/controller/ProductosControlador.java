package com.example.ejemplo01.controller;

import com.example.ejemplo01.entity.ProductoEntidad;
import com.example.ejemplo01.services.ProductoServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500", allowCredentials = "true")
public class ProductosControlador {

    private final ProductoServicio productoServicio;

    public ProductosControlador(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    @GetMapping("/mostrarproductos")
    public ResponseEntity<List<ProductoEntidad>> mostrarMotos() {
        List<ProductoEntidad> motos = productoServicio.mostrarproductos();
        return new ResponseEntity<>(motos, HttpStatus.OK);
    }
    @PutMapping("/productos/{referencia}/categoria/{nuevaCategoria}")
        public ResponseEntity<String> actualizarCategoria(@PathVariable String referencia, @PathVariable String nuevaCategoria) {
            productoServicio.actualizarCategoria(referencia, nuevaCategoria);
            // Si la actualización fue exitosa, puedes devolver una respuesta exitosa.
            return new ResponseEntity<>("Categoría actualizada correctamente", HttpStatus.OK);
        }

    @GetMapping("/totalporcategoriaproducto/{categoria}")
    public ResponseEntity<List<ProductoEntidad>> getTotalPorCategoriaProducto(@PathVariable String categoria) {
        List<ProductoEntidad> productosCategoria = productoServicio.calcularTotalPorCategoriaProducto(categoria);
        return new ResponseEntity<>(productosCategoria, HttpStatus.OK);
    }
}