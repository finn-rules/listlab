package edu.grinnell.csc207.listlab;

/**
 * A linked implementation of the list ADT.
 */
public class LinkedList {
   
        public int value;
        public Node next;

        /**
         * Node: the constructor for a node in a linked list.
         * @param val and integer to be stored in a node
         */
        Node(int val) {
            this.value = val;
            this.next = null;
        }
    }

    private Node first;
    /**
     * The constructor for a linked list.
     */
    LinkedList() {
        this.first = null;
    }

    /**
     * Adds <code>value</code> to the end of the list
     *
     * @param value the value to add to the end of the list
     */
    public void add(int value) {
        // check if first is null .. if there are nodes we're good
        if (first == null) {
            first = new Node(value);
        } else {
            Node cur = first;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(value);
        }
    }

    /**
     * @return the number of elements in the list
     */
    public int size() {
        if (first == null) {
            return 0;
        } else {
            Node cur = first;
            int counts = 1;
            while (cur.next != null) {
                cur = cur.next;
                counts++;
            }
            return counts;
        }
    }

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    public int get(int index) throws IndexOutOfBoundsException {
        int size = this.size();
        if (size <= 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        Node cur = first;
        for (int iter = 0; iter < index; iter++) {
            cur = cur.next;
        }
        return cur.value;
    }

    /**
     * Removes the value at <code>index</code> from the list
     *
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public int remove(int index) {
        int size = this.size();
        if (size <= 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        Node cur = first;
        if (index == 0) {
            Node temp = cur.next;
            int val = first.value;
            first = temp;
            return val;
        }
        for (int iter = 0; iter < index - 1; iter++) {
            cur = cur.next;
        }
        int val = cur.next.value;
        cur.next = cur.next.next;
        return val;
    }
}
