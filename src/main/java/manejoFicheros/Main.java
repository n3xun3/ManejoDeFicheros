package manejoFicheros;

public class Main {
    public static void main(String[] args) {
        Vista vista = new Vista();
        Modelo modelo = new Modelo(); // Puedes inicializar el modelo según tus necesidades

        Controlador controlador = new Controlador(vista, modelo);
        controlador.iniciar();
    }
}
