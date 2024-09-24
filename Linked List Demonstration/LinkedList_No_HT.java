// Name: Tyler Ercole
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: Assignment 3 | Exercise 1
// IDE Name: Intellij Community 2023

/*
  This class define a linked list that stores integer values.
  The class does NOT use Head and Tail pointer as the textbook class deos.
*/

import org.w3c.dom.NodeList;

import java.util.List;

public class LinkedList_No_HT
{
   public Node ListName;  //Listname is Head

   //constructor method to create a list object with a specifc name. 
   public LinkedList_No_HT()
   {
      ListName = null;
   }
  
   //method add node to end of list
   public void addLastNode(int data) 
   {
      if (ListName == null) 
         ListName = new Node(data); //one node list
      else 
      {
         Node temp = ListName;
         while (temp.next != null) 
         {
            temp = temp.next;
         }
         
         temp.next = new Node(data); //link new node as last node
      }
   }
  
   //======== Your part to complete for this assignment =========
   
   //method #1: add first node
   public void addFirstNode(int data)
   {
         //complete this method                          --Maybe?--
      Node newNode = new Node(data);
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
     
      
   //method #2: add node at index
   public void addAtIndex(int index, int data)
   {
      //complete this method
      if(index == 0)
      {
         addFirstNode(data);

      }
      else if(index >= countNodes())
      {
         addLastNode(data);
      }
      else
      {
         Node current = ListName;
         Node Temp = ListName.next;
         //loop for adding at index
         for (int i = 1; i < index; i++)
         {
               current = current.next;
               Temp = Temp.next;
         }
         current.next = new Node(data);
         (current.next).next = Temp;
      }
   }


   //method #3: remove first node
   public void removeFirstNode()
   {
      //complete this method
      if (countNodes() == 0)
      {
         ListName = null;
         //make list empty
      }
      else
      {
         Node Temp = ListName;
         ListName = ListName.next;
      }
   }
      
      
   //method #4: remove last node
   public void removeLastNode()
   {
      //complete this method
      if (countNodes() == 0)
      {
         ListName = null;
         //make list empty
      }
      else if(countNodes() == 1)
      {
         //Node Temp = ListName;
         ListName = null;
      }
      else
      {
         Node Current = ListName;
         //removing node
         for (int i = 0; i < (countNodes() - 2); i++)
         {
            Current = Current.next;
            System.out.println(Current.data + " " + Current.next.data);
         }
         Current.next = null;
      }
   }
    
    
   //method #5: remove node at index
   public void removeAtIndex(int index)
   {
         //complete this method
      if (index < 0 || index >= countNodes())
      {
         return;
      }
      else if(index == 0)
      {
         removeFirstNode();
      }
      else if(index == countNodes() - 1)
      {
         removeLastNode();
      }
      else
      {
         Node Previous = ListName;
         for (int i = 1; i < index; i++)
         {
            Previous = Previous.next;
         }
         Node Current = Previous.next;

         Previous.next = Current.next;
      }
   }
          
   //method #6: countNodes
   public int countNodes()
   {
      int listSize = 0;
      Node Current = ListName;
      Node Temp;
      //complete this method to return the list size.
      //counts nodes in list while loop is active (current isn't null).
      while(Current != null)
      {
         Current = Current.next;
         listSize++;
      }

      return listSize; 
   }
   //method #7: printInReverse (must be a Recursive method)
   public void printInReverseRecursive(Node L)
   {
      //complete this method as recursive method to print the list in revers order.
      //ending conditions check for null or not null
      //Node.next to go to the next node. All print statements will 'fall back onto eachother'
      //giving a reverse print operation.
      if(L == null)
      {
         System.out.println("Fully printed!");
         return;
      }
      if(L != null)
      {
         printInReverseRecursive(L.next);
         System.out.print(L.data);
      }
      else
      {
         return;
      }

   }   

   //================= end of your part ==============

   //method to print out the list
   public void printList() 
   {
      Node temp;
      temp = ListName;
      while (temp != null)
      {
         System.out.print(temp.data + "   ");
         temp = temp.next;
      }
   }
  
   //class to create nodes as objects
   private class Node
   {
      private int data;  //data field
      private Node next; //link field
       
      public Node(int item) //constructor method
      {
         data = item;
         next = null;
      }
   }
}

