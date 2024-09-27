package data_structures.hash_maps;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target. You may assume that each input
 * would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 *
 *
 *  *Example 1:
 *
 *  *Input: nums = [2,7,11,15], target = 9 Output: [0,1] Explanation: Because
 * nums[0] + nums[1] == 9, we return [0, 1]. Example 2:
 *
 *  *Input: nums = [3,2,4], target = 6 Output: [1,2] Example 3:
 *
 *  *Input: nums = [3,3], target = 6 Output: [0,1]
 *
 *
 *  *Constraints:
 *
 *  *2 <= nums.length <= 104 -109 <= nums[i] <= 109 -109 <= target <= 109 Only
 * one valid answer exists.
 *
 *
 *  *Follow-up: Can you come up with an algorithm that is less than O(n2) time
 * complexity?
 */
public class TwoSumsClass {

    public int[] twoSumForceBruteSolution(int[] nums, int target) {

        int[] sol = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && target == nums[j] + nums[i]) {
                    sol[0] = i;
                    sol[1] = j;
                }
            }
        }
        return sol;
    }

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int rest = target - nums[i];
            if (hash.containsKey(rest)) {
                return new int[]{hash.get(rest), i};
            }
            hash.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSumsClass twoSums = new TwoSumsClass();

        // Test Case 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = twoSums.twoSum(nums1, target1);
        System.out.println("Test Case 1: " + Arrays.toString(result1) + " Expected output: [0, 1]"); // Expected output: [0, 1]

        // Test Case 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = twoSums.twoSum(nums2, target2);
        System.out.println("Test Case 2: " + Arrays.toString(result2) + " Expected output: [1, 2]"); // Expected output: [1, 2]

        // Test Case 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = twoSums.twoSum(nums3, target3);
        System.out.println("Test Case 3: " + Arrays.toString(result3) + " Expected output: [0, 1]"); // Expected output: [0, 1]

        // Test Case 4 - Exception case
        try {
            int[] nums4 = {1, 2, 3};
            int target4 = 7;
            twoSums.twoSum(nums4, target4);
        } catch (IllegalArgumentException e) {
            System.out.println("Test Case 4: " + e.getMessage()); // Expected output: "No two sum solution"
        }
    }
}
