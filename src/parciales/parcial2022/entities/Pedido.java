package parciales;

import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.adt.linkedlist.MyList;

public class Pedido {
    private long cliente;

    public MyList<Producto> getProductos() {
        return productos;
    }

    private MyList<Producto> productos = new MyLinkedListImpl<>();

    public Pedido(long cliente, MyList<Producto> productos){
        this.cliente = cliente;
        this.productos = productos;
    }

    public long getCliente() {
        return cliente;
    }

    public void setCliente(long cliente) {
        this.cliente = cliente;
    }
}
