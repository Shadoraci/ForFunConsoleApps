import java.util.Scanner;
// Class AbstrcatTree.java
// Textbook, Listing 25.4, Page 936
// Name: Tyler Ercole
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: Assignment 5 | Exercise 1
// IDE Name: Intellij Community 2023

public class RemoveDuplicates
{
    public static void main(String[] args)
    {

        Scanner scan = new Scanner(System.in);
        boolean Quit = false;
        boolean SelectedZero = false;
        boolean IsString = false;

        //String Tree
        BST<String> Tree = new BST<String>();;
        String Input = " ";
        //My awesome menu
        while (!Quit)
        {
            System.out.println("\n\n---------MAIN MENU--------");
            System.out.println("1 – Read Input String");
            System.out.println("2 – Remove duplicates and display outputs");
            System.out.println("3 – Exit Program");
            System.out.println();
            System.out.println("Enter option number: ");
            int Selection = scan.nextInt();
            scan.nextLine();

            switch (Selection)
            {
                case 1:
                    System.out.println("Please enter the original text: ");
                    Input = scan.nextLine();
                    //reinitialize
                    Tree = new BST<String>();

                    String[] InputsArr = Input.split(" ");
                    for (int i = 0; i < InputsArr.length; i++)
                        Tree.insert(InputsArr[i]);

                    break;
                case 2:
                    System.out.println("Removing duplicates and providing outputs...");
                    System.out.println("\nOriginal Input: ");
                    System.out.println(Input);
                    System.out.println("\nResulting Output: ");
                    Tree.inorder();

                    break;
                case 3:
                    Quit = true;
                    System.out.println("Exiting program...");
                    break;
            }
        }
    }
}
