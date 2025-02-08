// Name: Jack Vega
// Class: CS 3305/01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 9
// IDE Name: Intellij

import java.util.Scanner; // Import the Scanner class for reading input

public class JReach
{
    public static void main(String[] s) {
        Scanner sc = new Scanner(System.in); // Create a Scanner object for user input
        int choice = 0; // Variable to store the user's menu choice
        int[][] matrix = null;

        // Main loop to display the menu and perform actions based on user choice
        do {
            // Display the menu options
            System.out.print("""
                    \n---------MAIN MENU--------
                    1. Enter graph data
                    2. Print outputs
                    3. Exit program
                    
                    Enter option number: \
                    """);

            try {
                // Read and parse the user's choice
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid choice, please try again!");
                continue;
            }

            if (choice != 1 && matrix == null) {
                System.out.println("No data entered, please enter the required data before trying any other options!");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount of nodes: ");
                    int node_count = Integer.parseInt(sc.nextLine());
                    matrix = new int[node_count][node_count];

                    for (int row = 0; row < node_count; row++) {
                        for (int col = 0; col < node_count; col++) {
                            System.out.print("Enter A1[" + row + ", " + col + "]: ");
                            matrix[row][col] = Integer.parseInt(sc.nextLine());
                        }
                        System.out.println("...");
                    }

                    break;

                case 2:
                    System.out.println("Input Matrix: ");
                    printMatrix(matrix);

                    System.out.println("\nReachability Matrix: ");
                    printMatrix(reachabilityMatrix(matrix));

                    System.out.println();
                    computeDegrees(matrix);

                    System.out.println("\nTotal number of self-loops: " + countSelfLoops(matrix));
                    System.out.println("Total number of cycles of length " + matrix.length + " edges: " + countCyclesOfLengthN(matrix, matrix.length));
                    System.out.println("Total number of paths of length 1 edge: " + countPathsOfLength(matrix, 1));
                    System.out.println("Total number of paths of length " + matrix.length + " edges: " + countPathsOfLength(matrix, matrix.length));
                    System.out.println("Total number of paths of length 1 to " + matrix.length + " edges: " + countPathsOfLength1ToN(matrix));
                    System.out.println("Total number of cycles of length 1 to " + matrix.length + " edges: " + countCyclesOfLength1ToN(matrix));
                    break;

                case 3: // Exit program
                    break;
                default:
                    System.out.println("Invalid choice, please try again!"); // Handle invalid menu choices
                    break;
            }
        } while (choice != 3); // Continue loop until user chooses to exit

        sc.close(); // Close the scanner
    }

    /**
     * Prints the given matrix to the console in a readable format.
     *
     * @param matrix The matrix to be printed.
     */
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Multiplies two matrices and returns the result.
     *
     * @param A1 The first matrix.
     * @param A2 The second matrix.
     * @return The result of multiplying A1 and A2.
     */
    public static int[][] multipleMatrix(int[][] A1, int[][] A2) {
        int L1 = A1[0].length;
        int L2 = A2.length;

        if (L1 != L2)
            return null;

        int[][] result = new int[L1][L2];

        for (int row = 0; row < L1; row++) {
            for (int col = 0; col < L2; col++) {
                for (int k = 0; k < L2; k++) {
                    result[row][col] += A1[row][k] * A2[k][col];
                }

            }
        }

        return result;
    }

    /**
     * Adds two matrices and returns the result.
     *
     * @param A1 The first matrix.
     * @param A2 The second matrix.
     * @return The result of adding A1 and A2.
     */
    public static int[][] addMatrix(int[][] A1, int[][] A2) {
        int[][] result = new int[A1[0].length][A2.length];

        for (int row = 0; row < A1[0].length; row++) {
            for (int col = 0; col < A2.length; col++) {
                result[row][col] = A1[row][col] + A2[row][col];
            }
        }

        return result;
    }

    /**
     * Computes the reachability matrix for the given adjacency matrix.
     *
     * @param matrix The adjacency matrix of the graph.
     * @return The reachability matrix.
     */
    public static int[][] reachabilityMatrix(int[][] matrix) {
        int size = matrix.length;
        int[][] result = matrix.clone();

        // This outer for-loop is like setting up the addition of A1+A2+A3+...+An etc
        for (int i = 1; i < size; i++) {
            int[][] raisedMatrix = matrix.clone();

            // this inner for-loop is for actually creating A2 or A3 ... or An
            for (int k = 0; k < i; k++) {
                raisedMatrix = multipleMatrix(raisedMatrix, matrix);
            }

            // now we add up A1 and A2 or everything before A4 as well as A4
            result = addMatrix(result, raisedMatrix);
        }

        return result;
    }

