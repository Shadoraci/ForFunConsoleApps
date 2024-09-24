// Name: Tyler Ercole
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: Assignment 1 | Exercise 2
// IDE Name: Intellij Community 2023
public class DailyTemps
{
   private float[] TempArray = new float[7];

   //Overloaded Constructor
   public DailyTemps(float In1, float In2, float In3, float In4, float In5, float In6, float In7)
   {
       TempArray[0] = In1; //Monday
       TempArray[1] = In2; //Tuesday
       TempArray[2] = In3; //Wednesday
       TempArray[3] = In4; //Thursday
       TempArray[4] = In5; //Friday
       TempArray[5] = In6; //Saturday
       TempArray[6] = In7; //Sunday
   }
   //Setting method
   public void SetTemp(int DayOfWeek, float TempInput)
   {
       TempArray[DayOfWeek - 1] = TempInput;
   }
    /**
     * @return NumOfFreeze: returns the number of days that are below freezing (32f).
     */
   public float Freezing()
   {
       int NumOfFreeze = 0;
       for(int i = 0; i < TempArray.length; i++)
       {
           if(TempArray[i] < 32.0f)
           {
               NumOfFreeze++;
           }
       }
       return NumOfFreeze;
   }
    /**
     * @return Warmest: returns the hottest day by finding the hottest temp within the array and
     * comparing it to the index to find the hottest day
     */
    public String Warmest()
    {
        float Max = TempArray[0];
        int Count = 0;
        String Day = " ";
        //Finds max temp
        for(int i = 0; i < TempArray.length; i++)
        {
             if(Max < TempArray[i])
             {
                 Max = TempArray[i];
                 Count = i;
             }
        }
        //Takes the proper day according to the index.
        if(Count == 0)
        {
            Day = "Monday";
        }
        else if(Count == 1)
        {
            Day = "Tuesday";
        }
        else if(Count == 2)
        {
            Day = "Wednesday";
        }
        else if(Count == 3)
        {
            Day = "Thursday";
        }
        else if(Count == 4)
        {
            Day = "Friday";
        }
        else if(Count == 5)
        {
            Day = "Saturday";
        }
        else if(Count == 6)
        {
            Day = "Sunday";
        }
        return Day;
    }
    //Prints the temps
    public void PrintTemps()
    {
        String Day = " ";
        for (int i = 0; i < TempArray.length; i++)
        {
            if(i == 0)
            {
                Day = "Monday";
            }
            else if(i == 1)
            {
                Day = "Tuesday";
            }
            else if(i == 2)
            {
                Day = "Wednesday";
            }
            else if(i == 3)
            {
                Day = "Thursday";
            }
            else if(i == 4)
            {
                Day = "Friday";
            }
            else if(i == 5)
            {
                Day = "Saturday";
            }
            else if(i == 6)
            {
                Day = "Sunday";
            }
            System.out.println(Day + " " + TempArray[i]);
        }
    }
}
