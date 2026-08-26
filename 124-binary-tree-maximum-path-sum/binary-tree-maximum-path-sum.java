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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum; 
    }
    public int maxGain(TreeNode node){
        if(node==null) return 0;

        //We don't take a negative contribution. If a subtree gives -5, we'd rather take 0.
        int leftGain = Math.max(0, maxGain(node.left));
        int rightGain = Math.max(0, maxGain(node.right));

        // Path passing through the current node
        int currentPath = leftGain + node.val + rightGain;

        // Update the overall maximum
        maxSum = Math.max(maxSum, currentPath);

        // Return only one side to the parent
        return node.val + Math.max(leftGain, rightGain);
    }
}