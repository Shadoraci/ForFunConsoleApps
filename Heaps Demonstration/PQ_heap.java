// Generic code for class priority_queue_heap for Assignment 7 

// Name: Tyler Ercole
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: Assignment 6 | Exercise 1
// IDE Name: Intellij Community 2023

public class PQ_heap<E extends Comparable<E>>
{
    private Heap<E> HeapObj;
    // Constructor method
    PQ_heap()
    {
        HeapObj = new Heap<E>();
    }
    PQ_heap(E[] list)
    {
        HeapObj = new Heap<>();
        for (E data : list)
        {
            HeapObj.add(data);
        }
    }
    // Return true if priority queue is empty; otherwise return false
    public boolean is_empty()
    {
        return HeapObj.getSize() <= 0;
    }
    // Return true if priority queue is full; otherwise return false
    public boolean is_full()
    {
        return HeapObj.getSize() == HeapObj.capacity;
    }
    // Return (don't remove) the front element from the priority queue
    // Precondition: priority queue is not empty.
    public E front()
    {
        return HeapObj.getFirst();
    }
    // return number of elements in the queue
    public int size()
    {
        return HeapObj.getSize();
    }
    // Remove the largest value from this priority queue and return it.
    // Precondition: priority queue is not empty.
    public E dequeue()
    {
       return HeapObj.remove();
    }
    // Inserts the 'value' into the priority queue.
    // Precondition: priority queue is not full
    public void enqueue(E value)
    {
        HeapObj.add(value);
    }
    public void print()
    {
        System.out.println(HeapObj);
    }
    public void printList()
    {
        HeapObj.printList();
    }
}

