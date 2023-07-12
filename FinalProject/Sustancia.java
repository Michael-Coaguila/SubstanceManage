import java.time.LocalDate;

public abstract class Sustancia {
    private String id;
    private String nombre;
    private LocalDate fechaExpiracion;
    private double cantidad;

    public Sustancia(String id, String nombre, LocalDate fechaExpiracion, double cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.fechaExpiracion = fechaExpiracion;
        this.cantidad = cantidad;
    }

    public LocalDate getFechaExpiracion() {
        return fechaExpiracion;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String toString() {
        return "[id=" + id + ", nombre=" + nombre + ", fechaExpiracion=" + fechaExpiracion + ", cantidad="
                + cantidad;
    }

    public boolean comprobarFechaExpiracion(){
        try {
            fechaExpiracion();
            return true;
        } catch (ExceptionUnchecked e) {
            System.out.println("Error: " + e.getMessage() + "\n -------------------------------");
            return false;
        }
    }

    public void fechaExpiracion(){
        if (fechaExpiracion.isBefore(LocalDate.now())) {
            throw new ExceptionUnchecked("La sustancia -->>" + nombre + " " + id + "<<-- ha expirado");
        }
    }

    public abstract boolean comprobarValores();
}
