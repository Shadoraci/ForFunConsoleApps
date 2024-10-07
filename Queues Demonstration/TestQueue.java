import java.util.Scanner;
// Name: Tyler Ercole
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: Assignment 5 | Exercise 2
// IDE Name: Intellij Community 2023
public class TestQueue
{
    public static void main(String[] args)
    {

        Queue<Integer> myQueue = new Queue<>();

        Scanner scan = new Scanner(System.in);
        boolean Quit = false;

        //My awesome menu
        while (!Quit)
        {
            System.out.println("\n\n\n\n---------MAIN MENU--------");
            System.out.println("1 – Enqueue Element");
            System.out.println("2 – Dequeue Element");
            System.out.println("3 – Get Front Element");
            System.out.println("4 – Get Queue Size");
            System.out.println("5 – Is Empty Queue");
            System.out.println("6 – Print Queue");
            System.out.println("7 – Exit Program");
            System.out.println();
            System.out.println("Enter option number: ");
            int Selection = scan.nextInt();
            scan.nextLine();

            //All my cases according to the menu respectively.
            switch (Selection)
            {
                case 1:
                    System.out.println("Please enter element: ");
                    int Entry = scan.nextInt();
                    scan.nextLine();

                    System.out.println("\n----Before operation----");
                    myQueue.printList();

                    myQueue.Enqueue(Entry);

                    System.out.println("\n----After operation----");
                    myQueue.printList();

                    break;
                case 2:
                    System.out.println("Dequeuing Element...");
                    System.out.println("\n----Before operation----");
                    myQueue.printList();

                    myQueue.Dequeue();

                    System.out.println("\n----After operation----");
                    myQueue.printList();
                    break;
                case 3:
                    if(!myQueue.isEmpty())
                    {
                        System.out.println("\n----Before operation----");
                        myQueue.printList();

                        System.out.println("\n\nGrabbing Front Element...");
                        System.out.println("Front Element is: " + myQueue.Front());

                        System.out.println("\n----After operation----");
                        myQueue.printList();
                    }
                    break;
                case 4:
                    System.out.println("Getting Queue Size...");
                    System.out.println("\n----Before operation----");
                    myQueue.printList();

                    System.out.println("\n\nQueue Size is: " + myQueue.Size());

                    break;
                case 5:
                    System.out.println("Checking if Queue is Empty...");
                    System.out.println("\n----Before operation----");
                    myQueue.printList();

                    System.out.println("\n\nIs Empty (T/F): " + myQueue.isEmpty());

                    break;
                case 6:
                    System.out.println("Printing Queue...");
                    myQueue.printList();
                    break;
                case 7:
                    Quit = true;
                    break;

            }
        }
    }
}
