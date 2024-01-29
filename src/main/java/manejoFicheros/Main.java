package manejoFicheros;

/**
 * La clase Main es la clase principal que contiene el método `main` para iniciar la aplicación.
 */
public class Main {
    /**
     * Método principal que inicia la aplicación.
     * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        Vista vista = new Vista(); // Instancia de la vista
        Modelo modelo = new Modelo(); // Instancia del modelo
        Controlador controlador = new Controlador(vista, modelo); // Instancia del controlador
        controlador.iniciar(); // Iniciar la aplicación
    }
}
