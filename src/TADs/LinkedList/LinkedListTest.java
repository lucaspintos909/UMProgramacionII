package TADs.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

import TADs.exceptions.IndexOutOfRange;
import org.junit.jupiter.api.Test;

class LinkedListTest {

    @Test
    void add() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);

        Node<Integer> aux = list.getHead();
        assertEquals(1, aux.getValue());

        aux = aux.getNext();
        assertEquals(2, aux.getValue());
    }

    @Test
    void remove() {
        LinkedList<Integer> list = new LinkedList<>();
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
    void get() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void addFirst() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(4);
        list.add(5);


        list.addFirst(2);
        assertEquals(2, list.get(0));

        list.addFirst(1);
        assertEquals(1, list.get(0));
    }

    @Test
    void addLast() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.addLast(4);
        assertEquals(4, list.get(3));

        list.addLast(5);
        assertEquals(5, list.get(4));
    }

    @Test
    void exists() {
        LinkedList<Integer> list = new LinkedList<>();
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
    void size() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        assertEquals(1, list.size());

        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
    }

    @Test
    void zeroSize() {
        LinkedList<Integer> list = new LinkedList<>();
        assertEquals(0, list.size());
    }
}