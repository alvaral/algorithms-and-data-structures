package data_structures.trees.binary_tree_level_order;


/*
 Given the root of a binary tree, return the level order traversal of its nodes' values. 
 (i.e., from left to right, level by level).

 Example 1:
        3 (graph explainatory)
       / \
      9   20
         /  \
        15   7

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]


Example 2:

Input: root = [1]
Output: [[1]]


Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
 */

 /*
 Definition for a binary tree node.
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
 */
import java.util.ArrayList;
import java.util.List;

class BinaryTreeLevelOrderTraversalClass {

    // SOLUTION BFS (Breadth-First Search)
    public List<List<Integer>> levelOrder(TreeNode root) {
        final List<List<Integer>> solution = new ArrayList<>();
        visitLevel(root, solution, 1);
        return solution;
    }

    private void visitLevel(TreeNode root, List<List<Integer>> solution, int level) {
        if (root == null) {
            return;
        }

        if (solution.size() < level) {
            solution.add(new ArrayList<>());
        }

        solution.get(level - 1).add(root.val);

        level++;
        visitLevel(root.left, solution, level);
        visitLevel(root.right, solution, level);

    }

    // Main method to test the levelOrder method
    // Helper function to print the actual and expected output
    private static void printTestResult(String testCase, List<List<Integer>> actual, String expected) {
        System.out.println(testCase);
        System.out.println("Actual:   " + actual);
        System.out.println("Expected: " + expected);
        System.out.println();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Normal binary tree
        BinaryTreeLevelOrderTraversalClass root1 = new BinaryTreeLevelOrderTraversalClass(3);
        root1.left = new BinaryTreeLevelOrderTraversalClass(9);
        root1.right = new BinaryTreeLevelOrderTraversalClass(20);
        root1.right.left = new BinaryTreeLevelOrderTraversalClass(15);
        root1.right.right = new BinaryTreeLevelOrderTraversalClass(7);
        List<List<Integer>> result1 = solution.levelOrder(root1);
        String expected1 = "[[3], [9, 20], [15, 7]]";
        printTestResult("Test case 1", result1, expected1);

        // Test case 2: Single node tree
        BinaryTreeLevelOrderTraversalClass root2 = new BinaryTreeLevelOrderTraversalClass(1);
        List<List<Integer>> result2 = solution.levelOrder(root2);
        String expected2 = "[[1]]";
        printTestResult("Test case 2", result2, expected2);

        // Test case 3: Empty tree
        BinaryTreeLevelOrderTraversalClass root3 = null;
        List<List<Integer>> result3 = solution.levelOrder(root3);
        String expected3 = "[]";
        printTestResult("Test case 3", result3, expected3);

        // Test case 4: Left-skewed tree (each node has only a left child)
        BinaryTreeLevelOrderTraversalClass root4 = new BinaryTreeLevelOrderTraversalClass(1);
        root4.left = new BinaryTreeLevelOrderTraversalClass(2);
        root4.left.left = new BinaryTreeLevelOrderTraversalClass(3);
        root4.left.left.left = new BinaryTreeLevelOrderTraversalClass(4);
        List<List<Integer>> result4 = solution.levelOrder(root4);
        String expected4 = "[[1], [2], [3], [4]]";
        printTestResult("Test case 4", result4, expected4);

        // Test case 5: Right-skewed tree (each node has only a right child)
        BinaryTreeLevelOrderTraversalClass root5 = new BinaryTreeLevelOrderTraversalClass(1);
        root5.right = new BinaryTreeLevelOrderTraversalClass(2);
        root5.right.right = new BinaryTreeLevelOrderTraversalClass(3);
        root5.right.right.right = new BinaryTreeLevelOrderTraversalClass(4);
        List<List<Integer>> result5 = solution.levelOrder(root5);
        String expected5 = "[[1], [2], [3], [4]]";
        printTestResult("Test case 5", result5, expected5);
    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, BinaryTreeLevelOrderTraversalClass left, BinaryTreeLevelOrderTraversalClass right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
