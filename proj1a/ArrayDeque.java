public class ArrayDeque<T> {
    private int first;
    private int last;
    private T[] items;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        first = 0;
        last = 0;
    }

    private void resize(int capacity) {
        assert first == last;
        T[] newItems = (T[]) new Object[capacity];
        System.arraycopy(items, first, newItems, 0, items.length - first);
        System.arraycopy(items, 0, newItems, items.length - first, last);
        first = 0;
        last = items.length;
        items = newItems;
    }

    /**
     * add an item of type T to the front of the queue
     */
    public void addFirst(T item) {
        first = (first - 1 + items.length) % items.length;
        items[first] = item;
        if (first == last) {
            resize(2 * items.length);
        }
    }

    /**
     * add an item of type T to the deque
     */
    public void addLast(T item) {
        items[last] = item;
        last = (last + 1) % items.length;
        if (first == last) {
            resize(2 * items.length);
        }
    }

    /**
     * Return true if deque is empty, otherwise returns false
     */
    public boolean isEmpty() {
        return first == last;
    }

    /**
     * Returns the number of items in the deque.
     */
    public int size() {
        return (last - first + items.length) % items.length;
    }

    /**
     * Print items from the deque from the first to last, seperated by space
     * one new line will be printed out after all items are printed.
     */
    public void printDeque() {
        boolean isFirst = true;
        for (int i = first; i != last; i = (i + 1) % items.length) {
            if (isFirst) {
                isFirst = false;
            } else {
                System.out.print(" ");
            }
            System.out.print(items[i]);
        }
        System.out.println();
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exist, returns null.
     */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T item = items[first];
        items[first] = null;
        first = (first + 1) % items.length;
        return item;
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exist, return null.
     */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        last = (last - 1 + items.length) % items.length;
        T item = items[last];
        items[last] = null;
        return item;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth. If no such item exists, return null.
     */
    public T get(int index) {
        return items[(index + first) % items.length];
    }
}
