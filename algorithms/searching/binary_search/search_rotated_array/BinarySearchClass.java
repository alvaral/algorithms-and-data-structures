package search_rotated_array;

/**
There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot 
index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], 
..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). 

For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become 
[4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the 
index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

 
Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104
 */

public class BinarySearchClass {

    // Binary search: low = index 0, high = length - 1
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2; // calculate mid

            if (nums[mid] == target) {
                return mid;
            } 
            // Determine which part is (right or left)
            if (nums[left] <= nums[mid]) { // left side
                if (nums[left] <= target && target <= nums[mid]) { 
                    // target in zone
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // right side
                if (nums[mid] <= target && target <= nums[right]) {
                    // target in zone
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;        
    }
    public static void main(String[] args) {
        BinarySearchClass searcher = new BinarySearchClass();

        // Test case 1
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        System.out.println("Output for case 1: " + searcher.search(nums1, target1)); // Expected output: 4

        // Test case 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        System.out.println("Output for case 2: " + searcher.search(nums2, target2)); // Expected output: -1

        // Test case 3
        int[] nums3 = {1};
        int target3 = 0;
        System.out.println("Output for case 3: " + searcher.search(nums3, target3)); // Expected output: -1
    }
}
