import java.util.ArrayList;
import java.util.List;

public class ServicioProveedor {
    private List<Proveedor> proveedores;

    public ServicioProveedor() {
        proveedores = new ArrayList<Proveedor>();
    }

    public void agregarProveedor(Proveedor proveedor) {
        boolean noExiste = true;
        try {
            noExiste = noExisteProveedor(proveedor.getId());
            if (noExiste) {
                proveedores.add(proveedor);
                System.out.println("El proveedor -->>" + proveedor.getNombre() + "-" + proveedor.getId() + "<<-- ha sido agregado CORRECTAMENTE");
            }
            else {
                throw new Exception("Ya existe un proveedor con el id -->>" + proveedor.getId() + "<<--");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void eliminarProveedor(String id) {
        boolean noExiste = true;
        try {
            noExiste = noExisteProveedor(id);
            if (!noExiste) {
                for (Proveedor proveedor : proveedores) {
                    if (proveedor.getId().equals(id)) {
                        proveedores.remove(proveedor);
                        System.out.println("El proveedor -->>" + proveedor.getNombre() + "-" + proveedor.getId() + "<<-- ha sido eliminado CORRECTAMENTE");
                        break;
                    }
                }
            } else {
                throw new Exception("No existe un proveedor con el id -->>" + id + "<<--");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void buscarProveedor(String id) {
        boolean noExiste = true;
        try {
            noExiste = noExisteProveedor(id);
            if (!noExiste) {
                for (Proveedor proveedor : proveedores) {
                    if (proveedor.getId().equals(id)) {
                        System.out.println(proveedor);
                        break;
                    }
                }
            } else {
                throw new Exception("No existe un proveedor con el id -->>" + id + "<<--");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void mostrarProveedores() {
        try {
            if (proveedores.size() == 0) {
                throw new Exception("No hay proveedores registrados");
            }
            else {
                for (Proveedor proveedor : proveedores) {
                    System.out.println(proveedor);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void mostrarProveedoresSustancia(String nombreSustancia) {
        boolean noExiste = true;
        try {
            if (proveedores.size() == 0) {
                throw new Exception("No hay proveedores registrados");
            }
            else {
                for (Proveedor proveedor : proveedores) {
                    for (String sustancia : proveedor.getProveedorSustancias()) {
                        if (sustancia.equals(nombreSustancia)) {
                            System.out.println(proveedor);
                            noExiste = false;
                        }
                    }
                }
                if (noExiste) {
                    throw new Exception("No hay proveedores que provean la sustancia -->>" + nombreSustancia + "<<--");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public boolean noExisteProveedor(String id) {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getId().equals(id)) {
                return false;
            }
        }
        return true;
    }

    public boolean proveedorNoTieneSustancia(String idProveedor, String idSustancia) {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getId().equals(idProveedor)) {
                for (String sustancia : proveedor.getProveedorSustancias()) {
                    if (sustancia.equals(idSustancia)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
