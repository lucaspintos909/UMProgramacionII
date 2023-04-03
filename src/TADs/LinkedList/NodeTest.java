package TADs.LinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void getValue() {
        Node<Integer> node = new Node<>(2);
        Node<Integer> nodeNext = new Node<>(3);
        Node<Integer> nodePrev = new Node<>(1);
        node.next = nodeNext;
        node.prev = nodePrev;

        assertEquals(2, node.getValue());
        assertEquals(1, node.prev.getValue());
        assertEquals(3, node.next.getValue());

    }

    @Test
    void getNext() {
        Node<Integer> node = new Node<>(2);
        Node<Integer> nextNode = new Node<>(3);
        node.next = nextNode;

        assertEquals(nextNode, node.getNext());
    }

    @Test
    void getPrev() {
        Node<Integer> node = new Node<>(2);
        Node<Integer> prevNode = new Node<>(1);
        node.prev = prevNode;

        assertEquals(prevNode, node.getPrev());
    }
}