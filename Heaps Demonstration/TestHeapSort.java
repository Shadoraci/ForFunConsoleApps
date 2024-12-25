// Class Heap.java 
// Textbook - Listing 23.9, Page 878

// Name: Tyler Ercole
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: Assignment 6 | Exercise 1
// IDE Name: Intellij Community 2023

public class TestHeapSort { 
   /** A test method */
   public static void main(String[] args)
   {

      //Original List (List1)
      Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53}; 

      //Char List (List2)
      Character[] CharList = {'w','f','A','X','T','Q','k','s','8','L','3','b','A','w','s','H','j','K','L'};

      //String List (List3)
      String[] StringList = {"Data", "Structure", "Is", "Hard", "Computing", "Class", "To Pass"};

      //Print Original List ----------------------------------
      System.out.print("\n\nOriginal List:\t");  //print original list
      for (int i = 0; i < list.length; i++)
         System.out.print(list[i] + " ");
         
      HeapSort.heapSort(list);  //sort the list
      
      System.out.print("\n\nSorted List:\t");  //print original list
      for (int i = 0; i < list.length; i++)
         System.out.print(list[i] + " ");   


      //Print List2 -----------------------------------
      System.out.print("\n\nOriginal List:\t");  //print original list
      for (int i = 0; i < CharList.length; i++)
         System.out.print(CharList[i] + " ");

      HeapSort.heapSort(CharList);  //sort the list

      System.out.print("\n\nSorted List:\t");  //print original list
      for (int i = 0; i < CharList.length; i++)
         System.out.print(CharList[i] + " ");


      //Print List3 ---------------------------
      System.out.print("\n\nOriginal List:\t");  //print original list
      for (int i = 0; i < StringList.length; i++)
         System.out.print(StringList[i] + " ");

      HeapSort.heapSort(StringList);  //sort the list

      System.out.print("\n\nSorted List:\t");  //print original list
      for (int i = 0; i < StringList.length; i++)
         System.out.print(StringList[i] + " ");
   }
}
