package manejoFicheros;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * La clase Vista maneja la interacción con el usuario a través de la consola.
 */
public class Vista {
    private Scanner scanner; // Scanner para entrada de usuario

    /**
     * Constructor para la clase Vista.
     */
    public Vista() {
        scanner = new Scanner(System.in);
    }

    /**
     * Método para mostrar el menú principal y solicitar al usuario que seleccione una opción.
     * @return La opción seleccionada por el usuario.
     */
    public int mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("1. Agregar artículo");
        System.out.println("2. Borrar artículo");
        System.out.println("3. Consultar artículo");
        System.out.println("4. Listar todos los artículos");
        System.out.println("5. Exportar artículos a archivo CSV");
        System.out.println("6. Terminar programa");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    /**
     * Método para solicitar al usuario que ingrese el ID de un artículo.
     * @return El ID ingresado por el usuario.
     */
    public int ingresarIdArticulo() {
        System.out.print("Ingrese el ID del artículo: ");
        return scanner.nextInt();
    }

    /**
     * Método para solicitar al usuario que ingrese el nombre de un artículo.
     * @return El nombre ingresado por el usuario.
     */
    public String ingresarNombre() {
        System.out.print("Ingrese el nombre del artículo: ");
        scanner.nextLine(); // Limpiar el buffer del scanner
        return scanner.nextLine();
    }

    /**
     * Método para solicitar al usuario que ingrese la descripción de un artículo.
     * @return La descripción ingresada por el usuario.
     */
    public String ingresarDescripcion() {
        System.out.print("Ingrese la descripción del artículo: ");
        return scanner.nextLine();
    }

    /**
     * Método para solicitar al usuario que ingrese el stock de un artículo.
     * @return El stock ingresado por el usuario.
     */
    public int ingresarStock() {
        System.out.print("Ingrese el stock del artículo: ");
        return scanner.nextInt();
    }

    /**
     * Método para solicitar al usuario que ingrese el precio de un artículo.
     * @return El precio ingresado por el usuario.
     */
    public double ingresarPrecio() {
        System.out.print("Ingrese el precio del artículo: ");
        return scanner.nextDouble();
    }

    /**
     * Método para mostrar los detalles de un artículo.
     * @param articulo El artículo a mostrar.
     */
    public void mostrarArticulo(Modelo articulo) {
        System.out.println("Artículo encontrado:");
        System.out.println("ID: " + articulo.getId());
        System.out.println("Nombre: " + articulo.getNombre());
        System.out.println("Descripción: " + articulo.getDescripcion());
        System.out.println("Stock: " + articulo.getStock());
        System.out.println("Precio: " + articulo.getPrecio());
    }

    /**
     * Método para mostrar un listado de artículos.
     * @param articulos La lista de artículos a mostrar.
     */
    public void mostrarListado(ArrayList<Modelo> articulos) {
        System.out.println("Listado de artículos:");
        for (Modelo articulo : articulos) {
            System.out.println("ID: " + articulo.getId() + ", Nombre: " + articulo.getNombre() + ", Descripción: " + articulo.getDescripcion());
        }
    }

    /**
     * Método para limpiar el buffer del scanner.
     */
    public void limpiarBuffer() {
        scanner.nextLine(); // Leer y descartar la entrada actual del scanner
    }
}
