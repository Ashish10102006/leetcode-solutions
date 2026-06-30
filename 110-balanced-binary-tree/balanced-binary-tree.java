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


// A tree is balanced if, at every node, the difference between the left and right subtree heights is at most 1.
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root==null)return true;
        int left=height(root.left);
        int right=height(root.right);

        if (Math.abs(left-right)>1) return false;
        return isBalanced(root.left) && isBalanced(root.right);

    }
    public int height(TreeNode node){
        if (node==null)return 0;     
        int leftdepth =height(node.left);
        int rightdepth =height(node.right);
        return Math.max(leftdepth,rightdepth)+1;
    }
}