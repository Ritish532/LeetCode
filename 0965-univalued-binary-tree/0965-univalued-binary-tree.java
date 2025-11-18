class Solution {
    public boolean flag;
    public void helper(TreeNode root , int val){
        if(root == null) return;
        if(root.val != val) flag = false;
        helper(root.left , val);
        helper(root.right , val);
        return;
    }
    public boolean isUnivalTree(TreeNode root) {
        flag = true;
        helper(root , root.val);
        return flag;
    }
}