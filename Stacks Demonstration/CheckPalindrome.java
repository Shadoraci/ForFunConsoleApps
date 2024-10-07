import java.util.Scanner;

// Name: Tyler Ercole
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: Assignment 4 | Exercise 1
// IDE Name: Intellij Community 2023
public class CheckPalindrome
{
    public static void main(String[] args)
    {
        MyStack<Character> myStack = new MyStack<>();

        Scanner scan = new Scanner(System.in);
        boolean Quit = false;
        String InputString = " ";
        //My awesome menu
        while(!Quit)
        {
            System.out.println("\n\n---------MAIN MENU--------");
            System.out.println("1 – Read Input");
            System.out.println("2 – Check Palindrome");
            System.out.println("3 – Exit Program");
            System.out.println();
            System.out.println("Enter option number: ");
            int Selection = scan.nextInt();
            scan.nextLine();

            //All my cases according to the menu respectively.
            switch(Selection)
            {
                case 1:
                    System.out.println("Please enter a string: ");
                    InputString = scan.nextLine().toLowerCase();

                    char[] Letters = InputString.toCharArray();

                    for(char Element : Letters)
                    {
                        myStack.Push(Element);
                    }
                    break;
                case 2:
                    String ReverseString = "";
                    boolean Judgement = false;
                    String Palidrome = " ";
                    System.out.println("Entered String: " + InputString);

                    while(!myStack.isEmpty())
                    {
                        ReverseString += myStack.Pop();

                        if(ReverseString.equalsIgnoreCase(InputString))
                        {
                            Judgement = true;
                        }
                    }
                    if(Judgement)
                    {
                        Palidrome = "Palidrome";
                    }
                    else
                    {
                        Palidrome = "Not a Palidrome";
                    }
                    System.out.println(ReverseString);
                    System.out.print("\nJudgement: " + Palidrome);

                    break;
                case 3:
                    Quit = true;
                    break;
            }

        }
    }
}
