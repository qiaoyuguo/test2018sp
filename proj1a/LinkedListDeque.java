public class LinkedListDeque<T> {
    private int size;
    private Node sentinel;

    private class Node {
        private T item;
        private Node prev;
        private Node next;
    }

    public LinkedListDeque() {
        sentinel = new Node();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /**
     * Same as get, but recursive
     */
    public T getRecursive(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        if (index == 0) {
            return sentinel.next.item;
        }
        return getRecursive(index - 1);
    }

    /**
     * add an item of type T to the front of the queue
     */
    public void addFirst(T item) {
        Node node = new Node();
        node.item = item;
        sentinel.next.prev = node;
        node.prev = sentinel;
        node.next = sentinel.next;
        sentinel.next = node;
        ++size;
    }

    /**
     * add an item of type T to the deque
     */
    public void addLast(T item) {
        Node node = new Node();
        node.item = item;
        sentinel.prev.next = node;
        node.prev = sentinel.prev;
        node.next = sentinel;
        sentinel.prev = node;
        ++size;
    }

    /**
     * Return true if deque is empty, otherwise returns false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of items in the deque.
     */
    public int size() {
        return size;
    }

    /**
     * Print items from the deque from the first to last, seperated by space
     * one new line will be printed out after all items are printed.
     */
    public void printDeque() {
        Node node = sentinel.next;
        boolean first = true;
        while (node != sentinel) {
            if (!first) {
                System.out.print(" ");
            } else {
                first = false;
            }
            System.out.print(node.item);
            node = node.next;
        }
        System.out.println();
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exist, returns null.
     */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node node = sentinel.next;
        node.next.prev = sentinel;
        sentinel.next = node.next;
        --size;
        return node.item;
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exist, return null.
     */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node node = sentinel.prev;
        node.prev.next = sentinel;
        sentinel.prev = node.prev;
        --size;
        return node.item;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth. If no such item exists, return null.
     */
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        Node node = sentinel;
        for (int i = 0; i <= index; i++) {
            node = node.next;
        }
        return node.item;
    }
}
