package algorithms.dynamic_programming;

import java.util.Arrays;

/*
 You are a professional robber planning to rob houses along a street. 
 Each house has a certain amount of money stashed, the only constraint stopping you 
 from robbing each of them is that adjacent houses have security systems connected and 
 it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount
 of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400
 */

 /*Example:
  nums = [2,7,9,3,1]
  dp = [2, 7, 11, 11, 12 ] 
  
  approach:
  Dynamic programming algorithm
    - use an array dp[n] to save the best cases
    - root cases -> dp[0] and dp[1]
    - in the other cases compare what is better, ir rob the actual house (nums[i]+dp[i-2]) or not (dp[i-1])
    - return its last case (dp[n-1])


    Complexity time: O(n) : iterating through n
    Complexity space: O(n): array of n
 */
public class HouseRobber {

    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int[] dp = new int[n];

        // root cases
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // see the other cases
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(
                    (dp[i - 2] + nums[i]), // robbing the house 
                    dp[i - 1] // not robbing the house
            );
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        // case 1 
        int[] nums1 = {2, 7, 9, 3, 1};
        System.out.println("Input " + Arrays.toString(nums1));
        System.out.println("Output: " + rob(nums1)); // expected 12

        // case 2 
        int[] nums2 = {2};
        System.out.println("Input " + Arrays.toString(nums2));
        System.out.println("Output: " + rob(nums2)); // expected 2
    }

}
