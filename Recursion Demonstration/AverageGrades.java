import java.text.DecimalFormat;
import java.util.Scanner;
// Name: Tyler Ercole
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: Assignment 2 | Exercise 1
// IDE Name: Intellij Community 2023

public class AverageGrades
{
    public static void main(String[] args)
    {
        DecimalFormat Deci = new DecimalFormat(".00");
        int ClassSize = 0;
        int[] ClassGrades = new int[ClassSize];
        boolean Quit = false;

        //Menu loop
        while(!Quit)
        {
            Scanner Scan = new Scanner(System.in);
            System.out.println("--------MAIN MENU--------- ");
            System.out.println("1.) Read Class Size");
            System.out.println("2.) Read Class Grades");
            System.out.println("3.) Compute Class Average");
            System.out.println("4.) Exit Program");
            System.out.println("Please enter your selection (1-4): ");
            int Selection = Scan.nextInt();
            Scan.nextLine();

            //User inputs numerical value to select menu option
            switch(Selection)
            {
                case 1:
                    System.out.println("Please enter the class size: ");
                    ClassSize = Scan.nextInt();
                    Scan.nextLine();
                    break;
                case 2:
                    ClassGrades = new int[ClassSize];

                    System.out.println("Please enter the class grades: (0 - 100)");
                    for (int i = 0; i < ClassGrades.length; i++)
                    {
                        System.out.println("Grade " + (i+1) + ": ");
                        int InputGrade = Scan.nextInt();
                        Scan.nextLine();
                        //InputGrade set to zero if outside boundaries
                        if(InputGrade <= 100 && InputGrade >= 0)
                        {
                            ClassGrades[i] = InputGrade;
                        }
                    }
                    System.out.println("--All done!--");
                    break;
                case 3:
                    System.out.println();
                    System.out.println("You entered a class size of: " + ClassSize);
                    System.out.print("You entered grades: ");
                    for (int i = 0; i < ClassSize; i++)
                    {
                        System.out.print(ClassGrades[i] + ", ");
                    }
                    System.out.println();
                    System.out.println("The class average is: " + Deci.format(FindAverage(ClassGrades, 0)));
                    break;
                case 4:
                    Quit = true;
                    break;
            }
        }
    }
    /**
     * @return Recursive function. The base case ends the loop when the array has been fully sifted through.
     * Once the base case is hit, the final cell in the array is returned.
     * During the iteration of averaging the grades, We use count to go through the array and grab each cell, adding it
     * into a return statement that will carry through until the first/final case (count == 0) to where it divides everything by the length
     * of the given array.
     */
    public static double FindAverage(int[] GradeArray, int Count)
    {
        //base condition
        if(Count == GradeArray.length - 1)
        {
            return GradeArray[Count];
        }
        //condition 2
        else if(Count == 0)
        {
            return (GradeArray[Count] + FindAverage(GradeArray, Count+1)) / GradeArray.length;
        }
        return GradeArray[Count] + FindAverage(GradeArray, Count+1);
    }
    //For loop to help me illustrate the recursive call.
    /*
        int sum = 0;
        double avg = 0;
        for(int i = 0; i > arr.length; i++)
        {
            arr[i] += sum;
        }
        avg = (sum/arr.length)
     */
}
