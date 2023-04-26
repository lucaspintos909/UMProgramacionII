package parciales.parcial2022;

import parciales.parcial2022.entities.Cliente;
import entities.Pedido;
import entities.Producto;
import exceptions.EntidadNoExiste;
import exceptions.EntidadYaExiste;

import static org.junit.jupiter.api.Assertions.*;

import exceptions.InformacionInvalida;
import org.junit.jupiter.api.Test;
import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.adt.linkedlist.MyList;

class SupermercadoImpTest {

    SupermercadoImp supermercado = new SupermercadoImp();

    @Test
    void agregarProducto() {
        try {
            supermercado.agregarProducto("Carne", 1000);
            supermercado.agregarProducto("Yerba", 200);

            assertEquals("Carne", supermercado.getProductos().get(0).getNombre());
            assertEquals("Yerba", supermercado.getProductos().get(1).getNombre());
        } catch (EntidadYaExiste ignored) {

        }
    }

    @Test
    void agregarProducto_entidadYaExiste_exception() {
        try {
            supermercado.agregarProducto("Carne", 1000);
            supermercado.agregarProducto("Carne", 200);
            fail();
        } catch (EntidadYaExiste e) {
            assertTrue(true);
        }
    }

    @Test
    void ingresarPedido() {
        agregarProductosBasicos(supermercado);

        MyList<String> productos = new MyLinkedListImpl<>();
        productos.add("Carne");
        productos.add("Yerba");


        try {
            supermercado.ingresarPedido(56250717, productos);
            assertEquals(1, supermercado.getPendientesPrioritarios().size());

            productos.add("Jabon");
            supermercado.ingresarPedido(56250714, productos);
            assertEquals(1, supermercado.getPendientesNormal().size());

        } catch (EntidadNoExiste | InformacionInvalida e) {
            fail();
        }
    }

    @Test
    void ingresarPedido_clienteRepetido_exception() {
        agregarProductosBasicos(supermercado);

        MyList<String> productos = new MyLinkedListImpl<>();
        productos.add("Carne");
        productos.add("Yerba");

        try {
            supermercado.ingresarPedido(56250714, productos);
            productos.add("Jabon");
            supermercado.ingresarPedido(56250714, productos);
            fail();
        } catch (EntidadNoExiste e) {
            fail();
        } catch (InformacionInvalida e) {
            assertTrue(true);
        }
    }


    @Test
    void ingresarPedido_productoNoExiste_exception() {
        MyList<String> productos = new MyLinkedListImpl<>();
        productos.add("Carne");

        try {
            supermercado.ingresarPedido(52650817, productos);
            fail();
        } catch (EntidadNoExiste e) {
            assertTrue(true);
        } catch (InformacionInvalida e) {
            fail();
        }
    }

    @Test
    void procesarProximoPedido() {
        agregarProductosBasicos(supermercado);

        MyList<String> productos = new MyLinkedListImpl<>();
        productos.add("Carne");
        productos.add("Yerba");

        try {
            supermercado.ingresarPedido(56250717, productos);
            productos.add("Jabon");
            supermercado.ingresarPedido(56250714, productos);
        } catch (EntidadNoExiste | InformacionInvalida e) {
            fail();
        }

        try {
            Pedido pedidoProcesado = supermercado.procesarProximoPedido();
            assertEquals(0, supermercado.getPendientesPrioritarios().size());
            assertEquals(56250717, pedidoProcesado.getCliente());
            assertEquals(pedidoProcesado, supermercado.getFinalizados().get(0));
            assertEquals(1, supermercado.getClientesConPedidos().size());

            pedidoProcesado = supermercado.procesarProximoPedido();
            assertEquals(0, supermercado.getPendientesNormal().size());
            assertEquals(56250714, pedidoProcesado.getCliente());
            assertEquals(pedidoProcesado, supermercado.getFinalizados().get(1));
            assertEquals(0, supermercado.getClientesConPedidos().size());

        } catch (InformacionInvalida e) {
            fail();
        }
    }

    @Test
    void procesarProximoPedido_sinPedidosIngresados_exception() {
        try {
            supermercado.procesarProximoPedido();
            fail();
        } catch (InformacionInvalida e) {
            assertTrue(true);
        }
    }

