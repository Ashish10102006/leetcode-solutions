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

 /*
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }
    public boolean isMirror(TreeNode n1, TreeNode n2) 
    {
        if(n1==null && n2==null) return true;
        if(n1==null || n2==null) return false;
        return (n1.val==n2.val) && isMirror(n1.left,n2.right)
        && isMirror(n1.right,n2.left);
    }
}
*/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {

        // Both are empty
        if (left == null && right == null) {
            return true;
        }

        // One is empty, one is not
        if (left == null || right == null) {
            return false;
        }

        // Values must be equal
        if (left.val != right.val) {
            return false;
        }

        // Check mirror positions
        return isMirror(left.left, right.right) &&
               isMirror(left.right, right.left);
    }
}