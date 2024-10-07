package model;

public class DetallePrestamoLibro {
    private String nombreLibro;
    private double precioPorDia;
    private int cantidad;


    public DetallePrestamoLibro(String nombreLibro, double precioPorDia, int cantidad) {
        this.nombreLibro = nombreLibro;
        this.precioPorDia = precioPorDia;
        this.cantidad = cantidad;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public double getPrecioPorDia() {
        return precioPorDia;
    }

    public void setPrecioPorDia(double precioPorDia) {
        this.precioPorDia = precioPorDia;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
