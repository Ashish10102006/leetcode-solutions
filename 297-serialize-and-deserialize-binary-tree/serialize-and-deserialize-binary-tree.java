/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";

        List<String> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty())
        {
            TreeNode currentNode = queue.poll();
            if(currentNode == null){
                list.add("null");
                continue;
            }
            list.add(String.valueOf(currentNode.val));
            queue.add(currentNode.left);
            queue.add(currentNode.right);
        }
        return String.join(",",list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data==null || data.isEmpty()) return null;
        String values[]= data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int index=1;
        while(!queue.isEmpty())
        {
            TreeNode currentNode = queue.poll();
            
            if(!values[index].equals("null"))
            {
                TreeNode leftchild = new TreeNode(Integer.parseInt(values[index]));
                currentNode.left=leftchild;
                queue.add(leftchild);
            }
            index++;

            if(!values[index].equals("null"))
            {
                TreeNode rightchild = new TreeNode(Integer.parseInt(values[index]));
                currentNode.right=rightchild;
                queue.add(rightchild);
            }
            index++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));