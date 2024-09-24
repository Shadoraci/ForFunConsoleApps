// Name: Tyler Ercole
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: Assignment 1 | Exercise 1
// IDE Name: Intellij Community 2023



// (/** + ENTER)
public class Rectangle
{
    private double Width = 1.00;
    private double Height = 1.00;

    //default constructor
    public Rectangle()
    {
        double newWidth = Width;
        double newHeight = Height;
    }
    //overloaded constructor
    public Rectangle(double inputWidth, double inputHeight)
    {
        Width = inputWidth;
        Height = inputHeight;
    }
    //Simple Get Methods
    public double GetWidth()
    {
        return Width;
    }
    public double GetHeight()
    {
        return Height;
    }
    public double GetArea()
    {
        double Area = Width * Height;
        return Area;
    }

    /**
     * @return Perimeter: Returning the perimeter of the rectangle
     */
    public double GetPerimeter()
    {
        double Perimeter = (2 * Width) + (2 * Height);
        return Perimeter;
    }
    /**
     * @param ObjectName Name of the class. Passes the name of the Rectangle to be used.
     */
    public void PrintRectangle(String ObjectName)
    {
        System.out.print("Rectangle " + ObjectName + " is " + Width + " units wide and " + Height + " units high.");
    }
}
