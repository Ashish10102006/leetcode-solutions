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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<Integer>();
        if (root == null) {
          return ans;
        }
        helper(root, 0, ans);
        return ans;
    }
    private void helper(TreeNode root,int level ,List<Integer> ans) {
        if(root==null) return;

        // First node visited at this level
        if(level==ans.size()) ans.add(root.val);
        
        // Visit right first, then left
        helper(root.right, level + 1, ans);
        helper(root.left, level + 1, ans);
   }
}