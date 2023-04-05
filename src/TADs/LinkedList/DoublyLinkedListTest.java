package TADs.LinkedList;

import TADs.exceptions.IndexOutOfRange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    @Test
    void size() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        assertEquals(1, list.size());

        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
    }

    @Test
    void zeroSize() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertEquals(0, list.size());
    }

    @Test
    void add() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        Node<Integer> aux = list.getHead();
        assertEquals(1, aux.getValue());
        assertNull(aux.getPrev());
        assertNull(aux.getNext());

        list.add(2);
        list.add(3);

        Node<Integer> prev = aux;
        aux = aux.getNext();
        assertEquals(2, aux.getValue());
        assertEquals(prev, aux.getPrev());

        prev = aux;
        aux = aux.getNext();
        assertEquals(3, aux.getValue());
        assertEquals(prev, aux.getPrev());
        assertNull(aux.getNext());
    }

    @Test
    void remove() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        try {
            list.remove(0);
            assertEquals(4, list.size());
            assertEquals(2, list.get(0));
            assertNull(list.getHead().getPrev());

            list.remove(3);
            assertEquals(3, list.size());
            assertEquals(4, list.get(2));

            list.remove(1);
            assertEquals(2, list.size());
            assertEquals(4, list.get(1));
        } catch (IndexOutOfRange e) {
            System.out.println("Exception occured: " + e);
        }
    }

    @Test
    void get() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void addFirst() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        Node<Integer> aux;
        list.add(3);
        list.add(4);
        list.add(5);

        list.addFirst(2);
        aux = list.getHead();
        assertEquals(2, list.get(0));
        assertNull(aux.getPrev());
        /*
         * Chequeo tambien que se enlace bien el prev al agregar al principio
         */
        aux = aux.getNext();
        assertNotNull(aux.getNext());
        assertEquals(2, aux.getPrev().getValue());


        list.addFirst(1);
        aux = list.getHead();
        assertEquals(1, list.get(0));
        /*
         * Chequeo tambien que se enlace bien el prev al agregar al principio
         */
        aux = aux.getNext();
        assertNotNull(aux.getNext());
        assertEquals(1, aux.getPrev().getValue());
    }

    @Test
    void addLast() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        Node<Integer> aux = list.getHead();
        assertEquals(1, aux.getValue());
        assertNull(aux.getPrev());
        assertNull(aux.getNext());

        list.add(2);
        list.add(3);

        Node<Integer> prev = aux;
        aux = aux.getNext();
        assertEquals(2, aux.getValue());
        assertEquals(prev, aux.getPrev());

        prev = aux;
        aux = aux.getNext();
        assertEquals(3, aux.getValue());
        assertEquals(prev, aux.getPrev());
        assertNull(aux.getNext());
    }

    @Test
    void exists() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        /* Test para valores que existen*/
        assertTrue(list.exists(1));
        assertTrue(list.exists(2));
        assertTrue(list.exists(3));

        /* Test para valores que no existen*/
        assertFalse(list.exists(0));
        assertFalse(list.exists(4));
    }

    @Test
    void getHead() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertNull(list.getHead());

        list.add(1);
        assertNotNull(list.getHead());
        assertInstanceOf(Node.class, list.getHead());
    }
}