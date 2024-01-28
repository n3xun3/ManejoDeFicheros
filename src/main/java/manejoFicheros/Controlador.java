package manejoFicheros;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import java.util.InputMismatchException;

public class Controlador {
    private final Vista vista;
    private final Modelo modelo;


    public Controlador(Vista vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    public void iniciar() {
        int opcion;

        do {
            
            opcion = vista.mostrarMenu();

            switch (opcion) {
                case 1:
                    agregarArticulo();
                    break;
                case 2:
                    borrarArticulo();
                    break;
                case 3:
                    consultarArticulo();
                    break;
                case 4:
                    listarArticulos();
                    break;
                case 5:
                	exportarArticulosCSV();
                    break;
                case 6 :
                	terminarPrograma();
                    break;
                default:
                	System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 6);
    }

    private void agregarArticulo() {
        try {
            int id = vista.ingresarIdArticulo();

            // Verificar si el artículo ya existe en el modelo
            Modelo articuloExistente = modelo.consultarArticulo(id);
            if (articuloExistente != null) {
                System.out.println("Error al agregar el artículo. ¡El ID ya existe!");
                return; // Salir del método si el artículo ya existe
            }

            String nombre = vista.ingresarNombre();
            String descripcion = vista.ingresarDescripcion();
            int stock = vista.ingresarStock();
            double precio = vista.ingresarPrecio();

            Modelo nuevoArticulo = new Modelo(id, nombre, descripcion, stock, precio);

            if (modelo.agregarArticulo(nuevoArticulo)) {
                System.out.println("Artículo agregado correctamente.");
            } else {
                System.out.println("Error al agregar el artículo.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Debes ingresar un número válido.");
            // Limpiar el buffer del scanner para evitar un bucle infinito
            vista.limpiarBuffer();
        }
    }


    private void borrarArticulo() {
        int id = vista.ingresarIdArticulo();
        if (modelo.borrarArticulo(id)) {
        	System.out.println("Artículo borrado correctamente.");
        } else {
        	System.out.println("No se encontró ningún artículo con ese ID.");
        }
    }

    private void consultarArticulo() {
        int id = vista.ingresarIdArticulo();
        Modelo articulo = modelo.consultarArticulo(id);
        if (articulo != null) {
            vista.mostrarArticulo(articulo);
        } else {
        	System.out.println("No se encontró ningún artículo con ese ID.");
        }
    }

    private void listarArticulos() {
        ArrayList<Modelo> articulos = modelo.listarArticulos();
        vista.mostrarListado(articulos);
    }

    private void terminarPrograma() {
    	System.out.println("Finalizando programa...");
    }

    public void exportarArticulosCSV() {
        try {
            CSVPrinter csvPrinter = new CSVPrinter(new FileWriter("articulos.csv"), CSVFormat.DEFAULT);

            // Escribir encabezados
            csvPrinter.printRecord("ID", "Nombre", "Descripción", "Stock", "Precio");

            // Obtener la lista de artículos del modelo
            ArrayList<Modelo> listaArticulos = modelo.listarArticulos();

            // Escribir cada artículo en el archivo CSV
            for (Modelo articulo : listaArticulos) {
                csvPrinter.printRecord(articulo.getId(), articulo.getNombre(), articulo.getDescripcion(),
                        articulo.getStock(), articulo.getPrecio());
            }

            // Cerrar el CSVPrinter para finalizar la escritura
            csvPrinter.close();

            System.out.println("Los artículos se han exportado correctamente a 'articulos.csv'.");
        } catch (IOException e) {
            System.out.println("Error al exportar los artículos a archivo CSV: " + e.getMessage());
        }
    }

}

