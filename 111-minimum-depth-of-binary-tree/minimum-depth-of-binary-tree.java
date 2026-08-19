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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        if (root.left == null && root.right == null) return 1;
        if(root.left  ==  null) return 1 + minDepth(root.right);
        if(root.right == null) return 1 + minDepth(root.left);

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
/*
Correct logic

For each node:

If it is null → 0
If it has no left child → go right
If it has no right child → go left
If it has both children → take the minimum


return 1 + Math.min(height(root.left), height(root.right));
This works for a tree where every node has two children, but it fails when a node has only one child.

Why?

Consider:

    1
     \
      2
       \
        3

Your calculation:

height(3) = 1


height(2) = 1 + min(0, 1)
          = 1


height(1) = 1 + min(0, 1)
          = 1   ❌

But the minimum depth is actually 3.

The problem is that null has depth 0, so Math.min() chooses the null side even though that side isn't a path to a leaf.
*/