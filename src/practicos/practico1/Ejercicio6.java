package practicos.practico1;

import TADs.LinkedList.CircularLinkedList;
import TADs.LinkedList.Node;

/*Con la implementación de los TAD, implementar un juego que solucione el
“problema de Josefo”: existen N personas numeradas de 1 a N, las mismas
se encuentra dispuestas en un circulo. Empezando con la persona 1 se
comienza a saltar de a M lugares, siendo la M-esima persona la invitada a
abandonar el circulo. Luego que dicha persona abandona su lugar, el circulo
se cierra y el juego continua con la persona que estaba dispuesta después
del que abandonó . La ultima persona es la ganadora de este juego.
Además de saber quien es la persona que no abandonará el circulo se desea
saber el orden en el que el resto de las personas fueron abandonando el
circulo.*/

public class Ejercicio6 {

    public static void main(String[] args) {
        CircularLinkedList<String> lista = new CircularLinkedList<>();
        lista.add("1");
        lista.add("2");
        lista.add("3");
        lista.add("4");
        lista.add("5");
        lista.add("6");
        lista.add("7");
        lista.add("8");

        juego(4, lista);
    }

    /**
     * @param m              indica la cantidad de lugares antes de sacar una persona, este
     *                       valor puede ser negativo y indica la dirección con la cual se recorre la
     *                       ronda.
     * @param colIntegrantes los integrantes participantes del juego, es una
     *                       lista de enteros.
     * @return lista de jugadores que fueron eliminados en el orden de
     * eliminación.
     * @throws IllegalArgumentException cuando la cantidad m es mayor que
     *                                  el total de integrantes.
     */
    public static CircularLinkedList<String> juego(int m, CircularLinkedList<String> colIntegrantes) {
        CircularLinkedList<String> lista = new CircularLinkedList<>();
        int contador = 1;

        if (colIntegrantes.size() < m) {
            throw new IllegalArgumentException("");
        }
        System.out.println("M = " + m);
        while (colIntegrantes.size() != 1) {
            // Obtengo el head cada vez que arranco a iterar devuelta sobre la lista
            Node<String> head = colIntegrantes.getHead();
            for (Integer index = 0; index < colIntegrantes.size(); index++) {
                if (contador == m) {
                    // Agrego el integrante a borrar en la lista de eliminados
                    lista.add(colIntegrantes.get(index));
                    try {
                        // Elimino el integrante
                        colIntegrantes.remove(index);
                        /*
                         * Le resto 1 al index, ya que al eliminar el integrante,
                         * el siguiente integrante pasa a tener el indice del eliminado
                        */
                        index--;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    // Reseteo el contador
                    contador = 1;
                } else {
                    head = head.getNext();
                    contador++;
                }
            }
        }

        System.out.print("\nJugador ganador: ");
        colIntegrantes.display();
        System.out.print("Eliminados: ");
        lista.display();

        return lista;
    }

}
