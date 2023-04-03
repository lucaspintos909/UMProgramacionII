package TADs.LinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import TADs.exceptions.IndexOutOfRange;

class CircularLinkedListTest {

    @Test
    void size() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.size());
    }

    @Test
    void zeroSize() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        assertEquals(0, list.size());
    }

    @Test
    void valueExists() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
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
    void addFirst() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        Node<Integer> tail;
        list.add(3);
        list.add(4);
        list.add(5);

        /*
         * Pruebo que el valor se ingrese correctamente al principio
         * y que tail apunte correctamente al nodo nuevo.
         */

        list.addFirst(2);
        tail = list.getTail();
        assertEquals(2, list.get(0));
        assertEquals(2, tail.next.value);

        list.addFirst(1);
        tail = list.getTail();
        assertEquals(1, list.get(0));
        assertEquals(1, tail.next.value);
    }

    @Test
    void addLast() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        Node<Integer> tail;
        list.add(1);
        list.add(2);
        list.add(3);

        /*
         * Pruebo que el valor se ingrese correctamente al final
         * y que tail apunte correctamente a head.
         */

        list.addLast(4);
        tail = list.getTail();
        assertEquals(4, list.get(3));
        assertEquals(1, tail.next.value);

        list.addLast(5);
        tail = list.getTail();
        assertEquals(5, list.get(4));
        assertEquals(1, tail.next.value);
    }

    @Test
    void addValue() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    void remove() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        try {
            list.remove(0);
            assertEquals(4, list.size());
            assertEquals(2, list.get(0));


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
    void removeWithWrongPosition() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.add(1);
        list.add(5);
        list.add(3);

        try {
            list.remove(3);
        } catch (IndexOutOfRange e) {
            assertEquals("IndexError: index out of range: 3", e.getMessage());
        }
    }

    @Test
    void getValue() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));

        assertNull(list.get(3));
        assertNull(list.get(4));
    }
}