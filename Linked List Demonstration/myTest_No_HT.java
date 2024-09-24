// Name: Tyler Ercole
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: Assignment 3 | Exercise 1
// IDE Name: Intellij Community 2023

// Add your header here

import java.util.Scanner;

public class myTest_No_HT
{
   public static void main (String[] args)
   {
      LinkedList_No_HT myList = new LinkedList_No_HT(); //create a list object
      /*
      for (int i=1; i <= 5; i++) //add 5 nodes to the list
      {
         myList.addLastNode(i*10);
      } 
      
      //print out the list content
      System.out.print("\nMy test list values are:  ");
      myList.printList();
      System.out.println();
      */
      //------------------------------------------------------
      Scanner scan = new Scanner(System.in);
      boolean Quit = false;

      //My awesome menu
      while(!Quit)
      {
         System.out.println("\n\n\n\n---------MAIN MENU--------");
         System.out.println("1 – Add First Node");
         System.out.println("2 – Add Last Node");
         System.out.println("3 – Add At Index");
         System.out.println("4 – Remove First Node");
         System.out.println("5 – Remove Last Node");
         System.out.println("6 – Remove At Index");
         System.out.println("7 – Print List Size");
         System.out.println("8 – Print List Forward");
         System.out.println("9 – Print List In Reverse");
         System.out.println("10- Exit program");
         System.out.println();
         System.out.println("Enter option number: ");
         int Selection = scan.nextInt();
         scan.nextLine();

         //All my cases according to the menu respectively.
         switch(Selection)
         {
            case 1:

               System.out.println("Please enter a value to be entered: ");
               int DataEntry = scan.nextInt();
               scan.nextLine();

               System.out.println("\n----Before operation----");
               myList.printList();

               myList.addFirstNode(DataEntry);

               System.out.println("\n----After operation----");
               myList.printList();
               break;
            case 2:

               System.out.println("Please enter a value to be entered: ");
               int DataEntry2 = scan.nextInt();
               scan.nextLine();

               System.out.println("\n----Before operation----");
               myList.printList();

               myList.addLastNode(DataEntry2);

               System.out.println("\n----After operation----");
               myList.printList();
               break;
            case 3:

               System.out.println("Please enter a value to be entered: ");
               int DataEntry3 = scan.nextInt();
               scan.nextLine();

               System.out.println("Please enter an index: ");
               int Index = scan.nextInt();
               scan.nextLine();

               if(Index >= 0 && Index < myList.countNodes())
               {
                  System.out.println("\n----Before operation----");
                  myList.printList();

                  myList.addAtIndex(Index, DataEntry3);

                  System.out.println("\n----After operation----");
                  myList.printList();
               }
               else
               {
                  System.out.println("Invalid index, please try again.");
               }

               break;
            case 4:

               System.out.println("\n----Before operation----");
               myList.printList();

               System.out.println("\n\nRemoving first node... ");
               myList.removeFirstNode();

               System.out.println("\n----After operation----");
               myList.printList();
               break;
            case 5:

               System.out.println("\n----Before operation----");
               myList.printList();

               System.out.println("\n\nRemoving last node...");
               myList.removeLastNode();

               System.out.println("\n----After operation----");
               myList.printList();
               break;
            case 6:

               System.out.println("Please enter an index: ");
               int Index2 = scan.nextInt();
               scan.nextLine();
               if(Index2 >= 0 && Index2 < myList.countNodes())
               {
                  System.out.println("\n----Before operation----");
                  myList.printList();

                  System.out.println("\n\nRemoving node at index... ");
                  myList.removeAtIndex(Index2);

                  System.out.println("\n----After operation----");
                  myList.printList();
               }
               else
               {
                  System.out.println("Invalid index, please try again.");
               }

               break;
            case 7:
               //not sure why i need to print a before/after for printing the size of the list.
               System.out.println("\n----Before operation----");
               myList.printList();

               System.out.println("\nPrinting size... ");
               System.out.println("\nThe size of the list is: " + myList.countNodes());

               System.out.println("\n----After operation----");
               myList.printList();
               break;
            case 8:

               System.out.println("Printing nodes... ");
               myList.printList();
               break;
            case 9:

               System.out.println("\n----Before operation----");
               myList.printList();

               System.out.println("Printing nodes in reverse... ");
               myList.printInReverseRecursive(myList.ListName);

               System.out.println("\n----After operation----");
               myList.printList();
               break;
            case 10:

               Quit = true;
               System.out.println("Goodbye!");
               break;
         }

      }
   } 
}
    
