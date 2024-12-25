// Name: Tyler Ercole
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: Assignment 6 | Exercise 1
// IDE Name: Intellij Community 2023

import java.util.Scanner;

public class TestPQH
{
    public static void main(String[] args)
    {

        Scanner scan = new Scanner(System.in);
        boolean Quit = false;
        boolean SelectedZero = false;
        boolean IsString = false;

        //HeapList
        PQ_heap HeapList = null;

        //My awesome menu
        while (!Quit)
        {
            System.out.println("\n\n---------MAIN MENU--------");
            System.out.println("0 – Enter Queue Data Type (Integer or String)");
            System.out.println("1 – Enqueue Element");
            System.out.println("2 – Dequeue Element");
            System.out.println("3 – Check is_Full");
            System.out.println("4 – Check is_Empty");
            System.out.println("5 – Print PQueue Size");
            System.out.println("6 – Display Front Element");
            System.out.println("7 – Print PQueue Elements");
            System.out.println("8 – Exit Program");
            System.out.println();
            System.out.println("Enter option number: ");
            int Selection = scan.nextInt();
            scan.nextLine();

            //All my cases according to the menu respectively.
            if(Selection == 0)
            {
                //Case 0 Code here
                System.out.println("What is the tree's datatype?");
                String InputString = scan.nextLine();
                if(InputString.equalsIgnoreCase(("Integer")))
                {
                    HeapList = new PQ_heap<Integer>();
                    IsString = false;

                    System.out.println("Tree is declared as an Integer");
                }
                else if(InputString.equalsIgnoreCase(("String")))
                {
                    HeapList = new PQ_heap<String>();
                    IsString = true;

                    System.out.println("Tree is declared as an String");
                }
                else
                {
                    System.out.println("Please select from the two data-types");
                }
                SelectedZero = true;
            }
            else if (!SelectedZero)
            {
                System.out.println("Please start with option 0.");
            }
            if (SelectedZero)
            {
                switch (Selection)
                {
                    case 1: //Enqueueing

                            if (IsString) {
                                System.out.println("Please enter your data (String): ");
                                String Input = scan.nextLine();

                                System.out.println("Tree before inserting... " + Input);
                                HeapList.print();

                                HeapList.enqueue(Input);

                                System.out.println("\nTree after inserting... " + Input);
                                HeapList.print();

                            } else if (!IsString) {
                                System.out.println("Please enter your data (Integer): ");
                                int input = Integer.parseInt(scan.nextLine());

                                System.out.println("Tree before inserting... " + input);
                                HeapList.print();

                                HeapList.enqueue(input);

                                System.out.println("\nTree after inserting... " + input);
                                HeapList.print();
                            }
                        break;

                    case 2: //Deleting
                        if(!HeapList.is_empty())
                        {
                            System.out.println("Tree before deleting... ");
                            HeapList.print();

                            HeapList.dequeue();

                            System.out.println("\nTree after deleting... ");
                            HeapList.print();
                        }
                        else
                        {
                            System.out.println("Please make sure PQueue has at least one element.");
                        }
                        break;
                    case 3: //isFull
                        System.out.println("PQueue is Full (True/False): " + HeapList.is_full());
                        break;
                    case 4: //IsEmpty
                        System.out.println("PQueue is Empty (True/False): " + HeapList.is_empty());
                        break;
                    case 5: //Print PQueue Size
                        System.out.println("PQueue size is: " + HeapList.size());
                        break;
                    case 6: //Display Front
                        if(!HeapList.is_empty())
                        {
                            System.out.println("Front element is: " + HeapList.front());
                        }
                        else
                        {
                            System.out.println("Please make sure PQueue has at least one element.");
                        }
                        break;
                    case 7: //Printing PQueue Elements
                        if(!HeapList.is_empty())
                        {
                            HeapList.printList();
                        }
                        else
                        {
                            System.out.println("Please make sure PQueue has at least one element.");
                        }
                        break;
                    case 8: //Exit Program
                        Quit = true;
                        System.out.println("Exiting program...");
                        break;

                }
            }
        }
    }
}
