package manejoFicheros;

import java.util.ArrayList;

/**
 * La clase Modelo representa un artículo con un identificador único, nombre, descripción, stock y precio.
 */
public class Modelo {
    private ArrayList<Modelo> listaArticulos; // Lista de artículos
    private int id; // Identificador único del artículo
    private String nombre; // Nombre del artículo
    private String descripcion; // Descripción del artículo
    private int stock; // Cantidad de stock disponible del artículo
    private double precio; // Precio del artículo

    /**
     * Constructor para la clase Modelo.
     * @param id El identificador único del artículo.
     * @param nombre El nombre del artículo.
     * @param descripcion La descripción del artículo.
     * @param stock El stock disponible del artículo.
     * @param precio El precio del artículo.
     */
    public Modelo(int id, String nombre, String descripcion, int stock, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
        this.listaArticulos = new ArrayList<>();
    }

    /**
     * Constructor por defecto para la clase Modelo.
     */
    public Modelo() {
		// TODO Apéndice de constructor generado automáticamente
    	this.listaArticulos = new ArrayList<>();
	}

    /**
     * Método para agregar un nuevo artículo a la lista de artículos.
     * @param nuevoArticulo El nuevo artículo a agregar.
     * @return true si el artículo se agregó correctamente, false si el ID ya existe.
     */
	public boolean agregarArticulo(Modelo nuevoArticulo) {
        for (Modelo articulo : listaArticulos) {
            if (articulo.getId() == nuevoArticulo.getId()) {
                return false; // El ID ya existe, no se puede agregar
            }
        }
        listaArticulos.add(nuevoArticulo);
        return true; // Artículo agregado correctamente
    }

    /**
     * Método para borrar un artículo de la lista de artículos.
     * @param id El identificador del artículo a borrar.
     * @return true si el artículo se borró correctamente, false si no se encontró ningún artículo con ese ID.
     */
    public boolean borrarArticulo(int id) {
        for (Modelo articulo : listaArticulos) {
            if (articulo.getId() == id) {
                listaArticulos.remove(articulo);
                return true; // Artículo borrado correctamente
            }
        }
        return false; // No se encontró ningún artículo con ese ID
    }

    /**
     * Método para consultar un artículo de la lista de artículos.
     * @param id El identificador del artículo a consultar.
     * @return El artículo encontrado, o null si no se encontró ningún artículo con ese ID.
     */
    public Modelo consultarArticulo(int id) {
        for (Modelo articulo : listaArticulos) {
            if (articulo.getId() == id) {
                return articulo; // Devolver el artículo encontrado
            }
        }
        return null; // No se encontró ningún artículo con ese ID
    }

    /**
     * Método para listar todos los artículos.
     * @return La lista de todos los artículos.
     */
    public ArrayList<Modelo> listarArticulos() {
        return listaArticulos; // Devolver todos los artículos
    }

    // Getters y setters para los campos de la clase Modelo
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

