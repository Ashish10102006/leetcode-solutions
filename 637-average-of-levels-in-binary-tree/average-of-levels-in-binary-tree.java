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

 // approch =BFS+QUEUE

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> ans =new ArrayList<>();
        if(root==null) return ans;

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size=q.size();
            double sum=0;
            for(int i=0;i<size;i++){

                TreeNode node =q.poll();

                sum+=node.val;

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }

            ans.add(sum/size);
        }

        return ans;
    }
}
//SC = O(N) q can contain up to N nodes. 
//TC = O(N) every node in the tree is visited once. 