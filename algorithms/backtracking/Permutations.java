package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

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
 /*
    * Algorithm Approach:
    * - Use a backtracking algorithm to generate all subsets.
    * - Start with an empty subset and add elements to it one by one, 
    *   keeping track of the current position in the array.
    * - For each element, you have two choices: either include the element in the current subset or exclude it.
    * - Recursively explore both choices and add the resulting subsets to the list.
    * - The base case is when you have processed all elements, at which point you add the current subset to the result.
    * 
    * Time Complexity: O(n!) because we are generating all permutations, and for an array of size n.
    * Space Complexity: O(n) for the recursion stack.
     */
    // * [1] -> backtrack() -> *
    // [1,2]-> backtrack -> [1,3] -> backtrack 
    // [1,2,3]-> add to list
    // [1,3,2]-> add to list
    // * [2] -> backtrack() -> *
    // [2,1]-> backtrack -> [2,3] -> backtrack 
    // [2,1,3]-> add to list
    // [2,3,1]-> add to list
    // * [3] -> backtrack() -> endlist
    // [3,1]-> backtrack -> [3,2] -> backtrack 
    // [3,1,2]-> add to list
    // [3,2,1]-> add to list
    // sol [[1,2,3],[1,3,2],[2,1,3], [2,3,1], [3,1,2], [3,2,1]]
    // Backtracking function to generate permutations
    public static List<List<Integer>> permutate(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, new ArrayList<>());
        return result;
    }

    // Backtracking helper function
    private static void backtrack(int[] nums, List<List<Integer>> result, List<Integer> tempList) {
        // Base case: when the current permutation list has the same size as nums
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));  // Add a copy of the tempList to the result
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) {
                    continue;  // If the number is already in tempList, skip it
                }
                tempList.add(nums[i]);  // Add the current number
                backtrack(nums, result, tempList);  // Recurse with the updated list
                tempList.remove(tempList.size() - 1);  // Remove the last element to backtrack
            }
        }
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
