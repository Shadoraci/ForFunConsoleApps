// Name: Tyler Ercole
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: Assignment 1 | Exercise 2
// IDE Name: Intellij Community 2023
import java.util.Scanner;
public class TestTemps
{
    public static void main(String[] args)
    {
        //Inputs
        Scanner Scan = new Scanner(System.in);
        System.out.println("Please input the temperatures starting from Monday to Sunday: ");
        System.out.println("Monday: ");
        float Temp1 = Float.parseFloat(Scan.nextLine());
        System.out.println("Tuesday: ");
        float Temp2 = Float.parseFloat(Scan.nextLine());
        System.out.println("Wednesday: ");
        float Temp3 = Float.parseFloat(Scan.nextLine());
        System.out.println("Thursday: ");
        float Temp4 = Float.parseFloat(Scan.nextLine());
        System.out.println("Friday: ");
        float Temp5 = Float.parseFloat(Scan.nextLine());
        System.out.println("Saturday: ");
        float Temp6 = Float.parseFloat(Scan.nextLine());
        System.out.println("Sunday: ");
        float Temp7 = Float.parseFloat(Scan.nextLine());

        //Object creation and setting of temps for the week.
        DailyTemps Temperatures = new DailyTemps(Temp1, Temp2, Temp3, Temp4, Temp5, Temp6, Temp7);

        //Replace Temp Question
        System.out.println("Did you make an error in one of the temperatures? (Y/N)");
        String Answer = Scan.nextLine().toLowerCase();
        if(Answer.equals("y"))
        {
            System.out.println("Please enter the Day (1-7) of the week: ");
            int Day = Integer.parseInt(Scan.nextLine());
            System.out.println("Please enter the Temperature: ");
            float NewTemp = Float.parseFloat(Scan.nextLine());
            Temperatures.SetTemp(Day, NewTemp);

            System.out.println("Operation complete!");
            System.out.println("Set the temp to" + NewTemp + "to the " + Day + "rd/st day of the week." );
        }

        //outside if statement
        System.out.println("Continuing!");
        System.out.println("There are " + Temperatures.Freezing() + " freezing day(s) this week.");
        System.out.println(Temperatures.Warmest() + " is the warmest day of the week.");
        Temperatures.PrintTemps();

        //Testing calls
        DailyTemps TestTemp = new DailyTemps(Temp1, Temp2, Temp3, Temp4, Temp5, Temp6, Temp7);
        System.out.println();
        System.out.println("Testing method SetTemp() on object TestTemp: " );
        TestTemp.SetTemp(3, 50.0f);
        System.out.println("Set the temp to 50.0 to the 3rd day of the week." );

        System.out.println("Testing method Freezing() on object TestTemp: ");
        TestTemp.Freezing();
        System.out.println("There are "+ TestTemp.Freezing() + " freezing day(s)");

        System.out.println("Testing method Warmest() on object TestTemp: ");
        TestTemp.Warmest();
        System.out.println(TestTemp.Warmest() + " is the warmest day of the week.");

        System.out.println("Testing method PrintTemps() on object TestTemp: ");
        TestTemp.PrintTemps();

        System.out.println();
        System.out.println();
    }
}
