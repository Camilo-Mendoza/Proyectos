package model;

import java.time.LocalDate;
import java.util.Scanner;

public class Bibliotecario extends Persona {
    private static final Scanner consola = new Scanner(System.in);
    private float salario;
    private LocalDate tiempoEnLaEmpresa;
    private int CantidadPrestamos;

    public Bibliotecario(){
    }

    public Bibliotecario(String nombre, String cedula, String telefono, String correo, float salario, LocalDate tiempoEnLaEmpresa) {
        super(nombre, cedula, telefono, correo);
        this.salario = salario;
        this.tiempoEnLaEmpresa = tiempoEnLaEmpresa;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public LocalDate getTiempoEnLaEmpresa() {
        return tiempoEnLaEmpresa;
    }

    public void setTiempoEnLaEmpresa(LocalDate tiempoEnLaEmpresa) {
        this.tiempoEnLaEmpresa = tiempoEnLaEmpresa;
    }

    public int getCantidadPrestamos() {
        return CantidadPrestamos;
    }

    public void setCantidadPrestamos(int cantidadPrestamos) {
        CantidadPrestamos = cantidadPrestamos;
    }

    public static void crearPrestamo() {
        System.out.println("Ingrese la cedula del bibliiotecario:");
        String cedula = consola.nextLine();
        System.out.print("Ingrese el codigo del prestamo: ");
        String codigoPrestamo = consola.nextLine();
        System.out.print("Ingrese la fecha de inicio del prestamo: ");
        String fechaInicio = consola.nextLine();
        System.out.print("Ingrese la fecha de entrega del prestamo: ");
        String fechaEntrega = consola.nextLine();
        System.out.print("ingrese el codigo del libro que desea obtener prestado");
        String codigo = consola.nextLine();
        System.out.print("Ingrese la cantidad de unidades del libro que desea obtener prestados: ");
        int cantidadLibros = consola.nextInt();
        if (cantidadLibros > 4) {
            System.out.println("esta cantidad de libros sobrepasa la disponible");
        } else System.out.println("cantidad de libros disponible");
        consola.nextLine();
        System.out.println("elija un bibiliotecario por su ");

        Prestamo prestamo = new Prestamo();
        prestamo.setCodigoPrestamo(codigo);
        prestamo.setFechaInicio(fechaInicio);
        prestamo.setFechaEntrega(fechaEntrega);
        prestamo.setCantidadLibros(cantidadLibros);
    }
}
