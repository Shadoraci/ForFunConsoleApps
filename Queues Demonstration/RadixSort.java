import java.util.Scanner;
// Name: Tyler Ercole
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: Assignment 5 | Exercise 3
// IDE Name: Intellij Community 2023
public class RadixSort
{
    public static void main(String[] args)
    {
        int ArrSize = 0;

        int[] Inputs = new int[ArrSize];

        Scanner scan = new Scanner(System.in);
        boolean Quit = false;

        //My awesome menu
        while (!Quit)
        {
            System.out.println("\n\n\n\n---------MAIN MENU--------");
            System.out.println("1 – Read Array Size");
            System.out.println("2 – Read Array Values");
            System.out.println("3 – Run Radix Sort and Print Output");
            System.out.println("4 – Exit Program");
            System.out.println();
            System.out.println("Enter option number: ");
            int Selection = scan.nextInt();
            scan.nextLine();

            //All my cases according to the menu respectively.
            switch (Selection)
            {
                case 1:
                    System.out.println("Please enter an array size: ");
                    ArrSize = scan.nextInt();
                    scan.nextLine();

                    break;
                case 2:
                    Inputs = new int[ArrSize];

                    System.out.println("Please enter values into the array: ");

                    for (int i = 0; i < ArrSize; i++)
                    {
                        System.out.print("Value: ");

                        int ArrValue = scan.nextInt();
                        scan.nextLine();

                        Inputs[i] = ArrValue;
                    }
                    break;
                case 3:
                    System.out.println("\nValues in array before sorting: ");
                    //printing before
                    for (int i = 0; i < Inputs.length; i++)
                    {
                        System.out.print(Inputs[i] + ", ");
                    }
                    System.out.println();

                    RadixSortM(Inputs);

                    System.out.println("\nValues in array after sorting: ");
                    //printing before
                    for (int i = 0; i < Inputs.length; i++)
                    {
                        System.out.print(Inputs[i] + ", ");
                    }
                    break;
                case 4:
                    Quit = true;
                    break;

            }
        }
    }
    //Radix Sort Method
    //While taking in an int array,
    public static void RadixSortM(int[] NumsArr)
    {
        //Shift is used to individualize each digit in a number
        int Shift = 1;

        //Making queues
        Queue<Integer>[] QueueArr = new Queue[10];

        for (int i = 0; i < 10; i++)
        {
            QueueArr[i] = new Queue<>();
        }

        //Finding Max
        int Max = 1;
        for (int Num : NumsArr)
        {
            if(Max < CountDigit(Num))
            {
                Max = CountDigit(Num);
            }
        }


        //After extracting the Num of Digits within an int using CountDigit(),
        //I utilize loops to perform the sort with Queues and ExtractDigit().
        for (int i = 0; i < (Max); i++)
        {
            System.out.println("----");
            for (int Num : NumsArr) {
                System.out.println(Num);
                QueueArr[ExtractDigit(Num, Shift)].Enqueue(Num);
            }

            int ArrI = 0;
            for (int QueIndex = 0; QueIndex < 10; QueIndex++)
            {
//                System.out.println("----"+ QueIndex + "----");
                while(!QueueArr[QueIndex].isEmpty())
                {
//                    System.out.println(QueueArr[QueIndex].Front());
                    NumsArr[ArrI] = QueueArr[QueIndex].Dequeue();
                    ArrI++;
                }
            }
            //Move to next individual digit
            Shift *= 10;
        }
    }
    //Extracts the digits from a Number
    public static int ExtractDigit(int Num, int Shift)
    {
      return ((Num / Shift) % 10);
    }
    //Counts the individual digits in a number
    public static int CountDigit(int Num)
    {
        int K = 0;
        while(Num > 0)
        {
            Num /= 10;
            K++;
        }
        return K;
    }
}
