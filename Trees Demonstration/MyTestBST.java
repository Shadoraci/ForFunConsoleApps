import java.util.Scanner;

// Class BST.java
// Textbook, Listing 25.5, Page 937
// Name: Tyler Ercole
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: Assignment 5 | Exercise 1
// IDE Name: Intellij Community 2023
public class MyTestBST
{
    public static void main(String[] args)
    {

        Scanner scan = new Scanner(System.in);
        boolean Quit = false;
        boolean SelectedZero = false;
        boolean IsString = false;

        //Integer tree
        BST Tree = null;

        //My awesome menu
        while (!Quit)
        {
            System.out.println("\n\n---------MAIN MENU--------");
            System.out.println("0 – Enter Tree Data Type (Integer or String)");
            System.out.println("1 – Insert Data Element");
            System.out.println("2 – Delete Data Element");
            System.out.println("3 – Search for Data Element");
            System.out.println("4 – Print Tree Size");
            System.out.println("5 – Path from Root to Data Element");
            System.out.println("6 – Check if Empty Tree");
            System.out.println("7 – Print Preorder Traversal");
            System.out.println("8 – Print Inorder Traversal");
            System.out.println("9 – Print Postorder Traversal");
            System.out.println("10 – Exit Program");
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
                    Tree = new BST<Integer>();
                    IsString = false;

                    System.out.println("Tree is declared as an Integer");
                }
                else if(InputString.equalsIgnoreCase(("String")))
                {
                    Tree = new BST<String>();
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
                    case 1: //Inserting
                        if(IsString)
                        {
                            System.out.println("Please enter your data (String): ");
                            String Input = scan.nextLine();

                            System.out.println("Tree before inserting... " + Input);
                            Tree.inorder();

                            Tree.insert(Input);

                            System.out.println("\nTree after inserting... " + Input);
                            Tree.inorder();
                        }
                        else if(!IsString)
                        {
                            System.out.println("Please enter your data (Integer): ");
                            String Input = scan.nextLine();

                            System.out.println("Tree before inserting... " + Input);
                            Tree.inorder();

                            Tree.insert(Input);

                            System.out.println("\nTree after inserting... " + Input);
                            Tree.inorder();
                        }
                        break;

                    case 2: //Deleting
                        if(IsString)
                        {
                            System.out.println("Please enter the data you want to delete (String): ");
                            String Input = scan.nextLine();

                            System.out.println("Tree before deleting... " + Input);
                            Tree.inorder();

                            Tree.delete(Input);

                            System.out.println("\nTree after deleting... " + Input);
                            Tree.inorder();
                        }
                        else if(!IsString)
                        {
                            System.out.println("Please enter the data you want to delete (Integer): ");
                            String Input = scan.nextLine();

                            System.out.println("Tree before deleting... " + Input);
                            Tree.inorder();

                            Tree.delete(Input);

                            System.out.println("\nTree after deleting... " + Input);
                            Tree.inorder();
                        }
                        break;
                    case 3: //Search
                        if(IsString)
                        {
                            System.out.println("Please enter the data you want to search for (String): ");
                            String Input = scan.nextLine();

                            System.out.println("Is " + Input + "in the tree? " + Tree.search(Input));
                        }
                        else if(!IsString)
                        {
                            System.out.println("Please enter the data you want to search for (Integer): ");
                            String Input = scan.nextLine();

                            System.out.println("Is " + Input + "in the tree? " + Tree.search(Input));
                        }
                        break;
                    case 4: //Size
                        System.out.println("Tree Size is: " + Tree.getSize());
                        break;
                    case 5: //Pathing
                        if(IsString)
                        {
                            System.out.println("Please enter the data element you want to path too (String): ");
                            String Input = scan.nextLine();
                            //Search
                            if(Tree.search(Input))
                            {
                                System.out.println("A path from the root to " + Input + " is: ");

                                java.util.ArrayList<BST.TreeNode<String>> Path = Tree.path(Input);
                                for (int i = 0; Path != null && i < Path.size(); i++)
                                    System.out.print(Path.get(i).element + " -> ");
                            }
                            else
                            {
                                System.out.println("Could not path to non-existent node.");
                            }

                        }
                        else if(!IsString)
                        {
                            System.out.println("Please enter the data element you want to path too (Integer): ");
                            String Input = scan.nextLine();

                            if(Tree.search(Input))
                            {
                                System.out.println("A path from the root to " + Input + " is: ");

                                java.util.ArrayList<BST.TreeNode<String>> Path = Tree.path(Input);
                                for (int i = 0; Path != null && i < Path.size(); i++)
                                    System.out.print(Path.get(i).element + " -> ");
                            }
                            else
                            {
                                System.out.println("Could not path to non-existent node.");
                            }
                        }
                        break;
                    case 6: //Empty?
                        System.out.println("Is the tree empty: " + Tree.isEmpty());
                        break;
                    case 7: //Printing Pre
                        System.out.println("Printing Pre-order Traversal");
                        Tree.preorder();
                        break;
                    case 8: //Printing In
                        System.out.println("Printing In-order Traversal");
                        Tree.inorder();
                        break;
                    case 9: //Printing Post
                        System.out.println("Printing Post-order Traversal");
                        Tree.postorder();
                        break;
                    case 10: //Quit
                        Quit = true;
                        System.out.println("Exiting program...");
                        break;

                }
            }
        }
    }
}
