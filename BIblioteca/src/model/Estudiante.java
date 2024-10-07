package model;

import java.util.ArrayList;

public class Estudiante extends Persona {
    private ArrayList<Prestamo> listaPrestamos;

    public Estudiante(){
    }

    public Estudiante(String nombre, String cedula, String telefono, String correo) {
        super(nombre, cedula, telefono, correo);
        this.listaPrestamos = new ArrayList<>();
    }

    public void agregarPrestamo(Prestamo prestamo) {
        listaPrestamos.add(prestamo);
    }

    public ArrayList<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }
}
