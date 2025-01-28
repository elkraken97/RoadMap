package prob11;

public class Producto {
private String nombre;
private int cantidad_vendida;
private float precio;

    public Producto(int cantidad_vendida, float precio, String nombre) {
        this.cantidad_vendida = cantidad_vendida;
        this.precio = precio;
        this.nombre = nombre;
    }

    public Producto() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad_vendida() {
        return cantidad_vendida;
    }

    public void setCantidad_vendida(int cantidad_vendida) {
        this.cantidad_vendida = cantidad_vendida;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
