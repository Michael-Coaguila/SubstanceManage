import java.util.List;

public class Proveedor {
    private String id;
    private String nombre;
    private String direccion;
    private String contacto;
    private List<String> proveedorSustancias;

    public Proveedor(String id, String nombre, String direccion, String contacto, List<String> proveedorSustancias) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.contacto = contacto;
        this.proveedorSustancias = proveedorSustancias;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getProveedorSustancias() {
        return proveedorSustancias;
    }

    public String toString() {
        return "Proveedor [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", contacto=" + contacto
                + ", proveedorSustancias=" + proveedorSustancias + "]";
    }

}
