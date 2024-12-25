// Class AbstrcatTree.java
// Textbook, Listing 25.4, Page 936
// Name: Tyler Ercole
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: Assignment 5 | Exercise 1
// IDE Name: Intellij Community 2023

public abstract class AbstractTree<E> implements Tree<E> {
  @Override /** Inorder traversal from the root*/
  public void inorder() {
  }

  @Override /** Postorder traversal from the root */
  public void postorder() {
  }

  @Override /** Preorder traversal from the root */
  public void preorder() {
  }

  @Override /** Return true if the tree is empty */
  public boolean isEmpty() {
    return getSize() == 0;
  }
}
