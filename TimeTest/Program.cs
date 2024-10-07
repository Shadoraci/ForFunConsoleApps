using System;
using System.Diagnostics;
using System.Runtime;
using System.Threading; 
namespace MyApp
{
    internal class Program
    {

        
        static List<int[]> ListOfArrays = new List<int[]>();

        //Main Method
        private static void Main(string[] args)
        {
            Stopwatch stopWatch = new Stopwatch();
            Console.WriteLine("Please enter a number that will be the size of the array: ");
            int Input = Int32.Parse(Console.ReadLine());

            //Make Array to fill and add to List
            //Adding 1000 arrays to list
            for(int i  = 0; i < 1000; i++)
            {
                int[] IntArr = new int[Input];
                FillArray(IntArr);
                ListOfArrays.Add(IntArr);
            }

            //Array Creation 
            int[] RandomArray = new int[Input];

            //Fill Array
            FillArray(RandomArray);

          

            //BubbleSort and Printing before and After
            Console.WriteLine("Bubble Before Printing");
            PrintArray(RandomArray);
            Console.WriteLine("-------------");
            BubbleSort(RandomArray);
            Console.WriteLine("Bubble After Printing");
            PrintArray(RandomArray);
            Console.WriteLine("-------------");

            

            //Fill Array again
             FillArray(RandomArray);

            //SelectionSort and Printing before and After
            Console.WriteLine("Selection Before Printing");
            PrintArray(RandomArray);
            Console.WriteLine("-------------");
            SelectionSort(RandomArray);
            Console.WriteLine("Selection After Printing");
            PrintArray(RandomArray);
            Console.WriteLine("-------------");

            Console.WriteLine("----------------------Calculating Time for Sorts--------------------------------");

            //Calculating time on bubble sort of 1000 arrays

             
            Thread.Sleep(1000);
            long BeforeMilliseconds = DateTime.Now.Ticks / TimeSpan.TicksPerMicrosecond;
          
            for (int i = 0; i < ListOfArrays.Count; i++)
            {
                BubbleSort(ListOfArrays[i]);
            }
            long AfterMilliseconds = DateTime.Now.Ticks / TimeSpan.TicksPerMicrosecond;
           
            long TotalTimeElapsedAvg = ((AfterMilliseconds - BeforeMilliseconds)/ Input);

            Console.WriteLine("Elapsed time for bubble sort is: " + TotalTimeElapsedAvg + " Microseconds");


            //Calculating time on bubble sort of 1000 arrays
            Thread.Sleep(1000);
            long BeforeMilliseconds2 = DateTime.Now.Ticks / TimeSpan.TicksPerMicrosecond;
            for (int i = 0; i < ListOfArrays.Count; i++)
            {
                SelectionSort(ListOfArrays[i]);
            }
            long AfterMilliseconds2 = DateTime.Now.Ticks / TimeSpan.TicksPerMicrosecond;

            long TotalTimeElapsedAvg2 = ((AfterMilliseconds2 - BeforeMilliseconds2)/ Input);
            
            Console.WriteLine("Elapsed time for bubble sort is: " + TotalTimeElapsedAvg2 + " Microseconds");
        }

        //Bubble Sort Method
        static void BubbleSort(int[] GivenArray)
        {
            int Num = GivenArray.Length;
            for (int i = 0; i < Num - 1; i++)
            {
                for (int j = 0; j < Num - 1 - i; j++)
                {
                    if (GivenArray[j] > GivenArray[j + 1])
                    {
                        // Switching GivenArray[j] and GivenArray[j + 1]
                        int temp = GivenArray[j];
                        GivenArray[j] = GivenArray[j + 1];
                        GivenArray[j + 1] = temp;
                    }
                }
            }
        }
        static void SelectionSort(int[] GivenArray)
        {
            int n = GivenArray.Length;

            for (int i = 0; i < n - 1; i++)
            {
                // Find Min
                int MinIndex = i;
                for (int j = i + 1; j < n; j++)
                {
                    if (GivenArray[j] < GivenArray[MinIndex])
                    {
                        MinIndex = j;
                    }
                }

                int Temp = GivenArray[MinIndex];
                GivenArray[MinIndex] = GivenArray[i];
                GivenArray[i] = Temp;
            }
        }
        static void PrintArray(int[] GivenArray)
        {
            foreach (int Num in GivenArray)
            {
                Console.Write(Num + " ");
            }
            Console.WriteLine();
        }
        static void FillArray(int[] GivenArray)
        { 
            Random Rand = new Random();
            //Fill Array  
            for (int i = 0; i < GivenArray.Length; i++)
            {
                GivenArray[i] = Rand.Next(100);
            }
        }
    }
}