package algorithms.graph_algorithms;

/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
 */
class NumberOfIslands {
    // Use Depth First Search (DFS) to explore and mark connected lands
    // Time Complexity: O(m * n), Space Complexity: O(m * n)

    public static void main(String[] args) {
        char[][] grid1 = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        System.out.println("Number of islands: " + new NumberOfIslands().numIslands(grid1));

        char[][] grid2 = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        System.out.println("Number of islands: " + new NumberOfIslands().numIslands(grid2));
    }

    // Main method to count the number of islands
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        int m = grid.length;
        int n = grid[0].length;

        // Traverse each cell in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;  // Found an island, increase count
                    dfs(grid, i, j);  // Mark the entire island as visited
                }
            }
        }
        return numIslands;
    }

    // Helper method for DFS to mark connected lands
    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        // Boundary check and check if it's water
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
            return;
        }

        // Mark the current land as visited (set to '0')
        grid[i][j] = '0';

        // Explore the four directions: up, down, left, right
        dfs(grid, i - 1, j); // Up
        dfs(grid, i + 1, j); // Down
        dfs(grid, i, j - 1); // Left
        dfs(grid, i, j + 1); // Right
    }
}
