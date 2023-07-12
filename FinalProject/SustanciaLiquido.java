import java.time.LocalDate;

public class SustanciaLiquido extends Sustancia {
    private double viscosidad;

    public SustanciaLiquido(String id, String nombre, LocalDate fechaExpiracion, double cantidad, double viscosidad) {
        super(id, nombre, fechaExpiracion, cantidad);
        this.viscosidad = viscosidad;
    }

    @Override
    public String toString() {
        return "SustanciaLiquido " + super.toString() + ", viscosidad=" + viscosidad + "]";
    }

    @Override
    public boolean comprobarValores() {
        try {
            comprobarViscosidad();
            return true;
        } catch (ExceptionUnchecked e) {
            System.out.println("Error: " + e.getMessage() + "\n -------------------------------");
            return false;
        }
    }

    public void comprobarViscosidad() throws ExceptionUnchecked {
        if (viscosidad < 1 || viscosidad > 100) {
            throw new ExceptionUnchecked("La viscosidad de la sustancia -->>" +  getNombre() + " " + getId() + "<<-- debe estar entre 0.5 y 2.5");
        }
    }
}
