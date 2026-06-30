/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 // Ask both children for their depth, take the larger one, and add 1 (for the current node).
class Solution {
    public int maxDepth(TreeNode root) {
        if (root==null)
        return 0;
        int leftdepth=maxDepth(root.left);
        int rightdepth=maxDepth(root.right);
       return Math.max( leftdepth,rightdepth) +1;
    }
}
