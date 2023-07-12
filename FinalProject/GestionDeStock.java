public interface GestionDeStock {

    void anadirSustanciaStock(Sustancia sustancia);

    void verificarStock(String sustanciaVerificar);

    void mostrarSustancias();

    void actualizarSustanciaStock(String idSustancia, double cantidad);

    void eliminarCantidadSustanciaStock(String idSustancia, double cantidad);
}
