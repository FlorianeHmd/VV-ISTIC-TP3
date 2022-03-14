package fr.istic.vv;

import java.util.*;

class BinaryHeap<T> {

    ArrayList<T> array ;
    Comparator<T> comparator ;

    public BinaryHeap(Comparator<T> comparator, ArrayList<T> array) {
        this.array = array;
        this.comparator = comparator ;
        this.array.sort(this.comparator);
    }

    public void sort()
    {
        int n = this.array.size();

        for (int i = n; i >= 0; i--)
            heapify( n, i);
        // One by one extract an element from heap
        for (int i = n - 1; i >= 1; i--) {
            // Move current root to end
            T temp = this.array.get(0);
            this.array.set(0, this.array.get(i));
            this.array.set(i, temp);

            // call max heapify on the reduced heap
            heapify( i, 0);
        }

    }

    void heapify(int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root

        if (l < n ){
            if(this.comparator.compare(this.array.get(l), this.array.get(largest)) == 1){
                largest = l;
            }
        }
        // If right child is larger than largest so far
        if (r < n) {
            if(this.comparator.compare(this.array.get(r), this.array.get(largest)) == 1){
                largest = r;
            }
        }

        // If largest is not root
        if (largest != i) {
            T swap = this.array.get(i);
            this.array.set(i, this.array.get(largest));
            this.array.set(largest, swap);
        }
    }

    public T pop() throws NoSuchElementException{
        if(this.array.isEmpty()) throw new NoSuchElementException("The heap is empty") ;
        T result = this.array.get(0) ;
        this.array.remove(result);
        return result; }

    public T peek() throws NoSuchElementException {
        if(this.array.isEmpty()) throw new NoSuchElementException("The heap is empty") ;
        return this.array.get(0) ;
    }

    public void push(T element) {
        this.array.add(element) ;
        sort();
    }

    public int count() { return this.array.size(); }

}