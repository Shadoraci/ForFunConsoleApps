import java.util.Scanner;
// Name: Tyler Ercole
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: Assignment 2 | Exercise 1
// IDE Name: Intellij Community 2023

public class Vowels
{
    public static void main(String[] args)
    {
        String Input = "";
        boolean Quit = false;

        //Menu Loop
        while(!Quit)
        {
            Scanner Scan = new Scanner(System.in);
            System.out.println("--------MAIN MENU--------- ");
            System.out.println("1.) Read Input String");
            System.out.println("2.) Compute Number of Vowels");
            System.out.println("3.) Exit Program");
            System.out.println("Please enter your selection (1-3): ");
            int Selection = Scan.nextInt();
            Scan.nextLine();

            //User inputs numerical value to select menu option
            switch(Selection)
            {
                case 1: //Entering the string
                    System.out.println("Please enter your desired String: ");
                    Input = Scan.nextLine().toLowerCase();
                    break;
                case 2: //Performing the recursive act and displaying results
                    System.out.println();
                    System.out.println("----Performing Recursive Operation----");
                    System.out.println();
                    System.out.println("You entered string: '" + Input + "'");
                    System.out.println("The number of vowels is: " + CountVowels(Input));
                    System.out.println();
                    break;
                case 3: //Quit function
                    Quit = true;
                    break;
            }
        }
    }
    /**
     * @return Result: Returning the bool result of a char that is given.
     * It checks for a vowel and returns true/false
     */
    public static Boolean IsVowel(char Input)
    {
        boolean Result = false;
        if(Input == 'a' || Input == 'e' || Input == 'i' || Input == 'o' || Input == 'u')
        {
            Result = true;
        }
        return Result;
    }
    /**
     * @return Recursive function. The base case ends the loop when the string has been sifted through fully.
     * The starting char keeps checking the char at the string's 0'th index, and substring removes the 0'th index
     * each iteration.
     * Ex. (Island) as input. Island -> I [sland] -> Is -> [land] -> Isl -> [and] ... etc.
     * Each char is checked with IsVowel and returns a +1 if true to count the vowels.
     */
    public static int CountVowels(String Input)
    {
        //Ending case
        if(Input.isEmpty())
        {
          return 0;
        }
        char StartChar = Input.charAt(0);
        if(IsVowel(StartChar))
        {
            //Vowel found means to run again with a + 1
            return 1 + CountVowels(Input.substring(1));
        }
        else
        {
            //No vowel means to run again without counting
            return CountVowels(Input.substring(1));
        }
    }
}
