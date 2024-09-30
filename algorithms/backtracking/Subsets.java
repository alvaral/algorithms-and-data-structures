package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique. 
 
 */
public class Subsets {
    // [      
    //          [],             0
    // [1],     [2],    [3],    1
    // [1,2],   [1,3],  [2,3],  2
    // [1,2,3]                  3
    //]

    public static List<List<Integer>> subsets(int[] nums) {
        // initialize variables
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        // call backtrack
        backtrack(nums, list, tempList, 0);

        // return solution
        return list;
    }

    private static void backtrack(int[] nums, List<List<Integer>> list, List<Integer> tempList, int start) {
        // add case to solution
        list.add(new ArrayList<>(tempList));

        // search for new cases
        for (int i = start; i < nums.length; i++) {
            // create new case
            tempList.add(nums[i]);
            // explore new cases with the new case
            backtrack(nums, list, tempList, i + 1);
            // backtrack: remove the last element to explore other subset
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        // case 1:
        int[] nums1 = new int[]{1, 2, 3};
        System.out.println(
                "CASE 1 \n"
                + "Input: [1,2,3]; \n"
                + "print:" + subsets(nums1).toString() + "\n"
                + "expected: " + "[[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]\n");

        // case 2:
        int[] nums2 = new int[]{0};
        System.out.println(
                "CASE 2 \n"
                + "Input: [0]; \n"
                + "print:" + subsets(nums2).toString() + "\n"
                + "expected: " + "[[], [0]]");
    }
}
