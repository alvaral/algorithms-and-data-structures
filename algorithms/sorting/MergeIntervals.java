package algorithms.sorting;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all
 * overlapping intervals, and return an array of the non-overlapping intervals
 * that cover all the intervals in the input.
 *
 *  *Example 1:
 *
 *  *Input: intervals = [[1,3],[2,6],[8,10],[15,18]] Output:
 * [[1,6],[8,10],[15,18]] Explanation: Since intervals [1,3] and [2,6] overlap,
 * merge them into [1,6].
 *
 *  *Example 2:
 *
 * Input: intervals = [[1,4],[4,5]] Output: [[1,5]] Explanation: Intervals [1,4]
 * and [4,5] are considered overlapping. * Constraints:
 *
 * - 1 <= intervals.length <= 104 - intervals[i].length == 2 - 0 <= starti <=
 * endi <= 104
 *
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        // sort array
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // initialize variables
        List<int[]> merged = new ArrayList<>();

        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (prev[1] >= intervals[i][0]) { // overlaps
                prev[1] = Math.max(prev[1], intervals[i][1]); // if one interval eat anotherone
            } else { // doesnt overlap
                merged.add(prev);
                prev = intervals[i];
            }
        }

        merged.add(prev);
        return merged.toArray(new int[merged.size()][]);

    }

    public static void main(String[] args) {
        // Prueba 1
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] expected1 = {{1, 6}, {8, 10}, {15, 18}};

        System.out.println("Input: " + Arrays.deepToString(intervals1));
        int[][] result1 = merge(intervals1);
        System.out.println("Result: " + Arrays.deepToString(result1));
        System.out.println("Expected: " + Arrays.deepToString(expected1));
        System.out.println(resultCheck(result1, expected1) ? "Test passed\n" : "Test failed\n");

        // Prueba 2
        int[][] intervals2 = {{1, 4}, {4, 5}};
        int[][] expected2 = {{1, 5}};

        System.out.println("Input: " + Arrays.deepToString(intervals2));
        int[][] result2 = merge(intervals2);
        System.out.println("Result: " + Arrays.deepToString(result2));
        System.out.println("Expected: " + Arrays.deepToString(expected2));
        System.out.println(resultCheck(result2, expected2) ? "Test passed\n" : "Test failed\n");

        // Prueba 2
        int[][] intervals3 = {{1, 6}, {4, 5}};
        int[][] expected3 = {{1, 6}};

        System.out.println("Input: " + Arrays.deepToString(intervals2));
        int[][] result3 = merge(intervals3);
        System.out.println("Result: " + Arrays.deepToString(result3));
        System.out.println("Expected: " + Arrays.deepToString(expected3));
        System.out.println(resultCheck(result3, expected3) ? "Test passed\n" : "Test failed\n");
    }

    // Método para comparar los resultados
    public static boolean resultCheck(int[][] result, int[][] expected) {
        if (result.length != expected.length) {
            return false;
        }
        for (int i = 0; i < result.length; i++) {
            if (!Arrays.equals(result[i], expected[i])) {
                return false;
            }
        }
        return true;

    }
}
