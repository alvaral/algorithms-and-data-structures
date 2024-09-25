package robot_grid_validator;
/*
Given a grid of robot positions, indicate if it is a valid time series for the number of robots specified 
if robots can only travel up to 1 index further than their position 1 step before.

Input format: an array of arrays, of which each index can be 0 or 1. 
An index corresponds to the physical location which is either occupied by a robot (1) or empty (0)

Ex:
Grid: [[1,0,0,1], [0,1,1,0]] is a valid time series for 2 robots because the first robot moved from 
index 0 to index 1 and robot 2 moved from index 3 to index 2.

Grid: [[1,0,0,0,1],[1,0,1,0,0] is not valid because the second robot started at index 4 but did not 
have a valid position on the next step
*/

public class RobotGridValidatorClass {

    // SOLUTION 1: Not optimal solution (but correct) Complexity: O(nxm)
    public static boolean isValidPath(int numRobots, int[][] grid) {

        // Check if num robots are correct
        for (int[] row : grid) {
            int rowRobots = 0;
            for (int i = 0; i < row.length; i++) {
                if (row[i] == 1) {
                    rowRobots++;
                }
            }
            if (numRobots != rowRobots) {
                return false;
            }
        }

        // Check if the positions are correct comparing to the previous row
        int[] robotIndecesCur = getRobotIndices(grid[0], numRobots);

        for (int row = 1; row < grid.length; row++) {
            int[] robotIndicesNext = getRobotIndices(grid[row], numRobots);
            if (!validPath(robotIndecesCur, robotIndicesNext)) {
                return false;
            }
            robotIndecesCur = robotIndicesNext;
        }
        return true;
    }

    public static int[] getRobotIndices(int[] row, int numRobots) {
        int[] robotIndices = new int[numRobots];
        int currentRobot = 0;
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 1) {
                robotIndices[currentRobot++] = i;
            }
        }
        return robotIndices;
    }

    public static boolean validPath(int[] currentPositions, int[] nextPositions) {
        for (int i = 0; i < currentPositions.length; i++) {
            int step = Math.abs(currentPositions[i] - nextPositions[i]);
            if (step != 1) {
                return false;
            }
        }
        return true;
    }

    // SOLUTION 2:  Method to validate if the robot grid is valid
    public static boolean isValidPathOptimal(int numRobots, int[][] grid) {
        // Iterate through all rows in the grid
        for (int row = 0; row < grid.length; row++) {
            int rowRobots = 0; // Counter for robots in the current row

            // Iterate through each column in the current row
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) { // If a robot is present at this position
                    rowRobots++; // Increment the robot count for this row

                    // Check if this is not the first row, so we can validate the movement
                    if (row > 0) {
                        boolean validMove = false; // Flag to check if the move is valid

                        // Check if the robot could have moved from the left, same position, or right
                        if (col > 0 && grid[row - 1][col - 1] == 1) { // Left
                            validMove = true;
                        } else if (grid[row - 1][col] == 1) { // Same position
                            validMove = true;
                        } else if (col < grid[row].length - 1 && grid[row - 1][col + 1] == 1) { // Right
                            validMove = true;
                        }

                        // If none of the moves are valid, return false
                        if (!validMove) {
                            return false;
                        }
                    }
                }
            }

            // Check if the number of robots in the current row matches the expected count
            if (rowRobots != numRobots) {
                return false; // The number of robots does not match the expected value
            }
        }

        return true; // Return true if all rows are valid
    }

    public static void main(String[] args) {
        // Ex 1: valid
        int[][] grid1 = {
                { 1, 0, 0, 1 },
                { 0, 1, 1, 0 }
        };
        System.out.println(isValidPath(2, grid1)); // true

        // Ex 2: Not valid
        int[][] grid2 = {
                { 1, 0, 0, 0, 1 },
                { 1, 0, 1, 0, 0 }
        };
        System.out.println(isValidPathOptimal(2, grid2)); // false
   
        int[][] grid3 = {
            { 1, 0, 0, 0, 1 },
            { 1, 1, 0, 1, 1 }
        };
        System.out.println(isValidPathOptimal(2,grid3)); // false
    }

}