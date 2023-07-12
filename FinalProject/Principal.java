import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class Principal {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        ServicioProveedor servicioProveedor = new ServicioProveedor();   
        ServicioPedido servicioPedido = new ServicioPedido();
        Scanner scanner = new Scanner(System.in);

        //!! Inventario de prueba
        // SustanciaGas de prueba - presion 0.2~5.0
        inventario.anadirSustanciaStock(new SustanciaGas("G01", "Hidrogeno", LocalDate.parse("2024-12-31"), 100, 2.5));
        inventario.anadirSustanciaStock(new SustanciaGas("G02", "Hidrogeno", LocalDate.parse("2023-08-01"), 120, 2));
        inventario.anadirSustanciaStock(new SustanciaGas("G03", "Hidrogeno", LocalDate.parse("2024-12-31"), 100, 2.5));
        inventario.anadirSustanciaStock(new SustanciaGas("G04", "Hidrogeno", LocalDate.parse("2023-08-01"), 120, 2));

        // SustanciaLiquido de prueba - viscosidad 0.1~100.0
        inventario.anadirSustanciaStock(new SustanciaLiquido("L01", "Aceite", LocalDate.parse("2021-12-31"), 100, 1.5));
        inventario.anadirSustanciaStock(new SustanciaLiquido("L02", "Aceite", LocalDate.parse("2021-12-31"), 100, 1.5));
        inventario.anadirSustanciaStock(new SustanciaLiquido("L03", "Aceite", LocalDate.parse("2021-12-31"), 100, 1.5));
        inventario.anadirSustanciaStock(new SustanciaLiquido("L04", "Aceite", LocalDate.parse("2021-12-31"), 100, 1.5));

        // SustanciaSolido de prueba - densidad 0.8~1.2
        inventario.anadirSustanciaStock(new SustanciaSolido("S01", "Plomo", LocalDate.parse("2021-12-31"), 100, 3.5));
        inventario.anadirSustanciaStock(new SustanciaSolido("S02", "Plomo", LocalDate.parse("2021-12-31"), 100, 3.5));
        inventario.anadirSustanciaStock(new SustanciaSolido("S03", "Plomo", LocalDate.parse("2021-12-31"), 100, 3.5));
        inventario.anadirSustanciaStock(new SustanciaSolido("S04", "Plomo", LocalDate.parse("2021-12-31"), 100, 3.5));


        //!! Proveedores de prueba
        List<String> listaSustancias = Arrays.asList("G01", "G02", "G03", "G04");
        servicioProveedor.agregarProveedor(new Proveedor("P01", "Proveedor 1", "Calle 1", "123456789", listaSustancias));
        servicioProveedor.agregarProveedor(new Proveedor("P02", "Proveedor 2", "Calle 2", "987654321", Arrays.asList("L01", "L02", "L03", "L04")));
        servicioProveedor.agregarProveedor(new Proveedor("P03", "Proveedor 3", "Calle 3", "123456789", Arrays.asList("S01", "S02", "S03", "S04")));
        servicioProveedor.agregarProveedor(new Proveedor("P04", "Proveedor 4", "Calle 4", "987654321", Arrays.asList("G01", "G02", "G03", "G04")));
        servicioProveedor.agregarProveedor(new Proveedor("P05", "Proveedor 5", "Calle 5", "123456789", Arrays.asList("G03", "L04")));

        //!! Pedidos de prueba
        servicioPedido.agregarPedido("P01", servicioProveedor, new Pedido("P01", "G01", "en proceso", Arrays.asList("G01", "G02", "G03", "G04"), Arrays.asList(10.0, 20.0, 30.0, 40.0)));
        servicioPedido.agregarPedido("P02", servicioProveedor, new Pedido("P02", "L01", "en proceso", Arrays.asList("L01", "L02", "L03", "L04"), Arrays.asList(10.0, 20.0, 30.0, 40.0)));
        servicioPedido.agregarPedido("P03", servicioProveedor, new Pedido("P03", "S01", "completado", Arrays.asList("S01", "S02", "S03", "S04"), Arrays.asList(10.0, 20.0, 30.0, 40.0)));
        servicioPedido.agregarPedido("P04", servicioProveedor, new Pedido("P04", "G01", "en proceso", Arrays.asList("G01", "G02", "G03", "G04"), Arrays.asList(10.0, 20.0, 30.0, 40.0)));
        servicioPedido.agregarPedido("P05", servicioProveedor, new Pedido("P05", "G03", "en proceso", Arrays.asList("G03", "L04"), Arrays.asList(10.0, 20.0)));
        servicioPedido.agregarPedido("P01", servicioProveedor, new Pedido("P06", "G01", "completado", Arrays.asList("G01", "G02", "G03", "G04"), Arrays.asList(10.0, 20.0, 30.0, 40.0)));

        // Manejo de la interfaz de usuario
        while (true) {
            mostrarMenuPrincipal();
            
            int opcion = scanner.nextInt();
            switch (opcion) {
            case 1:
                // Método que maneja la visualización y la gestión del inventario
                do {
                    mostrarMenuInventario();
                    opcion = scanner.nextInt();
                    opcionMenuInventario(opcion, inventario, scanner);
                } while (opcion != 8);
                break;
            case 2:
                // Método que maneja la visualización y la gestión de los proveedores
                do {
                    mostrarMenuProveedores();
                    opcion = scanner.nextInt();
                    opcionMenuProveedores(opcion, servicioProveedor, scanner);
                } while (opcion != 6);
                break;
            case 3:
                // Método que maneja la visualización y la gestión de los pedidos
                do {
                    mostrarMenuPedidos();
                    opcion = scanner.nextInt();
                    opcionMenuPedidos(opcion, servicioPedido, servicioProveedor, scanner);
                } while (opcion != 6);
                break;
            case 4:
                // Salir del programa
                System.out.println("Saliendo del programa...");
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.
                println("Opción no reconocida. Por favor, introduzca un número del 1 al 4.");
                break;
            }
        }

    }

    private static void mostrarMenuPrincipal() {
        System.out.println("Menú principal");
        System.out.println("1. Gestión de inventario");
        System.out.println("2. Gestión de proveedores");
        System.out.println("3. Gestión de pedidos");
        System.out.println("4. Salir del programa");
    }

    private static void mostrarMenuInventario() {
        System.out.println("Menú inventario");
        System.out.println("1. Añadir sustancia");
        System.out.println("2. Modificar sustancia(descontar cantidad)");
        System.out.println("3. Modificar sustancia(agregar cantidad)");
        System.out.println("4. Mostrar todas las sustancias");
        System.out.println("5. Mostrar sustancias por grupo");
        System.out.println("6. Mostrar stock de una sustancia");
        System.out.println("7. Formatear inventario(eliminar sustancias sin stock)");
        System.out.println("8. Volver al menú principal");
    }

    public static void opcionMenuInventario(int opc, Inventario inventario, Scanner scannerInventario) {
        int tipoSustancia = 0;

        switch (opc) {
            case 1:
                System.out.println("Añadir Sustancia\n ---------------------------------");
                do {
                    System.out.println("Tipo de sustancia: ");
                    System.out.println("1. SustanciaGas");
                    System.out.println("2. SustanciaLiquido");
                    System.out.println("3. SustanciaSolido");
                    System.out.println("4. Volver al menú inventario");
                    
                    tipoSustancia = scannerInventario.nextInt();
                    if (tipoSustancia == 1)
                        System.out.println("Añadir sustancia gas\n ------------------");
                    else if (tipoSustancia == 2)
                        System.out.println("Añadir sustancia líquido\n ------------------");
                    else if (tipoSustancia == 3)
                        System.out.println("Añadir sustancia sólido\n ------------------");
                    else
                        System.out.println("Opción no válida");
                } while (tipoSustancia != 1 && tipoSustancia != 2 && tipoSustancia != 3 && tipoSustancia != 4);
                if (tipoSustancia == 4)
                    break;
                System.out.println("Introduzca el código de la sustancia: ");
                String codigo = scannerInventario.next();
                System.out.println("Introduzca el nombre de la sustancia: ");
                String nombre = scannerInventario.next();
                System.out.println("Introduzca la fecha de caducidad de la sustancia (yyyy-mm-dd): ");
                LocalDate fechaCaducidad = LocalDate.parse(scannerInventario.next());
                System.out.println("Introduzca la cantidad de la sustancia: ");
                int cantidad = scannerInventario.nextInt();
                if (tipoSustancia == 1){
                    System.out.println("Introduzca la presión de la sustancia: ");
                    double presion = scannerInventario.nextDouble();
                    inventario.anadirSustanciaStock(new SustanciaGas(codigo, nombre, fechaCaducidad, cantidad, presion));
                }
                else if (tipoSustancia == 2) {
                    System.out.println("Introduzca la densidad de la sustancia: ");
                    double densidad = scannerInventario.nextDouble();
                    inventario.anadirSustanciaStock(new SustanciaLiquido(codigo, nombre, fechaCaducidad, cantidad, densidad));
                }
                else if (tipoSustancia == 3) {
                    System.out.println("Introduzca la densidad de la sustancia: ");
                    double densidad = scannerInventario.nextDouble();
                    inventario.anadirSustanciaStock(new SustanciaSolido(codigo, nombre, fechaCaducidad, cantidad, densidad));                
                }
                break;
            case 2:
                System.out.println("Modificar Sustancia(descontar cantidad)\n ---------------------------------");
                System.out.print("Introduzca el código de la sustancia: ");
                String codigoSustancia = scannerInventario.next();
                if (!inventario.encontrarPorCodigo(codigoSustancia)) {
                    System.out.print("Introduzca la cantidad a eliminar de la sustancia: ");
                    double cantidadEliminar = scannerInventario.nextDouble();
                    inventario.eliminarCantidadSustanciaStock(codigoSustancia, cantidadEliminar);
                }
                break;
            case 3:
                System.out.println("Modificar sustancia(agregar cantidad)\n ---------------------------------");
                System.out.print("Introduzca el código de la sustancia: ");
                String codigoSustancia2 = scannerInventario.next();
                if (!inventario.encontrarPorCodigo(codigoSustancia2)) {
                    System.out.print("Introduzca la cantidad a agregar de la sustancia: ");
                    double cantidadAgregar = scannerInventario.nextDouble();
                    inventario.actualizarSustanciaStock(codigoSustancia2, cantidadAgregar);
                }
                break;
            case 4:
                System.out.println("Mostrar todas las sustancias\n ---------------------------------");
                inventario.mostrarSustancias();
                break;
            case 5:
                System.out.println("Mostrar sustancias por grupo\n ---------------------------------");
                System.out.print("Introduzca el grupo de sustancias: ");
                String grupo = scannerInventario.next();
                inventario.mostrarSustanciasGrupo(grupo);
                break;
            case 6:
                System.out.println("Mostrar stock de una sustancia\n ---------------------------------");
                System.out.print("Introduzca el nombre de la sustancia: ");
                String nombreSustancia = scannerInventario.next();
                inventario.verificarStock(nombreSustancia);
                break;
            case 7:
                System.out.println("Formatear inventario(eliminar sustancias sin stock)\n ---------------------------------");
                System.out.print("¿Está seguro de que desea eliminar las sustancias sin stock? (s/n): ");
                String respuesta = scannerInventario.next();
                if (respuesta.equals("s"))
                    inventario.eliminarSustanciaStock();
                else
                    System.out.println("No se eliminaron las sustancias sin stock");
                break;
            case 8:
                System.out.println("Volver al menú principal\n ---------------------------------");
                break;
            default:{
                System.out.println("Opción inválida\n ---------------------------------");
                break;
            }
        }
    }

    private static void mostrarMenuProveedores() {
        System.out.println("Menú proveedores");
        System.out.println("1. Añadir proveedor");
        System.out.println("2. Eliminar proveedor");
        System.out.println("3. Buscar proveedor");
        System.out.println("4. Mostrar proveedores");
        System.out.println("5. Mostrar proveedores por sustancia");
        System.out.println("6. Volver al menú principal");
    }

    private static void opcionMenuProveedores(int opc, ServicioProveedor servicioProveedor, Scanner scannerProveedores) {
        switch (opc) {
            case 1:
                System.out.println("Añadir proveedor\n ---------------------------------");
                System.out.println("Introduzca el id del proveedor: ");
                String id = scannerProveedores.next();
                System.out.println("Introduzca el nombre del proveedor: ");
                String nombre = scannerProveedores.next();
                System.out.println("Introduzca el número de teléfono del proveedor: ");
                String telefono = scannerProveedores.next();
                System.out.println("Introduzca el correo electrónico del proveedor: ");
                String correo = scannerProveedores.next();
                // Ingresar la lista de sustancias que provee el proveedor
                System.out.println("¿Cuántas sustancias provee el proveedor? ");
                int numSustancias = scannerProveedores.nextInt();
                List<String> sustanciasListP = new ArrayList<String>();
                for (int j = 0; j < numSustancias; j++) {
                    System.out.println("Introduzca el código de la sustancia: ");
                    String codigoSustancia = scannerProveedores.next();
                    sustanciasListP.add(codigoSustancia);
                }
                servicioProveedor.agregarProveedor(new Proveedor(id, nombre, telefono, correo, sustanciasListP));
                break;
            case 2:
                System.out.println("Eliminar proveedor\n ---------------------------------");
                System.out.println("Introduzca el id del proveedor: ");
                String idProveedor = scannerProveedores.next();
                servicioProveedor.eliminarProveedor(idProveedor);
                break;
            case 3:
                System.out.println("Buscar proveedor\n ---------------------------------");
                System.out.println("Introduzca el id del proveedor: ");
                String idProveedor2 = scannerProveedores.next();
                servicioProveedor.buscarProveedor(idProveedor2);
                break;
            case 4:
                System.out.println("Mostrar proveedores");
                servicioProveedor.mostrarProveedores();
                break;
            case 5:
                System.out.println("Mostrar proveedores por sustancia");
                System.out.println("Introduzca el nombre de la sustancia: ");
                String nombreSustancia = scannerProveedores.next();
                servicioProveedor.mostrarProveedoresSustancia(nombreSustancia);
                break;
            case 6:
                System.out.println("Volver al menú principal");
                break;
            default:{
                System.out.println("Opción inválida");
                break;
            }
        }
    }

    private static void mostrarMenuPedidos() {
        System.out.println("Menú pedidos");
        System.out.println("1. Realizar pedido");
        System.out.println("2. Buscar pedido");
        System.out.println("3. Actualizar estado de pedido");
        System.out.println("4. Mostrar pedidos por estado");
        System.out.println("5. Mostrar pedidos por proveedor");
        System.out.println("6. Volver al menú principal");
    }

    private static void opcionMenuPedidos(int opc, ServicioPedido servicioPedido, ServicioProveedor servicioProveedor, Scanner scannerPedidos) {
        switch (opc) {
            case 1:
                System.out.println("Realizar pedido");
                System.out.println("Introduzca el id del pedido: ");
                String id = scannerPedidos.next();
                System.out.println("Introduzca el id del proveedor: ");
                String idProveedor = scannerPedidos.next();
                System.out.println("¿Cuántas sustancias desea pedir? ");
                int numSustancias = scannerPedidos.nextInt();
                List<String> sustanciasIDList = new ArrayList<String>();
                List<Double> sustanciasCantidadList = new ArrayList<Double>();
                for (int j = 0; j < numSustancias; j++) {
                    System.out.println("Introduzca el código de la sustancia: ");
                    String codigoSustancia = scannerPedidos.next();
                    sustanciasIDList.add(codigoSustancia);
                    System.out.println("Introduzca la cantidad de la sustancia: ");
                    double cantidadSustancia = scannerPedidos.nextInt();
                    sustanciasCantidadList.add(cantidadSustancia);
                }
                servicioPedido.agregarPedido(idProveedor, servicioProveedor, new Pedido(id, idProveedor, "en proceso", sustanciasIDList, sustanciasCantidadList));
                break;
            case 2:
                System.out.println("Mostrar pedidos");
                System.out.println("Introduzca el id del pedido: ");
                String idPedido = scannerPedidos.next();
                servicioPedido.buscarPedido(idPedido);
                break;
            case 3:
                System.out.println("Actualizar estado de pedido");
                System.out.println("Introduzca el id del pedido: ");
                String idPedido2 = scannerPedidos.next();
                System.out.println("Introduzca el nuevo estado del pedido: ");
                String nuevoEstado = scannerPedidos.next();
                servicioPedido.cambiarEstado(idPedido2, nuevoEstado);
                break;
            case 4:
                System.out.println("Mostrar pedidos por estado");
                servicioPedido.mostrarPedidosOrdenados();
                break;
            case 5:
                System.out.println("Mostrar pedidos por proveedor");
                System.out.println("Introduzca el id del proveedor: ");
                String idProveedor2 = scannerPedidos.next();
                servicioPedido.mostrarPedidosPorProveedor(idProveedor2, servicioProveedor);
                break;
            case 6:
                System.out.println("Volver al menú principal");
                break;
            default:{
                System.out.println("Opción inválida");
                break;
            }
        }
    }
}
