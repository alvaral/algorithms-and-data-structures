package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Permutations {

    /*
 Given an array nums of distinct integers, return all the possible 
permutations.
You can return the answer in any order.

 

>Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

>Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]

>Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
     */
// Input: nums = [1,2,3]
// Output: [
//          [1,2,3], [1,3,2],
//          [2,1,3], [2,3,1],
//          [3,1,2], [3,2,1],
//          ]
    public static List<List<Integer>> permutate(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        backtracking(nums, list, 0);
        return list;
    }

    private static void backtracking(int[] nums, List<List<Integer>> list,
            int start) {
        if (start == nums.length) {
            // Add a copy of the current permutation to the result list
            list.add(
                    new ArrayList<>(
                            IntStream.of(nums) //  creates a stream of int
                                    .boxed() // Converts each int to its corresponding Integer
                                    .collect(Collectors.toList()) // accumulates the elements of the stream into a List
                    )
            );
        } else {
            for (int i = start; i < nums.length; i++) {
                // Swap the current element with the start element
                swap(nums, i, start);

                // Recur to generate permutations for the next position
                backtracking(nums, list, start + 1);

                // Backtrack (undo the swap to restore original array state)
                swap(nums, i, start);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        // case1 
        int[] nums1 = {1, 2, 3};

        List<List<Integer>> sol1 = permutate(nums1);
        System.out.println("Case 1 \n"
                + "Input: [1,2,3]\n"
                + "Output: " + sol1.toString()
                + "\nExpected: [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]]");
    }
}
