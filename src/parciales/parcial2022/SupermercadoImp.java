package parciales.parcial2022;


import parciales.Cliente;
import parciales.EntidadYaExiste;
import parciales.EntidadNoExiste;
import parciales.InformacionInvalida;
import parciales.Pedido;
import parciales.Producto;
import parciales.SupermercadoMgt;
import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.adt.linkedlist.MyList;
import uy.edu.um.adt.queue.*;
import uy.edu.um.adt.stack.*;

public class SupermercadoImp implements SupermercadoMgt {

    private final MyList<Cliente> clientesConPedidos = new MyLinkedListImpl<>();
    private final MyList<Producto> productos = new MyLinkedListImpl<>();
    private final MyList<Pedido> finalizados = new MyLinkedListImpl<>();
    private final MyStack<Pedido> pendientesPrioritarios = new MyLinkedListImpl<>();
    private final MyQueue<Pedido> pendientesNormal = new MyLinkedListImpl<>();

    @Override
    public void agregarProducto(String nombre, float precio) throws EntidadYaExiste {
        Producto nuevoProducto = new Producto(nombre, precio);
        if (productos.contains(nuevoProducto)) {
            throw new EntidadYaExiste("El producto que querés agregar ya existe!");
        }
        productos.add(nuevoProducto);
    }

    @Override
    public void ingresarPedido(long cedula, MyList<String> productos) throws EntidadNoExiste, InformacionInvalida {
        Cliente cliente = new Cliente(cedula);
        MyList<Producto> productosPedido = new MyLinkedListImpl<>();

        if (clientesConPedidos.contains(cliente)) {
            throw new InformacionInvalida("El cliente ya tiene pedidos pendientes");
        }

        clientesConPedidos.add(cliente);

        if (productos.size() == 0) {
            throw new EntidadNoExiste("El producto no existe!");
        }

        for (int i = 0; i < productos.size(); i++) {
            Producto productoABuscar = null;
            for (int j = 0; j < this.productos.size(); j++) {
                if (this.productos.get(j).getNombre().equals(productos.get(i))) {
                    productoABuscar = this.productos.get(j);
                    break;
                }
            }
            if (productoABuscar == null) {
                throw new EntidadNoExiste("El producto no existe!");
            }

            productosPedido.add(productoABuscar);
        }


        Pedido nuevoPedido = new Pedido(cedula, productosPedido);
        if (productos.size() < 3) {
            pendientesPrioritarios.push(nuevoPedido);
        } else {
            pendientesNormal.enqueue(nuevoPedido);
        }
    }

    @Override
    public Pedido procesarProximoPedido() throws InformacionInvalida {
        if (pendientesNormal.size() == 0 && pendientesPrioritarios.size() == 0) {
            throw new InformacionInvalida("No hay pedidos para procesar");
        }
        Pedido pedidoProcesado = null;
        try {
            if (pendientesPrioritarios.size() > 0) {
                pedidoProcesado = pendientesPrioritarios.pop();
            } else {
                pedidoProcesado = pendientesNormal.dequeue();
            }
        } catch (EmptyQueueException | EmptyStackException ignore) {
        }

        finalizados.add(pedidoProcesado);

        if (pedidoProcesado != null) {
            clientesConPedidos.remove(new Cliente(pedidoProcesado.getCliente()));
        }

        return pedidoProcesado;
    }

    @Override
    public void cancelarPedido(long cedula) throws EntidadNoExiste {
        Cliente cliente = new Cliente(cedula);

        if (!clientesConPedidos.contains(cliente)) {
            throw new EntidadNoExiste("No hay pedidos con el cliente proporcionado!");
        }

        MyStack<Pedido> intermedia = new MyLinkedListImpl<>();

        try {
            while (pendientesPrioritarios.size() > 0) {
                Pedido pedido = pendientesPrioritarios.pop();
                if (pedido.getCliente() == cedula) {
                    break;
                } else {
                    intermedia.push(pedido);
                }
            }
            while (intermedia.size() > 0) {
                pendientesPrioritarios.push(intermedia.pop());
            }

            /*---------------------------------*/

            while (pendientesNormal.size() > 0) {
                Pedido pedido = pendientesNormal.dequeue();
                if (pedido.getCliente() == cedula) {
                    break;
                } else {
                    intermedia.push(pedido);
                }
            }
            while (intermedia.size() > 0) {
                pendientesNormal.enqueue(intermedia.pop());
            }
        } catch (EmptyQueueException | EmptyStackException ignore) {
        }
    }

    @Override
    public Cliente obtenerClienteConTicketMasCaro() {
        if (finalizados.size() == 0) {
            return null;
        }

        Pedido pedidoConMasValor = null;
        int precioMayor = 0;
        for (int i = 0; i < finalizados.size(); i++) {
            MyList<Producto> productos = finalizados.get(i).getProductos();
            Pedido auxPedido = finalizados.get(i);
            int precio = 0;
            for (int x = 0; x < productos.size(); x++) {
                precio += productos.get(x).getPrecio();
            }

            if (precio >= precioMayor) {
                pedidoConMasValor = auxPedido;
                precioMayor = precio;
            }
        }

        return new Cliente(pedidoConMasValor.getCliente());
    }


    public MyList<Cliente> getClientesConPedidos() {
        return clientesConPedidos;
    }

    public MyList<Producto> getProductos() {
        return productos;
    }

    public MyList<Pedido> getFinalizados() {
        return finalizados;
    }

    public MyStack<Pedido> getPendientesPrioritarios() {
        return pendientesPrioritarios;
    }

    public MyQueue<Pedido> getPendientesNormal() {
        return pendientesNormal;
    }

}
