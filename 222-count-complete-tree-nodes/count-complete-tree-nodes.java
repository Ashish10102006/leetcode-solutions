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
    public int countNodes(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        preoerderTraversal(root,ans);
        return ans.size();
    }
    private void  preoerderTraversal(TreeNode node,List<Integer> ans ){
        if(node==null) return;

        ans.add(node.val);
        preoerderTraversal(node.left,ans);
        preoerderTraversal(node.right,ans);
    }
}
*/

class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}