    /**
     * Computes and prints the in-degrees and out-degrees for each node.
     *
     * @param matrix The adjacency matrix of the graph.
     */
    public static void computeDegrees(int[][] matrix) {
        int n = matrix.length;
        System.out.println("In-degrees:");
        for (int col = 0; col < n; col++) {
            int inDegree = 0;
            for (int row = 0; row < n; row++) {
                inDegree += matrix[row][col]; // Sum of values in the column
            }
            System.out.println("Node " + (col + 1) + " in-degree is " + inDegree);
        }

        System.out.println("\nOut-degrees:");
        for (int row = 0; row < n; row++) {
            int outDegree = 0;
            for (int col = 0; col < n; col++) {
                outDegree += matrix[row][col]; // Sum of values in the row
            }
            System.out.println("Node " + (row + 1) + " out-degree is " + outDegree);
        }
    }

    /**
     * Counts the number of self-loops in the graph.
     * A self-loop occurs when a node has an edge to itself.
     *
     * @param matrix The adjacency matrix of the graph.
     * @return The total number of self-loops in the graph.
     */
    public static int countSelfLoops(int[][] matrix) {
        int loops = 0;
        // Count diagonal elements, which represent self-loops
        for (int i = 0; i < matrix.length; i++) {
            loops += matrix[i][i];
        }
        return loops;
    }

    /**
     * Counts the number of cycles of a specified length (n) in the graph.
     *
     * @param matrix The adjacency matrix of the graph.
     * @param n      The length of the cycles to count.
     * @return The total number of cycles of the specified length in the graph.
     */
    public static int countCyclesOfLengthN(int[][] matrix, int n) {
        // Calculate the nth power of the adjacency matrix
        int[][] powerMatrix = matrix.clone();
        for (int i = 1; i < n; i++) {
            powerMatrix = multipleMatrix(powerMatrix, matrix);
        }

        // Count diagonal elements in the resulting matrix
        int cycles = 0;
        for (int i = 0; i < n; i++) {
            cycles += powerMatrix[i][i];
        }
        return cycles;
    }

    /**
     * Counts the total number of paths of a specified length in the graph.
     *
     * @param matrix The adjacency matrix of the graph.
     * @param length The length of the paths to count.
     * @return The total number of paths of the specified length.
     */
    public static int countPathsOfLength(int[][] matrix, int length) {
        // If length is 1, simply sum all elements of the adjacency matrix
        if (length == 1) {
            int paths = 0;
            for (int[] row : matrix) {
                for (int value : row) {
                    paths += value;
                }
            }
            return paths;
        }

        // Compute the matrix raised to the given length
        int[][] powerMatrix = matrix.clone();
        for (int i = 1; i < length; i++) {
            powerMatrix = multipleMatrix(powerMatrix, matrix);
        }

        // Now sum all the elements together
        int paths = 0;
        for (int[] row : powerMatrix) {
            for (int value : row) {
                paths += value;
            }
        }
        return paths;
    }

    /**
     * Counts the total number of paths of lengths from 1 to n (inclusive) in the graph.
     *
     * @param matrix The adjacency matrix of the graph.
     * @return The total number of paths of lengths from 1 to n.
     */
    public static int countPathsOfLength1ToN(int[][] matrix) {
        // n here is the number of nodes in the graph, so we are really just
        // adding up every value in the reachability matrix
        int[][] reachMatrix = reachabilityMatrix(matrix);

        int totalPaths = 0;
        for (int[] row : reachMatrix) {
            for (int value : row) {
                totalPaths += value;
            }
        }
        return totalPaths;
    }

    /**
     * Counts the total number of cycles of lengths from 1 to n (inclusive) in the graph.
     *
     * @param matrix The adjacency matrix of the graph.
     * @return The total number of cycles of lengths from 1 to n.
     */
    public static int countCyclesOfLength1ToN(int[][] matrix) {
        // n here is the number of nodes in the graph, so we are really just
        // adding up all the diagonal values of the reachability matrix
        int[][] reachMatrix = reachabilityMatrix(matrix);

        int cycles = 0;
        for (int i = 0; i < matrix.length; i++) {
            cycles += reachMatrix[i][i];
        }
        return cycles;
    }

}
