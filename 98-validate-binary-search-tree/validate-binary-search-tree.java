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
class Solution {
    public boolean isValidBST(TreeNode root) {
        return help(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean help(TreeNode node, long min, long max) {

        if (node == null) return true;

        if (node.val <= min || node.val >= max) {
            return false;
        }

        boolean left = help(node.left, min, node.val);
        boolean right = help(node.right, node.val, max);

        return left && right;
    }
}
// Every node must lie within its allowed range. If even one node is outside that range, the tree is not a valid BST.