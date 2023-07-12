import java.util.ArrayList;

public class ServicioPedido {
    private ArrayList<Pedido> pedidos;

    public ServicioPedido() {
        pedidos = new ArrayList<Pedido>();
    }

    public void agregarPedido(String idProveedor, ServicioProveedor servicioProveedor, Pedido pedido) {
        boolean noExiste = true;
        boolean noTieneSustanciaProveedor = true;
        try {
            noExiste = servicioProveedor.noExisteProveedor(idProveedor);
            if (!noExiste) {
                for (int i = 0; i < pedido.getSustanciasPedidasId().size(); i++) {
                noTieneSustanciaProveedor = servicioProveedor.proveedorNoTieneSustancia(idProveedor, pedido.getSustanciasPedidasId().get(i));
                    if (noTieneSustanciaProveedor) {
                        throw new Exception("El proveedor -->>" + idProveedor + "<<-- no tiene la sustancia -->>" + pedido.getSustanciasPedidasId().get(i) + "<<--");
                    }
                }
                noExiste = noExistePedido(pedido.getId(), false);
                if (noExiste) {
                    pedidos.add(pedido);
                    System.out.println("El pedido -->>" + pedido.getId() + "<<-- ha sido agregado CORRECTAMENTE");
                }
                else {
                    throw new Exception("Ya existe un pedido con el id -->>" + pedido.getId() + "<<--");
                }
            }
            else {
                throw new Exception("No existe un proveedor con el id -->>" + idProveedor + "<<--");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void buscarPedido(String id) {
        boolean noExiste = true;
        try {
            noExiste = noExistePedido(id, true);
            if (noExiste) {
                throw new Exception("No existe un pedido con el id -->>" + id + "<<--");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void cambiarEstado(String id, String nuevoEstado) {
        boolean noExiste = true;
        try {
            noExiste = noExistePedido(nuevoEstado, false);
            System.out.println("noExiste: " + noExiste);
            if (!noExiste) {
                for (Pedido pedido : pedidos) {
                    if (pedido.getId().equals(id)) {
                        if (pedido.getEstado().equals("en proceso") && nuevoEstado.equals("completado")) {
                            pedido.setEstado(nuevoEstado);
                            System.out.println("El pedido -->>" + pedido.getId() + "<<-- ha sido cambiado a -->>" + pedido.getEstado() + "<<-- CORRECTAMENTE");
                            break;
                        } else if (pedido.getEstado().equals("en proceso") && nuevoEstado.equals("cancelado")) {
                            pedido.setEstado(nuevoEstado);
                            System.out.println("El pedido -->>" + pedido.getId() + "<<-- ha sido cambiado a -->>" + pedido.getEstado() + "<<-- CORRECTAMENTE");
                            break;
                        } else {
                            throw new Exception("Transición de estados ilegal");
                        }
                    }
                }
            } else {
                throw new Exception("No existe un pedido con el id -->>" + id + "<<--");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void mostrarPedidosOrdenados() {
        ArrayList<Pedido> pedidosOrdenados = new ArrayList<Pedido>();
        boolean estadoEnProceso = true, estadoCompletado = true, estadoCancelado = true;
        for (Pedido pedido : pedidos) {
            if (pedido.getEstado().equals("en proceso")) {
                pedidosOrdenados.add(pedido);
            }
        }
        for (Pedido pedido : pedidos) {
            if (pedido.getEstado().equals("completado")) {
                pedidosOrdenados.add(pedido);
            }
        }
        for (Pedido pedido : pedidos) {
            if (pedido.getEstado().equals("cancelado")) {
                pedidosOrdenados.add(pedido);
            }
        }
        
        for (Pedido pedido : pedidosOrdenados) {
            if (estadoEnProceso && pedido.getEstado().equals("en proceso")) {
                System.out.println("Pedidos en proceso:\n --------------------");
                estadoEnProceso = false;
            }
            if (estadoCompletado && pedido.getEstado().equals("completado")) {
                System.out.println("Pedidos completados:\n --------------------");
                estadoCompletado = false;
            }
            if (estadoCancelado && pedido.getEstado().equals("cancelado")) {
                System.out.println("Pedidos cancelados:\n --------------------");
                estadoCancelado = false;
            }
            System.out.println(pedido);
        }
    }

    public void mostrarPedidosPorProveedor(String idProveedor, ServicioProveedor servicioProveedor) {
        boolean noExisteProveedor = true;
        boolean noExistePedido = true;
        try {
            System.out.println("Pedidos del proveedor -->>" + idProveedor + "<<--:\n --------------------");
            noExisteProveedor = servicioProveedor.noExisteProveedor(idProveedor);
            if (!noExisteProveedor) {
                for (Pedido pedido : pedidos) {
                    if (pedido.getProveedor().equals(idProveedor)) {
                        System.out.println(pedido);
                        noExistePedido = false;
                    }
                }
                if (noExistePedido) {
                    throw new Exception("El proveedor -->>" + idProveedor + "<<-- no tiene pedidos registrados");
                }
            } else {
                throw new Exception("No existe un proveedor con el id -->>" + idProveedor + "<<--");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private boolean noExistePedido(String id, boolean mostrarlo) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId().equals(id)) {
                if (mostrarlo) {
                    System.out.println(pedido);
                }
                return false;
            }
        }
        return true;
    }
}
