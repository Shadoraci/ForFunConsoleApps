import java.util.Scanner;

// Name: Tyler Ercole
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: Assignment 4 | Exercise 1
// IDE Name: Intellij Community 2023
public class ReverseString
{
    public static void main(String[] args)
    {
        MyStack<String> myStack = new MyStack<>();

        Scanner scan = new Scanner(System.in);
        boolean Quit = false;
        String InputString = " ";
        //My awesome menu
        while(!Quit)
        {
            System.out.println("---------MAIN MENU--------");
            System.out.println("1 – Read Input String of Words");
            System.out.println("2 – Reverse String and Display Outputs");
            System.out.println("3 – Exit Program");
            System.out.println();
            System.out.println("Enter option number: ");
            int Selection = scan.nextInt();
            scan.nextLine();

            //All my cases according to the menu respectively.
            switch(Selection)
            {
                case 1:
                    System.out.println("Please enter a string of words: ");
                    InputString = scan.nextLine();

                    while(!myStack.isEmpty())
                    {
                        myStack.Pop();
                    }

                   for(String Element : InputString.split(" "))
                   {
                       myStack.Push(Element);
                   }
                    break;
                case 2:
                    String ReverseString = " ";
                    System.out.println("Entered String: " + InputString);

                    System.out.print("\nReversed String:");

                    while(!myStack.isEmpty())
                    {
                        ReverseString += myStack.Pop() + " ";
                    }
                    System.out.println(ReverseString);
                    break;
                case 3:
                    Quit = true;
                    break;
            }

        }
    }
}

