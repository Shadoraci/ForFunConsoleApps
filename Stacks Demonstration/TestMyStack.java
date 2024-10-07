// Name: Tyler Ercole
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: Assignment 4 | Exercise 1
// IDE Name: Intellij Community 2023
import java.util.Scanner;

public class TestMyStack
{
    public static void main(String[] args)
    {

        MyStack<Integer> myStack = new MyStack<>();

        Scanner scan = new Scanner(System.in);
        boolean Quit = false;

        //My awesome menu
        while (!Quit)
        {
            System.out.println("\n\n\n\n---------MAIN MENU--------");
            System.out.println("1 – Push Element");
            System.out.println("2 – Pop Element");
            System.out.println("3 – Get Top Element");
            System.out.println("4 – Get Stack Size");
            System.out.println("5 – Is Empty Stack");
            System.out.println("6 – Print Stack");
            System.out.println("7 – Exit Program");
            System.out.println();
            System.out.println("Enter option number: ");
            int Selection = scan.nextInt();
            scan.nextLine();

            //All my cases according to the menu respectively.
            switch (Selection)
            {
                case 1:
                    System.out.println("Please enter element:");
                    int Entry = scan.nextInt();
                    scan.nextLine();

                    System.out.println("\n----Before operation----");
                    myStack.printList();

                    myStack.Push(Entry);

                    System.out.println("\n----After operation----");
                    myStack.printList();

                    break;
                case 2:
                    System.out.println("Popping Element...");
                    System.out.println("\n----Before operation----");
                    myStack.printList();

                    myStack.Pop();

                    System.out.println("\n----After operation----");
                    myStack.printList();
                    break;
                case 3:
                    System.out.println("\n----Before operation----");
                    myStack.printList();

                    System.out.println("\n\nGrabbing Top Element...");
                    System.out.println("Top Element is: " + myStack.Top());

                    System.out.println("\n----After operation----");
                    myStack.printList();
                    break;
                case 4:
                    System.out.println("Getting Stack Size...");
                    System.out.println("\n----Before operation----");
                    myStack.printList();

                    System.out.println("\n\nStack Size is: " + myStack.Size());

                    break;
                case 5:
                    System.out.println("Checking if Stack is Empty...");
                    System.out.println("\n----Before operation----");
                    myStack.printList();

                    System.out.println("\n\nIs Empty (T/F): " + myStack.isEmpty());

                    break;
                case 6:
                    System.out.println("Printing Stack...");
                    myStack.printList();
                    break;
                case 7:
                    Quit = true;
                    break;

            }
        }
    }
}
