// Name: Tyler Ercole
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: Assignment 8 | Exercise 1
// IDE Name: Intellij Community 2023

import java.sql.SQLOutput;
import java.util.Scanner;

public class HashFunctions
{
    static int[] keys =
            {1234, 8234, 7867, 1009, 5438, 4312, 3420, 9487, 5418, 5299,
            5078, 8239, 1208, 5098, 5195, 5329, 4543, 3344, 7698, 5412,
            5567, 5672, 7934, 1254, 6091, 8732, 3095, 1975, 3843, 5589,
            5439, 8907, 4097, 3096, 4310, 5298, 9156, 3895, 6673, 7871,
            5787, 9289, 4553, 7822, 8755, 3398, 6774, 8289, 7665, 5523};

    static int[][] Table;

    //Menu
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        boolean Quit = false;

        while(!Quit)
        {
            System.out.println("\n\n\n");
            System.out.println("1. Run HF1 (Division method with Linear Probing)");
            System.out.println("2. Run HF2 (Division method with Quadratic Probing)");
            System.out.println("3. Run HF3 (Division method with Double Hashing)");
            System.out.println("4. Run HF4 (Student Designed HF)");
            System.out.println("5. Exit program");
            System.out.println("\nEnter option number: ");

            int Selection = scan.nextInt();
            scan.nextLine();

            switch (Selection)
            {
                case 1:
                    Table = new int[50][2];
                    for (int i = 0; i < 50; i++)
                    {
                        InsertLinear(keys[i]);
                    }

                    List();
                    break;
                case 2:
                    Table = new int[50][2];
                    for (int i = 0; i < 50; i++)
                    {
                        InsertQuadratic(keys[i]);
                    }

                    List();
                    break;
                case 3:
                    Table = new int[50][2];
                    for (int i = 0; i < 50; i++)
                    {

                        InsertDoubleHash(keys[i]);
                    }

                    List();
                    break;
                case 4:
                    Table = new int[50][2];
                    for (int i = 0; i < 50; i++)
                    {
                        InsertCustom(keys[i]);
                    }

                    List();
                    break;
                case 5:
                    Quit = true;
                    break;
            }
        }
    }
    //HF1 for cases 1, 2, 3
    public static int HF1(int Key)
    {
        return Math.abs(((Key % Table.length)));
    }
    //HF2 for DoubleHash
    public static int HF2(int Key)
    {
        return Math.abs((30-Key % 25));
    }
    //Golden Ratio Hash
    //This custom hash multiplies the key by a constant value for spacing in a uniform manner.
    public static int HFC(int Key)
    {
        double Fractional = (Key * 0.618) % 1;  //Extract the fractional part from real number. 0.618 is the constant we use.
        int Index = (int) (Fractional * Table.length); //I multiply the fractional by the table length to scale it back up to proper size.

        //Ensuring positive index
        return Math.abs((Index + Table.length) % Table.length);
    }
    //I decided to make an 'insert' method to properly use the required methods with their searches.
    public static void InsertLinear(int Key)
    {
        int Index = HF1(Key);
        int Probes = 0;

        // This is a Linear probing to find the next available slot
        while(Table[Index][0] != 0) //While index is not null
        {
            Probes++;//Increment probes
            Index = ((Key + Probes) % Table.length); //Increase index
        }
        Table[Index][0] = Key;
        Table[Index][1] = Probes;
    }
    public static void InsertQuadratic(int Key)
    {
        int Index = HF1(Key);
        int Probes = 0;

        // This is Quadratic probing to find the next available slot
        while(Table[Index][0] != 0) //While index is not null
        {
            Probes++;//Increment probes
            Index = ((Key + (Probes * Probes)) % Table.length); //Increase index
        }
        Table[Index][0] = Key;
        Table[Index][1] = Probes;
    }
    public static void InsertDoubleHash(int Key)
    {
        int Index = HF1(Key);
        int Probes = 0;

        // This is Double hash probing to find the next available slot
        while(Table[Index][0] != 0) //While index is not null
        {
            Probes++;//Increment probes
            Index = (HF1(Key) + Probes * HF2(Key)) % Table.length; //Increase index

            //Probe limit
            if(Probes == 50)
            {
                System.out.println("Unable to hash key " + Key + " to the table. ");
                return;
            }
        }
        Table[Index][0] = Key;
        Table[Index][1] = Probes;
    }
    public static void InsertCustom(int Key)
    {
        int Index = HFC(Key);
        int Probes = 0;

        // This is Quadratic probing to find the next available slot
        while(Table[Index][0] != 0) //While index is not null
        {
            Probes++;//Increment probes
            Index = ((Key + (Probes * Probes)) % Table.length); //Increase index

            //Probe limit
            if(Probes == 50)
            {
                System.out.println("Unable to hash key " + Key + " to the table. ");
                return;
            }
        }
        Table[Index][0] = Key;
        Table[Index][1] = Probes;
    }
    public static void List()
    {
        int SumOfProbes = 0;
        System.out.println("Index\tKey\t\tProbes");
        System.out.println("------------------------");

        for (int i = 0; i < 50; i++)
        {
                System.out.println("\t" + i + "\t\t" + Table[i][0] + "\t\t" + Table[i][1]);

                SumOfProbes += Table[i][1];
        }
        System.out.println("------------------------");
        System.out.println("Sum of probe values: " + SumOfProbes);
    }
}
