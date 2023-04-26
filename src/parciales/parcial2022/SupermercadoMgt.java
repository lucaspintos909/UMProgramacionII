package parciales

import exceptions.*;
import entities.*;
import uy.edu.um.adt.linkedlist.MyList;

public interface SupermercadoMgt {

    /*
     * Registra un producto en el supermercado identificado por su nombre.
     * Lanza la excepción EntidadYaExiste si el producto ya esta registrado.
     */
    void agregarProducto(String nombre, float precio) throws EntidadYaExiste;

    /*
     * Agrega un pedido de productos de cierto cliente.
       Dentro de estos pedidos se permite que un mismo producto este repetido.
       En caso que el cliente ya disponga de un pedido sin procesar se debe lanzar un error.
     * Lanza la excepción EntidadNoExiste si algún producto no existe.
     * Lanza InformacionInvalida si ya existe un pedido pendiente para el cliente.
     */
    void ingresarPedido(long cedula, MyList<String> productos) throws EntidadNoExiste, InformacionInvalida;

    /*
     * Retorna el próximo pedido pendiente para procesarse dado las reglas indicadas al
       comienzo de la letra. Esta operación debe a su vez archivar el pedido como
       finalizado para analisis posteriores.
     * Lanza la excepción InformaciónInvalida si no existe próximo pedido
    */
    Pedido procesarProximoPedido() throws InformacionInvalida;

    /*
    * Cancela un pedido sin procesar de la cédula indicada.
    * Lanza la excepción EntidadNoExiste si no se encontró pedido pendiente de la cédula
      indicada.
    */
    void cancelarPedido(long cedula) throws EntidadNoExiste;

    /*
      Retorna él cliente que tuvo el ticket con importe total (suma de los precios de sus
      productos) de mayor valor. En caso de no existir retorna null.
    */
    Cliente obtenerClienteConTicketMasCaro();
}
