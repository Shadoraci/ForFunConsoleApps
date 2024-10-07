// Name: Tyler Ercole
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: Assignment 4 | Exercise 1
// IDE Name: Intellij Community 2023

public class MyStack<E>
{
    public Node<E> ListName;  //Listname is Head

    public MyStack()
    {
        ListName = null;
    }

    //Add first
    public void Push(E data)
    {
        Node<E> newNode = new Node<>(data);
        //checking if null
        if(ListName == null)
        {
            ListName = newNode;
        }
        else
        {
            newNode.next = ListName;
            ListName = newNode;
        }
    }

    //remove first node
    public E Pop()
    {
        if (Size() == 0)
        {
            ListName = null;
            return null;
        }
        E Temp = ListName.data;
        ListName = ListName.next;
        return Temp;
    }
    //countNodes
    public int Size()
    {
        int listSize = 0;
        Node<E> Current = ListName;
        Node<E> Temp;
        while(Current != null)
        {
            Current = Current.next;
            listSize++;
        }

        return listSize;
    }
    public E Top()
    {

        return ListName.data;
    }
    public boolean isEmpty()
    {
        return this.Size() <= 0;
    }

    public void printList()
    {
        Node<E> temp;
        temp = ListName;
        while (temp != null)
        {
            System.out.print(temp.data + "   ");
            temp = temp.next;
        }
    }
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

