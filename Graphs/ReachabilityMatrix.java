import java.util.Scanner;
// Name: Tyler Ercole
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: Assignment 9 | Exercise 1
// IDE Name: Intellij Community 2023
public class ReachabilityMatrix
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        boolean Quit = false;
        boolean SelectedZero = false;
        boolean IsString = false;

        //Matrix
        int[][] Matrix = null;

        //Method to add two matricies. A method to find power of a matrix. Compute reachability matrix with the usage of the prior two.
        //Reachability of an N x N sized matrix is A^1 + A^2 + A^3 + .... + A^n
        //and then use all 3 to compute the rest.
        //My awesome menu

        while (!Quit) {
            System.out.println("\n\n---------MAIN MENU--------");
            System.out.println("1 – Enter Graph Data");
            System.out.println("2 – Print Outputs");
            System.out.println("3 – Exit Program");
            System.out.println();
            System.out.println("Enter option number: ");
            int Selection = scan.nextInt();
            scan.nextLine();

            switch (Selection)
            {
                case 1: //Entering Graph Data

                    System.out.println("How many nodes (max 5): ");
                    int NodeNum = scan.nextInt();
                    Matrix = new int[NodeNum][NodeNum];
                    if(NodeNum <= 5 && NodeNum >= 0)
                    {
                        for (int i = 0; i < NodeNum; i++) {
                            for (int j = 0; j < NodeNum; j++) {
                                System.out.println("Enter A1" + " [" + i + "," + j + "]: ");
                                int Num = scan.nextInt();
                                Matrix[i][j] = Num;
                            }
                            System.out.println("...");
                        }
                    }
                    else
                    {
                        System.out.println("Please enter a valid Node count between 0 and 5.");
                    }
                    break;
                case 2:
                    System.out.println("Input Matrix: ");
                    PrintMatrix(Matrix);

                    System.out.println("Reachability Matrix: ");
                    PrintMatrix(GraphReachMatrix(Matrix));

                    System.out.println("\nIn-Degrees: ");
                    InDegree(Matrix);

                    System.out.println("\nOut-Degrees: ");
                    OutDegree(Matrix);

                    LoopTotal(Matrix);

                    CycleTotal(Matrix);

                    PathToOne(Matrix);

                    PathTotal(Matrix);

                    Path1toN(GraphReachMatrix(Matrix));

                    Cycle1toN(GraphReachMatrix(Matrix));
                    break;
                case 3: //Exit Program
                    Quit = true;
                    System.out.println("Exiting program...");
                    break;
            }
        }
    }
    /**
     * Reachability Matrix method that computes the given reachability
     * used with a combination of AddMatrix() and MultiplyMatrix() methods
     *
     * @param InputMatrix The matrix to be Inputted
     */
    public static int[][] GraphReachMatrix(int[][] InputMatrix)
    {
        int Nodes = InputMatrix.length;
        int[][] ResultMatrix = InputMatrix.clone();

        for (int i = 1; i < Nodes; i++)
        {
            int[][] RaisedMatrix = InputMatrix.clone();

            for (int j = 0; j < i; j++)
            {
                RaisedMatrix = MultiplyMatrix(RaisedMatrix, InputMatrix);
            }
            ResultMatrix = AddMatrix(ResultMatrix, RaisedMatrix);
        }
        return ResultMatrix;
    }
    /**
     * A print method for the printing of Matrices to the console
     *
     * @param InputMatrix The matrix to be Inputted
     */
    public static void PrintMatrix(int[][] InputMatrix)
    {
        int Nodes = InputMatrix.length;
        for (int i = 0; i < Nodes; i++)
        {
            for (int j = 0; j < Nodes; j++)
            {
                System.out.print(InputMatrix[i][j] + ", ");
            }
            System.out.println();
        }
    }
    /**
     * Adds two matrices into a resulting matrix and returns it.
     * @param InputMatrix The matrix to be Inputted
     */
    public static int[][] AddMatrix(int[][] InputMatrix, int[][] InputMatrix2)
    {
        int Nodes = InputMatrix.length;

        int[][] ResultMatrix = new int[Nodes][Nodes];

        for (int i = 0; i < Nodes; i++)
        {
            for (int j = 0; j < Nodes; j++)
            {
                ResultMatrix[i][j] = InputMatrix[i][j] + InputMatrix2[j][i];
            }
        }
        return ResultMatrix;
    }
    /**
     * Multiplies two matricies into a resulting matrix and returns it.
     * @param InputMatrix The matrix to be Inputted
     * @param Matrix The second matrix to be inputted
     */
    public static int[][] MultiplyMatrix(int[][] InputMatrix, int[][]Matrix)
    {
        int Nodes = InputMatrix.length;
        int[][] ResultMatrix = new int[Nodes][Nodes];

        for (int i = 0; i < Nodes; i++)
        {
            for (int j = 0; j < Nodes; j++)
            {
                for (int k = 0; k < Nodes; k++)
                {
                    ResultMatrix[i][j] += (InputMatrix[i][k] * Matrix[k][j]);
                }
            }
        }
        return ResultMatrix;
    }
    /**
     * Counts the in-degrees of the input matrix.
     * @param InputMatrix The matrix to be Inputted
     */
    public static void InDegree(int[][] InputMatrix)
    {
        int Nodes = InputMatrix.length;
        int InDegree = 0;

        for (int i = 0; i < Nodes; i++)
        {
            InDegree = 0;
            for (int j = 0; j < InputMatrix[i].length; j++)
            {
                if(InputMatrix[j][i] == 1)
                {
                    InDegree++;
                }
            }
            System.out.println("Node " + (i+1) + " In-Degree is: " + InDegree);
        }
    }
    /**
     * Counts the out-degrees of the input matrix.
     * @param InputMatrix The matrix to be Inputted
     */
    public static void OutDegree(int[][] InputMatrix)
    {
        int Nodes = InputMatrix.length;
        int OutDegree = 0;

        for (int i = 0; i < Nodes; i++)
        {
            OutDegree = 0;
            for (int j = 0; j < InputMatrix[i].length; j++)
            {
                if(InputMatrix[j][i] == 1)
                {
                    OutDegree++;
                }
            }
            System.out.println("Node " + (i+1) + " Out-Degree is: " + OutDegree);
        }
    }

    /**
     * Counts the number of loops within the input matrix.
     * @param InputMatrix The matrix to be Inputted
     */
    public static void LoopTotal(int[][] InputMatrix)
    {
        int Nodes = InputMatrix.length;
        int NumLoops = 0;

        for (int i = 0; i < Nodes; i++)
        {
            if(InputMatrix[i][i] == 1)
            {
                NumLoops++;
            }
        }
        System.out.println("\nTotal number of self loops: " + NumLoops);
    }
    /**
     *  Counts the number of cycles after calculating the nth power.
     * @param InputMatrix The matrix to be Inputted
     */
    public static void CycleTotal(int[][] InputMatrix)
    {
        int Nodes = InputMatrix.length;
        int CycleTotal = 0;

        // Raised to nth power
        int[][] RaisedPwrMatrix = InputMatrix.clone();
        for (int i = 1; i < Nodes; i++)
        {
            RaisedPwrMatrix = MultiplyMatrix(RaisedPwrMatrix, InputMatrix);
        }

        for (int i = 0; i < Nodes; i++)
        {
           CycleTotal += RaisedPwrMatrix[i][i];
        }
        System.out.println("Total number of cycles for length " + Nodes + " edges: " + CycleTotal);
    }

    /**
     * Paths to length 1 of the input matrix.
     * @param InputMatrix The matrix to be Inputted
     */
    public static void PathToOne(int[][] InputMatrix)
    {
        int Nodes = InputMatrix.length;
        int NumPaths = 0;

        for (int i = 0; i < Nodes; i++)
        {
            for (int j = 0; j < Nodes; j++)
            {
                NumPaths += InputMatrix[i][j];
            }
        }
        System.out.println("Total number of paths for length 1 edge: " + NumPaths);
    }

    /**
     * Total paths of nth size on the matrix.
     * @param InputMatrix The matrix to be Inputted
     */
    public static void PathTotal(int[][] InputMatrix)
    {
        int Nodes = InputMatrix.length;
        int NumPaths = 0;

        int[][]  RaisedPwrMatrix = InputMatrix.clone();
        for (int i = 1; i < Nodes; i++)
        {
            RaisedPwrMatrix = MultiplyMatrix(RaisedPwrMatrix, InputMatrix);
        }

        for (int i = 0; i < Nodes; i++)
        {
            for (int j = 0; j < Nodes; j++)
            {
                NumPaths += RaisedPwrMatrix[i][j];
            }
        }
        System.out.println("Total number of paths for length " + Nodes + " edge: " + NumPaths);
    }
    /**
     * Total paths from 1 to nth size on the matrix.
     * @param InputMatrix The matrix to be Inputted
     */
    public static void Path1toN(int[][] InputMatrix)
    {
        int Nodes = InputMatrix.length;
        int NumPaths = 0;

        for (int i = 0; i < Nodes; i++)
        {
            for (int j = 0; j < Nodes; j++)
            {
                NumPaths += InputMatrix[i][j];
            }
        }
        System.out.println("Total number of paths for length 1 to " + Nodes + " edges: " + NumPaths);
    }
    /**
     * Total cycles from 1 to nth size on the matrix.
     * @param InputMatrix The matrix to be Inputted
     */
    public static void Cycle1toN(int[][] InputMatrix)
    {
        int Nodes = InputMatrix.length;
        int CyclesNum = 0;

        for (int i = 0; i < Nodes; i++)
        {
            CyclesNum += InputMatrix[i][i];
        }
        System.out.println("Total number of cycles for length 1 to " + Nodes + " edges: " + CyclesNum);
    }
}
