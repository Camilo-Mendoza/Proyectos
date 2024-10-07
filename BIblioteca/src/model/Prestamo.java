package model;

import java.time.LocalDate;

public class Prestamo {
    private String codigoPrestamo;
    private int cantidadLibros;
    private String fechaInicio;
    private String fechaEntrega;
    private double precioTotal;

    public Prestamo(){
    }

    public Prestamo(String codigoPrestamo, int cantidadLibros, String fechaInicio, String fechaEntrega, double precioTotal) {
        this.codigoPrestamo = codigoPrestamo;
        this.cantidadLibros = cantidadLibros;
        this.fechaInicio = fechaInicio;
        this.fechaEntrega = fechaEntrega;
        this.precioTotal = precioTotal;
    }

    public String getCodigoPrestamo() {
        return codigoPrestamo;
    }

    public void setCodigoPrestamo(String codigoPrestamo) {
        this.codigoPrestamo = codigoPrestamo;
    }

    public int getCantidadLibros() {
        return cantidadLibros;
    }

    public void setCantidadLibros(int cantidadLibros) {
        this.cantidadLibros = cantidadLibros;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
}
