package TADs.Stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void isEmpty() {
    }

    @Test
    void makeEmpty() {
    }

    @Test
    void getLast() {
    }

    @Test
    void testPop() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        Node<Integer> tail = stack.getTail();
        assertEquals(4, tail.value);
        stack.display();

        stack.pop();
        tail = stack.getTail();
        assertEquals(3, tail.value);
        stack.display();
        stack.pop();
        tail = stack.getTail();
        assertEquals(2, tail.value);
        stack.display();

        stack.pop();
        tail = stack.getTail();
        assertEquals(1, tail.value);
        stack.display();

        stack.pop();
        tail = stack.getTail();
        assertNull(tail);
        stack.display();

    }

    @Test
    void testTop() {
    }

    @Test
    void testPush() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        Node<Integer> tail = stack.getTail();
        assertEquals(4, tail.value);

        tail = tail.prev;
        assertEquals(3, tail.value);

        tail = tail.prev;
        assertEquals(2, tail.value);

        tail = tail.prev;
        assertEquals(1, tail.value);

        tail = tail.prev;
        assertNull(tail);

        stack.display();
    }

    @Test
    void testIsEmpty() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);

        assertFalse(stack.isEmpty());
        stack.pop();
        stack.pop();
        assertTrue(stack.isEmpty());

        stack = new Stack<>();
        assertTrue(stack.isEmpty());
    }

    @Test
    void testMakeEmpty() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);

        stack.makeEmpty();
        assertTrue(stack.isEmpty());
    }
}