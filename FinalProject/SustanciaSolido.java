import java.time.LocalDate;

public class SustanciaSolido extends Sustancia {
    private double densidad;

    public SustanciaSolido(String id, String nombre, LocalDate fechaExpiracion, double cantidad, double densidad) {
        super(id, nombre, fechaExpiracion, cantidad);
        this.densidad = densidad;
    }

    @Override
    public String toString() {
        return "SustanciaSolido " + super.toString() + ", densidad=" + densidad + "]";
    }

    @Override
    public boolean comprobarValores() {
        try {
            comprobarDensidad();
            return true;
        } catch (ExceptionUnchecked e) {
            System.out.println("Error: " + e.getMessage() + "\n -------------------------------");
            return false;
        }
    }

    public void comprobarDensidad() throws ExceptionUnchecked {
        if (densidad < 0.8 || densidad > 1.2) {
            throw new ExceptionUnchecked("La densidad de la sustancia -->>" +  getNombre() + " " + getId() + "<<-- debe estar entre 0.5 y 2.5");
        }
    }

}
