package algorithms.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2 Output: 2 Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step 
 * 2. 2 steps 
 * 
 * Example 2:
 *
 * Input: n = 3 Output: 3 Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step 
 * 2. 1 step + 2 steps 
 * 3. 2 steps + 1 step
 *
 *
 * Constraints:
 *
 * 1 <= n <= 45
 */
/**
 * Approach: We can use dynamic programming to solve this problem. The idea is
 * to build up the number of ways to climb to the ith step based on the number
 * of ways to reach the (i-1)th step and the (i-2)th step. This is based on the
 * observation that to get to the ith step, you can come from either the (i-1)th
 * or the (i-2)th step.
 *
 * The recursive relation can be defined as: dp[i] = dp[i-1] + dp[i-2]
 *
 * Complexity: Time Complexity: O(n) - We calculate the number of ways for each
 * step from 1 to n. Space Complexity: O(1) - We can reduce the space complexity
 * to O(1) by only storing the last two results.
 */
public class ClimbStairs {

    public static int climbStairs(int n) {
        // Time complex = O(n); Space Complexity = O(n)
        int[] dp = new int[n + 1];

        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]);
        }
        return dp[n];
    }

    public static int climbStairsRecursion(int n) {
        // Time complex = O(2n); Space Complexity = O(n)
        if (n == 0 || n == 1) {
            return 1;
        }
        return climbStairsRecursion(n - 1) + climbStairsRecursion(n - 2);
    }

    public static int climbStairsRecursionMem(int n) {
        Map<Integer, Integer> mem = new HashMap<>();

        return climbStairsRecursionMemHelper(n, mem);
    }

    public static int climbStairsRecursionMemHelper(int n, Map<Integer, Integer> mem) {
        // Time complex = O(n); Space Complexity = O(n)
        if (n == 0 || n == 1) {
            return 1;
        }
        if (mem.containsKey(n)) {
            return mem.get(n);
        }
        int i = climbStairsRecursion(n - 1) + climbStairsRecursion(n - 2);
        mem.put(n, i);
        return i;
    }

    public static void main(String[] args) {
        // Case 1 
        System.out.println("Case 1 \n"
                + "Input 2\n"
                + "Result: " + climbStairs(2) + "\n"
                + "Expected 2");

        // Case 2 
        System.out.println("Case 2 \n"
                + "Input 3\n"
                + "Result: " + climbStairs(3) + "\n"
                + "Expected 3");

        // Case 3
        System.out.println("Case 3 \n"
                + "Input 1\n"
                + "Result: " + climbStairs(1) + "\n"
                + "Expected 1");

        // Case 4 
        System.out.println("Case 4 \n"
                + "Input 45\n"
                + "Result: " + climbStairs(45) + "\n"
                + "Expected ?");
    }
}
