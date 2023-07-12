import java.time.LocalDate;

public class SustanciaGas extends Sustancia {
    private double presion;

    public SustanciaGas(String id, String nombre, LocalDate fechaExpiracion, double cantidad, double presion) {
        super(id, nombre, fechaExpiracion, cantidad);
        this.presion = presion;
    }

    @Override
    public String toString() {
        return "SustanciaGas " + super.toString() + ", presion=" + presion + "]";
    }

    @Override
    public boolean comprobarValores() {
        try {
            comprobarPresion();
            return true;
        } catch (ExceptionUnchecked e) {
            System.out.println("Error: " + e.getMessage() + "\n -------------------------------");
            return false;
        }
    }

    public void comprobarPresion() throws ExceptionUnchecked {
        if (presion < 0.2 || presion > 5) {
            throw new ExceptionUnchecked("La presion de la sustancia -->>" +  getNombre() + " " + getId() + "<<-- debe estar entre 0.5 y 2.5");
        }
    }

}