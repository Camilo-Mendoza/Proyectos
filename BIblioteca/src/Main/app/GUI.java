package Main.app;
import model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GUI {
private static final Scanner consola = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema bibliotecario, para comenzar cree un nombre a su biblioteca");
        var nombre = consola.nextLine();
        boolean continuar = false;
        while (!continuar) {
            System.out.println("Elija una opcion del menu:");
            System.out.println("1. Crear bibliotecario");
            System.out.println("2. Crear libro");
            System.out.println("3. Crear estudiante");
            System.out.println("4. Continuar");
            System.out.print("Seleccione una opción: ");
            int opcion = consola.nextInt();
            consola.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                crearBibliotecario();
                    break;
                case 2:
                crearLibro();
                    break;
                case 3:
                crearEstudiante();
                    break;
                case 4:
                    continuar = true;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
        boolean continuar2 = false;
        while (!continuar2) {
            System.out.println("1. Crear prestamo");
            System.out.println("2. Continuar");
            System.out.println("elija una opcion");
            int opcion2 = consola.nextInt();
            switch (opcion2) {
                case 1:
                Bibliotecario.crearPrestamo();
                    break;
                case 2:
                    continuar2 = true;
                    break;
                default:
                    System.out.println("opcion invalida");
            }
        }
        boolean salir = false;
        while (!salir){
            System.out.println("1. actualizar un libro");
            System.out.println("2. buscar un libro");
            System.out.println("3. mostrar estudiante con más prestamos");
            System.out.println("4. generar factura de prestamo");
            System.out.println("5. ver prestamos asignados a un bibliotecario");
            System.out.println("6. salir");
            System.out.println("elija una opcion");
            int opcion3 = consola.nextInt();

            switch (opcion3){
                case 1:
                actualizarLibro(new ArrayList<>());
                    break;
                case 2:
                    System.out.println("Ingrese el codigo del libro:");
                    String codigo = consola.nextLine();



                    buscarLibro(codigo,);
                    break;
                case 3:
                    ArrayList<Estudiante> listaEstudiantes;
                    mostrarEstudiantesConMasPrestamos(ArrayList<Estudiante> listaEstudiantes);
                    break;

                case 4:
                    generarFacturaPrestamo();
                    break;
                case 5:
                    contarPrestamosPorBibliotecario();
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("opcion invalida");
                    break;
            }
        }
    }



    private static void crearBibliotecario() {
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = consola.nextLine();
        System.out.print("Ingrese la cedula del empleado: ");
        String cedula = consola.nextLine();
        System.out.print("Ingrese el numero de telefono del empleado: ");
        String telefono = consola.nextLine();
        System.out.println("Ingrese el correo del empleado: ");
        String correo = consola.nextLine();
        consola.nextLine(); // Consumir el salto de línea

        Bibliotecario bibliotecario = new Bibliotecario();
        bibliotecario.setNombre(nombre);
        bibliotecario.setCedula(nombre);
        bibliotecario.setTelefono(telefono);
        bibliotecario.setCorreo(correo);
    }
    private static void crearLibro() {
        System.out.print("ingrese el codigo del libro: ");
        String codigo = consola.nextLine();
        System.out.print("Ingrese el isbn del libro (código normalizado internacional para libros): ");
        String isbn = consola.nextLine();
        System.out.print("Ingrese el titulo del libro: ");
        String titulo = consola.nextLine();
        System.out.println("Ingrese el autor del libro: ");
        String autor = consola.nextLine();
        System.out.println("Ingrese la editorial del libro: ");
        String editorial = consola.nextLine();
        System.out.println("Ingrese la fecha de publicacion del libro: ");
        String fecha = consola.nextLine();
        System.out.println("Ingrese la cantidad de unidades disponibles del libro:");
        int unidadesDisponibles = consola.nextInt();
        System.out.println("ingrese el estado del libro (Disponible, prestado, fuera de circulacion)");
        System.out.println("Ingrese el precio del libro con decimales");
        double precioLibro = consola.nextDouble();
        consola.nextLine(); // Consumir el salto de línea

        Libro libro = new Libro();
        libro.setCodigo(codigo);
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        libro.setFecha(fecha);
        libro.setUnidadesDisponibles(unidadesDisponibles);
        libro.setPrecioLibro(precioLibro);
    }
    private static void crearEstudiante() {
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = consola.nextLine();
        System.out.print("Ingrese la cedula del estudiante: ");
        String cedula = consola.nextLine();
        System.out.print("Ingrese el numero de telefono del estudiante: ");
        String telefono = consola.nextLine();
        System.out.println("Ingrese el correo del estudiante: ");
        String correo = consola.nextLine();
        consola.nextLine(); // Consumir el salto de línea

        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(nombre);
        estudiante.setCedula(cedula);
        estudiante.setTelefono(telefono);
        estudiante.setCorreo(correo);
    }

    private static void actualizarLibro(ArrayList<Libro> listaLibros) {
        System.out.print("Ingrese el código del libro que desea actualizar: ");
        String codigo = consola.nextLine();
        Libro libro = buscarLibro(codigo, listaLibros);

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
