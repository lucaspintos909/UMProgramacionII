package parciales;

import java.util.Objects;

public class Producto {
    private String nombre;
    private Float precio;

    public Float getPrecio() {
        return precio;
    }

    public Producto(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(nombre, producto.nombre);
    }

    public String getNombre() {
        return nombre;
    }
}
