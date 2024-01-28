package manejoFicheros;

import java.util.ArrayList;
import java.util.Scanner;

public class Vista {
    private Scanner scanner;

    public Vista() {
        scanner = new Scanner(System.in);
    }

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

    public int ingresarIdArticulo() {
        System.out.print("Ingrese el ID del artículo: ");
        return scanner.nextInt();
    }

    public String ingresarNombre() {
        System.out.print("Ingrese el nombre del artículo: ");
        scanner.nextLine(); // Limpiar el buffer del scanner
        return scanner.nextLine();
    }

    public String ingresarDescripcion() {
        System.out.print("Ingrese la descripción del artículo: ");
        return scanner.nextLine();
    }

    public int ingresarStock() {
        System.out.print("Ingrese el stock del artículo: ");
        return scanner.nextInt();
    }

    public double ingresarPrecio() {
        System.out.print("Ingrese el precio del artículo: ");
        return scanner.nextDouble();
    }

    public void mostrarArticulo(Modelo articulo) {
        System.out.println("Artículo encontrado:");
        System.out.println("ID: " + articulo.getId());
        System.out.println("Nombre: " + articulo.getNombre());
        System.out.println("Descripción: " + articulo.getDescripcion());
        System.out.println("Stock: " + articulo.getStock());
        System.out.println("Precio: " + articulo.getPrecio());
    }

    public void mostrarListado(ArrayList<Modelo> articulos) {
        System.out.println("Listado de artículos:");
        for (Modelo articulo : articulos) {
            System.out.println("ID: " + articulo.getId() + ", Nombre: " + articulo.getNombre() + ", Descripción: " + articulo.getDescripcion());
        }
    }

    public void limpiarBuffer() {
        scanner.nextLine(); // Leer y descartar la entrada actual del scanner
    }
}
    
