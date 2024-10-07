// Name: Tyler Ercole
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: Assignment 5 | Exercise 1
// IDE Name: Intellij Community 2023

public class Queue<E>
{
    public Node<E> Head;  //Listname is Head
    //public Node<E> Tail;
    public Queue()
    {
        Head = null;
    }

    //addlast
    //Adds element to end of queue
    public void Enqueue(E data)
    {
        if (Head == null)
            Head = new Node<>(data); //one node list
        else
        {
            Node<E> temp = Head;
            while (temp.next != null)
            {
                temp = temp.next;
            }

            temp.next = new Node<>(data); //link new node as last node
        }
    }

    //remove first node
    //Removes the first queue
    public E Dequeue()
    {
        //complete this method
        if (Size() == 0)
        {
            return null;
            //make list empty
        }
        else
        {
            Node<E> Temp = Head;
            Head = Head.next;
            return Temp.data;
        }
    }

    //Counts the size of the nodes and returns Size
    public int Size()
    {
        if(Head == null)
        {
            return 0;
        }
        int listSize = 0;
        Node<E> Current = Head;
        //complete this method to return the list size.
        //counts nodes in list while loop is active (current isn't null).
        while(Current != null)
        {
            Current = Current.next;
            listSize++;
        }

        return listSize;
    }
    //Returns the head data
    public E Front()
    {
        return Head.data;
    }
    //Bool to check if it's empty
    public boolean isEmpty()
    {
        return this.Size() <= 0;
    }

    //method to print out the list
    public void printList()
    {
        Node<E> temp;
        temp = Head;
        while (temp != null)
        {
            System.out.print(temp.data + "   ");
            temp = temp.next;
        }
    }

    //class to create nodes as objects
    private class Node<E>
    {
        private E data;  //data field
        private Node<E> next; //link field

        public Node(E item) //constructor method
        {
            data = item;
            next = null;
        }
    }
}
