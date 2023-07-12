import java.util.List;

public class Pedido {
    private String id;
    private String proveedor;
    private String estado; // "en proceso", "completado", "cancelado"
    private List<String> sustanciasPedidasId;
    private List<Double> cantidadSustanciasPedidas;

    public Pedido (String id, String proveedor, String estado, List<String> sustanciasPedidasId, List<Double> cantidadSustanciasPedidas) {
        this.id = id;
        this.proveedor = proveedor;
        this.estado = estado;
        this.sustanciasPedidasId = sustanciasPedidasId;
        this.cantidadSustanciasPedidas = cantidadSustanciasPedidas;
    }
    
    public String getId() {
        return id;
    }

    public String getProveedor() {
        return proveedor;
    }

    public String getEstado() {
        return estado;
    }

    public List<String> getSustanciasPedidasId() {
        return sustanciasPedidasId;
    }

    public List<Double> getCantidadSustanciasPedidas() {
        return cantidadSustanciasPedidas;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String toString() {
        return "Pedido [id=" + id + ", proveedor=" + proveedor + ", estado=" + estado + "]" + "\nsustanciasPedidasId - Cantidad\n"
                + mostrarLaSustanciaConSuCantidad();
    }

    public String mostrarLaSustanciaConSuCantidad() {
        String resultado = "";
        for (int i = 0; i < sustanciasPedidasId.size(); i++) {
            resultado += sustanciasPedidasId.get(i) + " " + cantidadSustanciasPedidas.get(i) + "\n";
        }
        return resultado;
    }
}
