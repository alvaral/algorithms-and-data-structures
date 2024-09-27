package matrix_compressor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
Developers at Amazon are working on a prototype for a utility that compresses a n x n matrix, 
data, with the help of a compression rate represented by an array, factor.
The utility returns an integer which is the maximum sum of exactly x elements from the matrix 
such that the number of elements taken from the i-th row does not exceed factor[i] for all 
0 ≤ i < n. The utility returns -1 if the compression cannot be performed.
Given array data and factor, find the maximum sum to perform compression under the given 
constraints, or -1 if it is not possible. 

Example. 
Given n = 3, data = [[1, 2, 3], [4, 5, 6], [7, 8, 9]], factor = [1, 2, 1] and x = 2. 
The best choices for each row are (3), (5, 6), and (9), respectively. 
Only x = 2 elements can be chosen. 
The maximum sum of 2 elements is a[2][2] + a[1][2] = 9 + 6 = 15. Return 15. 

Function Description 
Complete the function getMaximumSum in the editor below. The function returns a long integer. 
getMaximumSum has the following parameters: 
- int factor[n]: the rate of compression for each element of data 
- int data[n][n]: the square matrix of data int x: the number of elements to choose 
- int x: number of elements from the matrix that you can sum
Returns possible long int. the maximum sum if the compression or -1 if it is not summable.

parameters: List<List<Integer>> data, List<Integer> factor, int x
 */
public class MatrixCompressorClass {

    // SOLUTION 1 (force brute)
    public static long getMaximumSum(List<Integer> factor, List<List<Integer>> data, int x) {
        int n = data.size();
        List<Integer> solutionList = new ArrayList<>();
        int solution = 0;

        // iterate the rows of data (or the elements of factor)
        for (int i = 0; i < n; i++) {
            List<Integer> row = data.get(i);
            Collections.sort(row, Collections.reverseOrder());
            int maxNums = factor.get(i);
            // add up maxNums elements from the row
            for (int j = 0; j < Math.min(maxNums, row.size()); j++) {
                solutionList.add(row.get(j));

            }
        }

        // sort solution list
        Collections.sort(solutionList, Collections.reverseOrder());

        // Check if we can get x elements
        if (solutionList.size() < x) {
            return -1; // Not enough elements
        }

        // get the maxSum of x elements of solution
        for (int i = 0; i < x; i++) {
            solution += solutionList.get(i);

        }
        return solution;

    }

    // SOLUTION 2  (Heap)
    public static long getMaximumSumHeap(List<Integer> factor, List<List<Integer>> data, int x) {
        int n = data.size();
        long maxSum = 0;
        int totalSelected = 0;

        // Create a max-heap (priority queue)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Iterate through each row
        for (int i = 0; i < n; i++) {
            List<Integer> row = data.get(i);

            // Sort the current row in descending order
            Collections.sort(row, Collections.reverseOrder());

            // Add the top `factor[i]` elements to the max heap
            for (int j = 0; j < Math.min(factor.get(i), row.size()); j++) {
                maxHeap.offer(row.get(j));
            }
        }

        // Extract the largest `x` elements from the max heap
        while (totalSelected < x && !maxHeap.isEmpty()) {
            maxSum += maxHeap.poll(); // Remove the largest element
            totalSelected++;
        }

        // Check if we managed to select exactly `x` elements
        return totalSelected == x ? maxSum : -1;
    }

    public static void main(String[] args) {
        List<List<Integer>> data = new ArrayList<>();
        data.add(Arrays.asList(1, 2, 3));
        data.add(Arrays.asList(4, 5, 6));
        data.add(Arrays.asList(7, 8, 9));

        List<Integer> factor = Arrays.asList(1, 2, 1);
        int x = 2;

        long result = getMaximumSumHeap(factor, data, x);
        System.out.println("Result: " + result + " - Output should be 15"); // Output should be 15

        List<List<Integer>> data2 = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9));
        List<Integer> factor2 = Arrays.asList(2, 2, 2);
        int x2 = 4;

        long result2 = getMaximumSumHeap(factor2, data2, x2);
        System.out.println("Result2: " + result2 + " - Output should be 26 (9+8+6+3)"); // Output debería ser 26
        // (9+8+6+3)

        List<List<Integer>> data3 = Arrays.asList(
                Arrays.asList(-1, -2, -3),
                Arrays.asList(-4, -5, -6),
                Arrays.asList(-7, -8, -9));
        List<Integer> factor3 = Arrays.asList(1, 1, 1);
        int x3 = 3;
        long result3 = getMaximumSumHeap(factor3, data3, x3);
        System.out.println("Result3: " + result3 + " - Output should be -12 (-1 + -4 + -7)");

        List<List<Integer>> data5 = Arrays.asList(
                Arrays.asList(10, 20, 30),
                Arrays.asList(40, 50, 60),
                Arrays.asList(70, 80, 90));
        List<Integer> factor5 = Arrays.asList(0, 0, 0); // No se puede seleccionar ningún elemento
        int x5 = 1;
        long result5 = getMaximumSumHeap(factor5, data5, x5);
        System.out.println("Result5: " + result5 + " - Output should be -1");

    }

}
