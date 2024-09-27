package algorithms.searching;

import java.util.Arrays;

/*
Given an array of integers nums which is sorted in ascending order, 
and an integer target, write a function to search target in nums. 
If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.


Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4


Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
 

Constraints:

  1 <= nums.length <= 104
  -104 < nums[i], target < 104
  All the integers in nums are unique.
  nums is sorted in ascending order.

 */
public class BinarySearch {

    static public int search(int[] nums, int target) {
        // O(log n) => Binary Search
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1; // the new right is the num in the left of mid                
            } else if (target > nums[mid]) {
                left = mid + 1; // new min is the number in the right of mid
            }
        }
        // no answer => target doesnt exist
        return -1;
    }

    public static void main(String[] args) {

        // Test case 1: Target exists
        int[] nums1 = {-1, 0, 3, 5, 9, 12};
        int target1 = 9;
        int result1 = search(nums1, target1);
        System.out.println("Input: " + Arrays.toString(nums1) + ", Target: " + target1);
        System.out.println("Expected: 4, Actual: " + result1);
        System.out.println();

        // Test case 2: Target does not exist
        int[] nums2 = {-1, 0, 3, 5, 9, 12};
        int target2 = 2;
        int result2 = search(nums2, target2);
        System.out.println("Input: " + Arrays.toString(nums2) + ", Target: " + target2);
        System.out.println("Expected: -1, Actual: " + result2);
        System.out.println();

        // Test case 3: Target is the first element
        int[] nums3 = {-1, 0, 3, 5, 9, 12};
        int target3 = -1;
        int result3 = search(nums3, target3);
        System.out.println("Input: " + Arrays.toString(nums3) + ", Target: " + target3);
        System.out.println("Expected: 0, Actual: " + result3);
        System.out.println();

        // Test case 4: Target is the last element
        int[] nums4 = {-1, 0, 3, 5, 9, 12};
        int target4 = 12;
        int result4 = search(nums4, target4);
        System.out.println("Input: " + Arrays.toString(nums4) + ", Target: " + target4);
        System.out.println("Expected: 5, Actual: " + result4);
        System.out.println();

        // Test case 5: Empty array
        int[] nums5 = {};
        int target5 = 1;
        int result5 = search(nums5, target5);
        System.out.println("Input: " + Arrays.toString(nums5) + ", Target: " + target5);
        System.out.println("Expected: -1, Actual: " + result5);
    }
}
