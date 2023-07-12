import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Inventario implements GestionDeStock {
    private List<Sustancia> sustancias;

    public Inventario() {
        sustancias = new ArrayList<Sustancia>();
    }

    @Override
    public void anadirSustanciaStock(Sustancia sustancia) {

        boolean noExiste = true;
        for (Sustancia s : sustancias) {
            try {
                if (s.getId().equals(sustancia.getId())) {
                    noExiste = false;
                    throw new ExceptionUnchecked("El id -->>" + sustancia.getId() + "<<-- ya existe en el inventario");
                }
            } catch (ExceptionUnchecked e) {
                System.out.println("Error: " + e.getMessage() + "\n -------------------------------");
            }
        }
        if (noExiste) {
                if (sustancia.comprobarValores() && sustancia.comprobarFechaExpiracion()) {
                    sustancias.add(sustancia);
                    System.out.println("La sustancia -->>" + sustancia.getNombre() + " " + sustancia.getId() + "<<-- ha sido añadida al inventario");
                }
            }
    }

    @Override
    public void verificarStock(String nombreSustanciaVerificar) {

        double cantidad = 0;
        boolean noExiste = true;
        for (Sustancia sustancia : sustancias) {
            if (sustancia.getNombre().equals(nombreSustanciaVerificar)) {
                noExiste = false;
                cantidad += sustancia.getCantidad();
                System.out.println(sustancia);
            }
        }
        try {
            if (noExiste) {
                throw new ExceptionUnchecked("La sustancia " + nombreSustanciaVerificar + " no existe en el inventario");
            }
        } catch (ExceptionUnchecked e) {
            System.out.println("Error: " + e.getMessage() + "\n -------------------------------");
        }
        System.out.println("Cantidad total de " + nombreSustanciaVerificar + " en el inventario: " + cantidad);
    }

    @Override
    public void mostrarSustancias() {

        Set<String> grupos = new HashSet<String>();
        for (Sustancia sustancia : sustancias) {
            grupos.add(sustancia.getClass().getSimpleName());
        }
        try {
            if (grupos.isEmpty()) {
                throw new ExceptionUnchecked("No hay sustancias registradas en el inventario");
            }
        } catch (ExceptionUnchecked e) {
            System.out.println("Error: " + e.getMessage() + "\n -------------------------------");
        }
        for (String grupo : grupos) {
            mostrarSustanciasGrupo(grupo);
        }

    }

    public void mostrarSustanciasGrupo(String grupo) {

        boolean noExiste = true;
        System.out.println("Sustancias del grupo " + grupo + ":");
        for (Sustancia sustancia : sustancias) {
            if (sustancia.getClass().getSimpleName().equals(grupo)) {
                noExiste = false;
                System.out.println(sustancia);
            }
        }
        try {
            if (noExiste) {
                throw new ExceptionUnchecked("El grupo -->>" + grupo + "<<-- no registra sustancias en el inventario");
            }
        } catch (ExceptionUnchecked e) {
            System.out.println("Error: " + e.getMessage() + "\n -------------------------------");
        }
    }

    @Override
    public void actualizarSustanciaStock(String idSustancia , double cantidad) {

        boolean noExiste = true;
        for (Sustancia sustancia : sustancias) {
            if (sustancia.getId().equals(idSustancia)) {
                noExiste = false;
                try {
                    if (sustancia.getCantidad() + cantidad >= 0) {
                        sustancia.setCantidad(sustancia.getCantidad() + cantidad);
                        System.out.println("Cantidad de -->>" + sustancia.getNombre() + "-" + sustancia.getId() + "<<-- actualizada a -->>" + sustancia.getCantidad() + "<<--");
                        System.out.println(sustancia);
                    } else {
                        throw new ExceptionUnchecked("No hay suficiente cantidad de -->>" + sustancia.getNombre() + "<<-- para actualizar en -->>" + sustancia.getCantidad() + "<<--");
                    }
                } catch (ExceptionUnchecked e) {
                    System.out.println("Error: " + e.getMessage() + "\n -------------------------------");
                }
            }
        }
        try {
            if (noExiste) {
                throw new ExceptionUnchecked("La sustancia con id -->>" + idSustancia + "<<-- no existe en el inventario");
            }
        } catch (ExceptionUnchecked e) {
            System.out.println("Error: " + e.getMessage() + "\n -------------------------------");
        }
    }

    @Override
    public void eliminarCantidadSustanciaStock(String idSustancia , double cantidad) {

        boolean noExiste = true;
        for (Sustancia sustancia : sustancias) {
            if (sustancia.getId().equals(idSustancia)) {
                noExiste = false;
                try {
                    if (sustancia.getCantidad() - cantidad >= 0) {
                        sustancia.setCantidad(sustancia.getCantidad() - cantidad);
                        System.out.println("Cantidad de -->>" + sustancia.getNombre() + "-" + sustancia.getId() + "<<-- actualizada a -->>" + sustancia.getCantidad() + "<<--");
                        System.out.println(sustancia);
                    } else {
                        throw new ExceptionUnchecked("No hay suficiente cantidad de -->>" + sustancia.getNombre() + "<<-- para eliminar en -->>" + sustancia.getId() + "<<-- ");
                    }
                } catch (ExceptionUnchecked e) {
                    System.out.println("Error: " + e.getMessage() + "\n -------------------------------");
                }
            }
        }
        try {
            if (noExiste) {
                throw new ExceptionUnchecked("La sustancia con id -->>" + idSustancia + "<<-- no existe en el inventario");
            }
        } catch (ExceptionUnchecked e) {
            System.out.println("Error: " + e.getMessage() + "\n -------------------------------");
        }
    }
    public void eliminarSustanciaStock() {
        boolean noExiste = true;
        for (Sustancia sustancia : sustancias) {
            if (sustancia.getCantidad() == 0) {
                noExiste = false;
                System.out.println(sustancia);
                sustancias.remove(sustancia);
                System.out.println("Sustancia eliminada del inventario");
                break;
            }
        }
        try {
            if (noExiste) {
                throw new ExceptionUnchecked("No se han encontrado sustancias con cantidad 0 en el inventario");
            }
        } catch (ExceptionUnchecked e) {
            System.out.println("Error: " + e.getMessage() + "\n -------------------------------");
        }
    }

    public boolean encontrarPorCodigo(String codigo) {
            boolean noExiste = true;
            for (Sustancia sustancia : sustancias) {
                if (sustancia.getId().equals(codigo)) {
                    noExiste = false;
                    System.out.println(sustancia);
                }
            }
            try {
                if (noExiste) {
                    throw new ExceptionUnchecked("No se ha encontrado ninguna sustancia con el código -->>" + codigo + "<<--");
                }
            } catch (ExceptionUnchecked e) {
                System.out.println("Error: " + e.getMessage() + "\n -------------------------------");
            }
            return noExiste;
    }
}
