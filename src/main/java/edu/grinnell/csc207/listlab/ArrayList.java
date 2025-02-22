package edu.grinnell.csc207.listlab;

/**
 * An array-based implementation of the list ADT.
 */
public class ArrayList {
    
    private int[] arr;
    private int currentIndex;
    private int capacity;
    /**
     * arrayList : constructor for an ArrayList
     */
    public ArrayList() {
        this.currentIndex = 0;
        this.capacity = 5;
        this.arr = new int[capacity];
    }

    /**
     * Adds <code>value</code> to the end of the list
     *
     * @param value the value to add to the end of the list
     */
    public void add(int value) {
        if (currentIndex >= capacity) {
            int[] temp = new int[capacity + 5];
            System.arraycopy(arr, 0, temp, 0, capacity);
            capacity += 5;
            this.arr = temp;
        }
        arr[currentIndex] = value;
        currentIndex++;
    }
    
    /**
     * getarr, method which creates and returns a copy of the ArrayList. 
     * @return int[] the array of integers stored.
     */
    public int[] getarr() {
        int[] ret = new int[this.currentIndex];
        for (int iter = 0; iter < currentIndex; iter++) {
            ret[iter] = this.arr[iter];
        }
        return ret;
    }

    /**
     * @return the number of elements in the list
     */
    public int size() {
        return this.currentIndex;
    }

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    public int get(int index) throws IndexOutOfBoundsException {
        if (index > currentIndex || 0 > index) {
            throw new IndexOutOfBoundsException("Invalid Index");
        }
        return arr[index];
    }

    /**
     * Removes the value at <code>index</code> from the list
     *
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public int remove(int index) throws IndexOutOfBoundsException {
        if (index > currentIndex || 0 > index) {
            throw new IndexOutOfBoundsException("Invalid Index");
        }
        int removeValue = arr[index];
        //int[] temp = new int[capacity];
        System.arraycopy(arr, index + 1, arr, index, (this.capacity - index - 1));
        currentIndex--;
        return removeValue;
    }
}
