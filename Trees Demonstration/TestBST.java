// Class TestBST.java
// Textbook, Listing 25.6, Page 936
// Name: Tyler Ercole
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: Assignment 5 | Exercise 1
// IDE Name: Intellij Community 2023

public class TestBST {
   public static void main(String[] args) {
    
      // Create a BST of strings 
      BST<String> tree = new BST<String>();
      tree.insert("George");
      tree.insert("Michael");
      tree.insert("Tom");
      tree.insert("Adam");
      tree.insert("Jones");
      tree.insert("Peter");
      tree.insert("Daniel");
   
      // Traverse tree
      System.out.print("Inorder (sorted): ");
      tree.inorder();
      System.out.print("\nPostorder: ");
      tree.postorder();
      System.out.print("\nPreorder: ");
      tree.preorder();
      System.out.print("\nThe number of nodes is " + tree.getSize());
   
      // Search for an element
      System.out.print("\nIs Peter in the tree? " + 
         tree.search("Peter"));
   
      // Get a path from the root to Peter
      System.out.print("\nA path from the root to Peter is: ");
      java.util.ArrayList<BST.TreeNode<String>> path = tree.path("Peter");
      for (int i = 0; path != null && i < path.size(); i++)
         System.out.print(path.get(i).element + " ");
   
      // Create a BST of integers
      Integer[] numbers = {2, 4, 3, 1, 8, 5, 6, 7};
      BST<Integer> intTree = new BST<Integer>(numbers);
      System.out.print("\nInorder (sorted): ");
      intTree.inorder();
   }
}
