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
    int result =0;

    public int averageOfSubtree(TreeNode root) {
        if (root == null) return 0;

         count(root);
        return result;
    }
    // returns {sum, count}
    public int[] count(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = count(node.left);
        int[] right = count(node.right);

        int sum = node.val + left[0] + right[0];
        int count = 1 + left[1] + right[1];

        int average = sum / count;

        if (node.val == average) {
            result++;
        }

        return new int[]{sum, count};
    }
}

/*
left[0] → sum of left subtree
left[1] → number of nodes in left subtree
right[0] → sum of right subtree
right[1] → number of nodes in right subtree

At every call to:
count(node)
the function eventually creates an array of size 2:
return new int[]{sum, count};
*/