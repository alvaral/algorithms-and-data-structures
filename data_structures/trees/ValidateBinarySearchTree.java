package data_structures.trees;

/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).
A valid BST is defined as follows:

 - The left subtree of a node contains only nodes with keys less than the node's key.
 - The right subtree of a node contains only nodes with keys greater than the node's key.
 - Both the left and right subtrees must also be binary search trees.
 

Example 1:
    2
   / \
  1   3

Input: root = [2,1,3]
Output: true


Example 2:
    5
   / \
  1   4
     / \
    3   6

Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
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

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left
                = left;
        this.right = right;
    }
}

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode node, long min, long max) {
        if (node == null) {
            return true; // if there is no node, it is an end (ok)
        }
        // check if its out of the correct range
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // Its in correct range, we check that the children are correct too
        return (isValidBSTHelper(node.left, min, node.val)
                && // the left side has to be lower than the root
                isValidBSTHelper(node.right, node.val, max) // the right side has to be upper than the root
                );
    }

    // Main function to test isValidBST with test cases
    public static void main(String[] args) {
        ValidateBinarySearchTree validator = new ValidateBinarySearchTree();

        // Test Case 1
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        String input1 = "[2,1,3]";
        boolean result1 = validator.isValidBST(root1);
        boolean expected1 = true;
        System.out.println("Test Case 1: Input = " + input1 + ", Expected = " + expected1 + ", Obtained = " + result1);

        // Test Case 2
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        String input2 = "[5,1,4,null,null,3,6]";
        boolean result2 = validator.isValidBST(root2);
        boolean expected2 = false;
        System.out.println("Test Case 2: Input = " + input2 + ", Expected = " + expected2 + ", Obtained = " + result2);

        // Test Case 3 (Edge case: single node tree)
        TreeNode root3 = new TreeNode(10);
        String input3 = "[10]";
        boolean result3 = validator.isValidBST(root3);
        boolean expected3 = true;
        System.out.println("Test Case 3: Input = " + input3 + ", Expected = " + expected3 + ", Obtained = " + result3);

        // Test Case 4 (More complex valid tree)
        TreeNode root4 = new TreeNode(10);
        root4.left = new TreeNode(5);
        root4.right = new TreeNode(15);
        root4.right.left = new TreeNode(12);
        root4.right.right = new TreeNode(20);
        String input4 = "[10,5,15,null,null,12,20]";
        boolean result4 = validator.isValidBST(root4);
        boolean expected4 = true;
        System.out.println("Test Case 4: Input = " + input4 + ", Expected = " + expected4 + ", Obtained = " + result4);
    }
}
