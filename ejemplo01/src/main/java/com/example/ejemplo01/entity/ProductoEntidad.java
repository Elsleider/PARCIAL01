package com.example.ejemplo01.entity;

public class ProductoEntidad {

    public String referencia;
    public String nombre;
    public String categoria;
    public float preciounitario;
    public float cantidad;
    public float descuento10;
    public float total;

    public ProductoEntidad(String referencia, String nombre, String categoria, float preciounitario, float cantidad) {

        this.referencia = referencia;
        this.nombre = nombre;
        this.categoria = categoria;
        this.preciounitario = preciounitario;
        this.cantidad = cantidad;

    }

    public ProductoEntidad(){}



    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(float preciounitario) {
        this.preciounitario = preciounitario;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public float getDescuento10() {
        return descuento10;
    }

    public void setDescuento10(float descuento10) {
        this.descuento10 = descuento10;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
