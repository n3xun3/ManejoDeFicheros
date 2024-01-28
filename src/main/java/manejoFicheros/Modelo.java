package manejoFicheros;

import java.util.ArrayList;


public class Modelo {
    private ArrayList<Modelo> listaArticulos;
    private int id;
    private String nombre;
    private String descripcion;
    private int stock;
    private double precio;

    public Modelo(int id, String nombre, String descripcion, int stock, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
        this.listaArticulos = new ArrayList<>();
    }

    public Modelo() {
		// TODO Apéndice de constructor generado automáticamente
    	this.listaArticulos = new ArrayList<>();
	}

	public boolean agregarArticulo(Modelo nuevoArticulo) {
        for (Modelo articulo : listaArticulos) {
            if (articulo.getId() == nuevoArticulo.getId()) {
                return false; // El ID ya existe, no se puede agregar
            }
        }
        listaArticulos.add(nuevoArticulo);
        return true; // Artículo agregado correctamente
    }

    public boolean borrarArticulo(int id) {
        for (Modelo articulo : listaArticulos) {
            if (articulo.getId() == id) {
                listaArticulos.remove(articulo);
                return true; // Artículo borrado correctamente
            }
        }
        return false; // No se encontró ningún artículo con ese ID
    }

    public Modelo consultarArticulo(int id) {
        for (Modelo articulo : listaArticulos) {
            if (articulo.getId() == id) {
                return articulo; // Devolver el artículo encontrado
            }
        }
        return null; // No se encontró ningún artículo con ese ID
    }

    public ArrayList<Modelo> listarArticulos() {
        return listaArticulos; // Devolver todos los artículos
    }

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

