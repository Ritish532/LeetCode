class Solution {
    public int levels(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(levels(root.left) , levels(root.right));
    }
    public TreeNode level(TreeNode root){
        if(root == null) return null;
        int lft = levels(root.left);
        int ryt = levels(root.right);
        if(lft == ryt) return root;
        else if(lft > ryt) return level(root.left);
        else return level(root.right);
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;
        return level(root);
    }
}