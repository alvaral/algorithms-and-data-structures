package data_structures.trees;


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

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversalClass solution = new BinaryTreeLevelOrderTraversalClass();

        // Helper function to print the actual and expected output
        printTestResult("Test Case 1: Normal binary tree",
                solution.levelOrder(buildTree1()), "[[3], [9, 20], [15, 7]]");

        printTestResult("Test Case 2: Single node tree",
                solution.levelOrder(buildTree2()), "[[1]]");

        printTestResult("Test Case 3: Empty tree",
                solution.levelOrder(null), "[]");

        printTestResult("Test Case 4: Left-skewed tree",
                solution.levelOrder(buildLeftSkewedTree()), "[[1], [2], [3], [4]]");

        printTestResult("Test Case 5: Right-skewed tree",
                solution.levelOrder(buildRightSkewedTree()), "[[1], [2], [3], [4]]");
    }

    // Helper method to print test result
    private static void printTestResult(String testCase, List<List<Integer>> actual, String expected) {
        System.out.println(testCase);
        System.out.println("Actual:   " + actual);
        System.out.println("Expected: " + expected);
        System.out.println();
    }

    // Test case 1: Normal binary tree
    private static TreeNode buildTree1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        return root;
    }

    // Test case 2: Single node tree
    private static TreeNode buildTree2() {
        return new TreeNode(1);
    }

    // Test case 4: Left-skewed tree
    private static TreeNode buildLeftSkewedTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        return root;
    }

    // Test case 5: Right-skewed tree
    private static TreeNode buildRightSkewedTree() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        return root;
    }
}
