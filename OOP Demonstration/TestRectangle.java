// Name: Tyler Ercole
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: Assignment 1 | Exercise 1
// IDE Name: Intellij Community 2023
import java.util.Scanner;
public class TestRectangle
{
    public static void main(String[] args)
    {
        Scanner Scan = new Scanner(System.in);
        Rectangle MyRectangle = new Rectangle();

        //Input 1 for Width
        System.out.print("Please input your width: ");
        int WidthInput = Integer.parseInt(Scan.nextLine());

        //Input 2 for Height
        System.out.print("Please input your height: ");
        int HeightInput = Integer.parseInt(Scan.nextLine());

        //Object Creation
        Rectangle YourRectangle = new Rectangle(WidthInput, HeightInput);

        //Actual Method Calling
        System.out.println("------------------------------------------");
        System.out.println("Finalizing Results... Printing accurate data");
        System.out.println("------------------------------------------");

        PrintFormat(MyRectangle, "MyRectangle");
        PrintFormat(YourRectangle, "YourRectangle");

        //Testing calls
        System.out.println();
        System.out.println("Testing method GetWidth() on object MyRectangle: ");
        System.out.println(MyRectangle.GetWidth());

        System.out.println("Testing method GetArea() on object MyRectangle: ");
        System.out.println(MyRectangle.GetArea());

        System.out.println("Testing method GetPerimeter() on object MyRectangle: ");
        System.out.println(MyRectangle.GetPerimeter());

        System.out.println("Testing method PrintRectangle() on object MyRectangle: ");
        MyRectangle.PrintRectangle("MyRectangle");
        System.out.println();
        System.out.println();


    }
    /**
     * @param TheRect Name of the Rectangle to be passed in.
     * The format is then pasted based on the Passed-in rectangle's values
     */
    public static void PrintFormat(Rectangle TheRect, String Name)
    {

        System.out.println();
        System.out.println();
        System.out.println(Name + ": ");
        System.out.println("------------");
        System.out.println("Width: " + TheRect.GetWidth());
        System.out.println("Height: " + TheRect.GetHeight());
        System.out.println("Area: " + TheRect.GetArea());
        System.out.println("Perimeter: " + TheRect.GetPerimeter());
        System.out.println();
        TheRect.PrintRectangle(Name);
    }
}
