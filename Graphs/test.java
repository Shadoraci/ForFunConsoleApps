public class test {

    public static void main(String[] args) {
        // Test 1: 2-node adjacency matrix
        int[][] adjacencyMatrix2 = {
                {1, 1},
                {1, 1}
        };
        System.out.println("Test 1:");
        testCycleCount(adjacencyMatrix2);

        // Test 2: 3-node adjacency matrix
        int[][] adjacencyMatrix3 = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        System.out.println("\nTest 2:");
        testCycleCount(adjacencyMatrix3);
    }

    public static void testCycleCount(int[][] adjacencyMatrix) {
        int nodes = adjacencyMatrix.length;

        // Compute A^N
        int[][] poweredMatrix = matrixExponentiation(adjacencyMatrix, nodes);

        // Calculate total cycles using CycleTotal
        CycleTotal(poweredMatrix);
    }

    public static void CycleTotal(int[][] InputMatrix) {
        int Nodes = InputMatrix.length;
        int CycleTotal = 0;

        for (int i = 0; i < Nodes; i++) {
            CycleTotal += InputMatrix[i][i]; // Sum diagonal elements
        }

        System.out.println("Total number of cycles for length " + Nodes + " edges: " + CycleTotal);
    }

    public static int[][] matrixExponentiation(int[][] matrix, int power) {
        int n = matrix.length;
        int[][] result = new int[n][n];

        // Initialize result as identity matrix
        for (int i = 0; i < n; i++) {
            result[i][i] = 1;
        }

        int[][] base = matrix;

        while (power > 0) {
            if (power % 2 == 1) {
                result = multiplyMatrices(result, base);
            }
            base = multiplyMatrices(base, base);
            power /= 2;
        }

        return result;
    }

    public static int[][] multiplyMatrices(int[][] a, int[][] b) {
        int n = a.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }
}