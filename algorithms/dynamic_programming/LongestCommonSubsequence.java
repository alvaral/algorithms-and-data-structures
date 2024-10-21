package algorithms.dynamic_programming;

public class LongestCommonSubsequence {
    
    // Main function with test cases
    public static void main(String[] args) {
        // Test cases to verify the solution
        System.out.println(longestCommonSubsequence("abcde", "ace")); // Output: 3
        System.out.println(longestCommonSubsequence("abc", "abc"));   // Output: 3
        System.out.println(longestCommonSubsequence("abc", "def"));   // Output: 0
    }

    /* 
     * Approach:
     * Use dynamic programming (DP) to solve the problem. 
     * We'll create a 2D array `dp` where dp[i][j] represents 
     * the length of the longest common subsequence of the 
     * first `i` characters of text1 and the first `j` characters 
     * of text2.
     * 
     * Algorithm:
     * 1. If the characters match, we increment the value from dp[i-1][j-1].
     * 2. If they don't match, we take the maximum of dp[i-1][j] and dp[i][j-1].
     * 3. The result is stored in dp[text1.length][text2.length].
     * 
     * Time Complexity: O(m * n), where m and n are the lengths 
     * of text1 and text2 respectively. 
     * Space Complexity: O(m * n) due to the 2D DP array.
     * 
     * Graphic example:
     * Input: "abcde", "ace";  Output: 3
     * [[0, 0, 0, 0], 
     * [0, 1, 1, 1], 
     * [0, 1, 1, 1], 
     * [0, 1, 2, 2], 
     * [0, 1, 2, 2], 
     * [0, 1, 2, 3]]

     */

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // DP array to store the lengths of longest common subsequence
        int[][] dp = new int[m + 1][n + 1];

        // Build the DP array from bottom up
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Return the result from the last cell of the DP table
        return dp[m][n];
    }
}
