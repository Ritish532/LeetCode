class Solution {
    public void helper(TreeNode root , int val , int d){
        if(root == null) return;
        if(d == 1){
            if(root.left == null && root.right == null){
                root.left = new TreeNode(val);
                root.right = new TreeNode(val);
                return;
            }
            else if(root.left != null && root.right == null){
                TreeNode Lft = root.left;
                root.left = new TreeNode(val);
                root.right = new TreeNode(val);
                TreeNode newLft = root.left;
                newLft.left = Lft;
                return;
            }
            else if(root.right != null && root.left == null){
                TreeNode Ryt = root.right;
                root.right = new TreeNode(val);
                root.left = new TreeNode(val);
                TreeNode newRyt = root.right;
                newRyt.right = Ryt;
                return;
            }
            else {
                TreeNode Lft = root.left;
                TreeNode Ryt = root.right;
                root.left = new TreeNode(val);
                root.right = new TreeNode(val);
                TreeNode newLft = root.left;
                TreeNode newRyt = root.right;
                newLft.left = Lft;
                newRyt.right = Ryt;
                return;
            }
            
        }
        helper(root.left , val , d-1);
        helper(root.right , val , d-1);

    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode tmp1 = new TreeNode(val);
            tmp1.left = root;
            root = tmp1;
        }
        else helper(root,val,depth-1);
        return root;
    }
}