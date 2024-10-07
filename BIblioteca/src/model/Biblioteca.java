package model;

import java.util.ArrayList;
import java.util.Scanner;




public class Biblioteca {
    private String nombre;
    private ArrayList<Bibliotecario> listaBibliotecarios;
    private ArrayList<Libro> listaLibros = new ArrayList<>();
    private ArrayList<Prestamo> listaPrestamos;


    public Biblioteca(){
    }
    private static final Scanner consola = new Scanner(System.in);

    public Biblioteca(String nombre, ArrayList<Bibliotecario> listaBibliotecarios, ArrayList<Libro> listaLibros) {
        this.nombre = nombre;
        this.listaBibliotecarios = listaBibliotecarios;
        this.listaLibros = listaLibros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Bibliotecario> getListaBibliotecarios() {
        return listaBibliotecarios;
    }

    public void setListaBibliotecarios(ArrayList<Bibliotecario> listaBibliotecarios) {
        this.listaBibliotecarios = listaBibliotecarios;
    }

    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public void agregarPrestamo(Prestamo prestamo) {
        listaPrestamos.add(prestamo);
    }

    public ArrayList<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaLibros() {
        this.listaLibros = listaLibros;
    }
    private static void actualizarLibro(ArrayList<Libro> listaLibros) {
        System.out.print("Ingrese el código del libro que desea actualizar: ");
        String codigo = consola.nextLine();
        Libro libro = buscarLibro(listaLibros,codigo);

        if (libro != null) {
            System.out.print("Ingrese el nuevo título del libro (dejar vacío para no cambiar): ");
            String nuevoTitulo = consola.nextLine();
            if (!nuevoTitulo.isEmpty()) {
                libro.setTitulo(nuevoTitulo);
            }

            // Puedes añadir más campos a actualizar, por ejemplo:
            System.out.print("Ingrese el nuevo precio del libro (dejar vacío para no cambiar): ");
            String nuevoPrecioStr = consola.nextLine();
            if (!nuevoPrecioStr.isEmpty()) {
                libro.setPrecioLibro(Double.parseDouble(nuevoPrecioStr));
            }

            System.out.println("Libro actualizado con éxito.");
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    private static String buscarLibro(ArrayList<Libro> listaLibros) {
        for (Libro libro : listaLibros) {
            System.out.println("Ingrese el codigo del libro que quiere buscar");
            String codigo = consola.nextLine();
            if (libro.getCodigo().equals(codigo)) {
                return libro.getTitulo();
            }


        }
        return "Libro no ha sido encontrado";


    }
    private static void mostrarEstudiantesConMasPrestamos(ArrayList<Estudiante> listaEstudiantes) {
        //intento de landa
        listaEstudiantes.sort((a, b) -> Integer.compare(b.getListaPrestamos().size(), a.getListaPrestamos().size())); // Ordena de mayor a menor

        System.out.println("Estudiantes con más préstamos:");
        for (Estudiante estudiante : listaEstudiantes) {
            System.out.println(estudiante.getNombre() + ": " + estudiante.getListaPrestamos().size() + " préstamos");
        }
    }

    private static void generarFacturaPrestamo(ArrayList<Prestamo> listaPrestamos) {
        System.out.print("Ingrese el código del préstamo: ");
        String codigoPrestamo = consola.nextLine();

        Prestamo prestamo = null;
        for (Prestamo p : listaPrestamos) {
            if (p.getCodigoPrestamo().equals(codigoPrestamo)) {
                prestamo = p;
                break;
            }
        }

        if (prestamo != null) {
            System.out.println("Factura de Préstamo:");
            System.out.println("Código: " + prestamo.getCodigoPrestamo());
            System.out.println("Cantidad de libros: " + prestamo.getCantidadLibros());
            System.out.println("Fecha de inicio: " + prestamo.getFechaInicio());
            System.out.println("Fecha de entrega: " + prestamo.getFechaEntrega());
            System.out.println("Precio total: " + prestamo.getPrecioTotal());
        } else {
            System.out.println("Préstamo no encontrado.");
        }
    }

    private static int contarPrestamosPorBibliotecario(ArrayList<Bibliotecario> listaBibliotecarios, ArrayList<Prestamo> listaPrestamos, String cedula) {
        for (Bibliotecario bibliotecario : listaBibliotecarios) {
            if (bibliotecario.getCedula().equals(cedula)) {
                int contador = 0;
                for (Prestamo prestamo : listaPrestamos) {

                    if (bibliotecario.getCedula().equals(cedula)) {
                        contador++;
                    }
                }
                return contador;
            }
        }
        return 0;
    }
}