    @Test
    void cancelarPedido() {
        agregarProductosBasicos(supermercado);

        MyList<String> productos = new MyLinkedListImpl<>();
        productos.add("Carne");
        productos.add("Yerba");

        try {
            /*------------- Ingresando pedidos ------------------ */
            supermercado.ingresarPedido(56250717, productos);
            productos.add("Jabon");
            supermercado.ingresarPedido(56250714, productos);
            productos.add("Yerba");
            productos.add("Yerba");
            supermercado.ingresarPedido(56250711, productos);
            /*----------------------------------------------------*/

            supermercado.cancelarPedido(56250717);
            assertEquals(0, supermercado.getPendientesPrioritarios().size());

            supermercado.cancelarPedido(56250711);
            assertEquals(1, supermercado.getPendientesNormal().size());
        } catch (EntidadNoExiste | InformacionInvalida e) {
            fail();
        }
    }

    @Test
    void cancelarPedido_clienteSinPedidos_exception() {
        agregarProductosBasicos(supermercado);

        MyList<String> productos = new MyLinkedListImpl<>();
        productos.add("Carne");
        productos.add("Yerba");

        try {
            /*------------- Ingresando pedidos ------------------ */
            supermercado.ingresarPedido(56250717, productos);
            productos.add("Jabon");
            supermercado.ingresarPedido(56250714, productos);
            /*----------------------------------------------------*/

            supermercado.cancelarPedido(56250711);
            fail();
        } catch (EntidadNoExiste e) {
            assertTrue(true);
        } catch (InformacionInvalida e) {
            fail();
        }
    }

    @Test
    void obtenerClienteConTicketMasCaro() {
        agregarProductosBasicos(supermercado);

        MyList<String> productos = new MyLinkedListImpl<>();
        productos.add("Carne");
        productos.add("Yerba");

        try {
            /*------------- Ingresando pedidos ------------------ */
            supermercado.ingresarPedido(56250717, productos);
            productos.add("Jabon");
            supermercado.ingresarPedido(56250714, productos);
            productos.add("Yerba");
            productos.add("Queso");
            supermercado.ingresarPedido(56250711, productos);
            productos.add("Fideos");
            productos.add("Queso");
            supermercado.ingresarPedido(56250719, productos);
            /*----------------------------------------------------*/
            supermercado.procesarProximoPedido();
            supermercado.procesarProximoPedido();
            supermercado.procesarProximoPedido();
            supermercado.procesarProximoPedido();

            Cliente cliente = supermercado.obtenerClienteConTicketMasCaro();

            assertEquals(56250719, cliente.getCedula());

        } catch (EntidadNoExiste | InformacionInvalida e) {
            fail();
        }
    }

    @Test
    void obtenerClienteConTicketMasCaro_sinPedidosFinalizados_exception() {
        agregarProductosBasicos(supermercado);

        MyList<String> productos = new MyLinkedListImpl<>();
        productos.add("Carne");
        productos.add("Yerba");

        try {
            /*------------- Ingresando pedidos ------------------ */
            supermercado.ingresarPedido(56250717, productos);
            productos.add("Jabon");
            supermercado.ingresarPedido(56250714, productos);
            productos.add("Yerba");
            productos.add("Queso");
            supermercado.ingresarPedido(56250711, productos);
            productos.add("Fideos");
            productos.add("Queso");
            supermercado.ingresarPedido(56250719, productos);
            /*----------------------------------------------------*/
            Cliente cliente = supermercado.obtenerClienteConTicketMasCaro();

            assertNull(cliente);

        } catch (EntidadNoExiste | InformacionInvalida e) {
            fail();
        }
    }

    void agregarProductosBasicos(SupermercadoMgt supermercado){
        try {
            supermercado.agregarProducto("Carne", 1000);
            supermercado.agregarProducto("Yerba", 200);
            supermercado.agregarProducto("Jabon", 100);
            supermercado.agregarProducto("Fideos", 150);
            supermercado.agregarProducto("Queso", 60);
        } catch (EntidadYaExiste e) {
            fail();
        }
    }
}