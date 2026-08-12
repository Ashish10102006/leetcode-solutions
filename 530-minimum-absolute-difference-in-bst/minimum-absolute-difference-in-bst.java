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

// root == null → return 0
// Otherwise, do inorder traversal because BST inorder gives values in sorted order.
// Then compare adjacent values to find the minimum difference.
class Solution {
    int prev=-1;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root==null) return 0;
        inorder(root);
        return min;
    }

    void inorder(TreeNode root) {
        if(root==null) return ;

        inorder(root.left);

        if(prev!=-1){
            min=Math.min(min,root.val-prev);
        }
        prev=root.val;

        inorder(root.right);
        
    }
}