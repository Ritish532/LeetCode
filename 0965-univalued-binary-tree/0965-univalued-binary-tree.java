class Solution {
    public boolean helper(TreeNode root , int val , boolean flag){
        if(root == null) return true;
        if(root.val != val) flag = false;
        if(!flag) return flag;
        return helper(root.left , val , flag) && helper(root.right , val , flag);
    }
    public boolean isUnivalTree(TreeNode root) {
        
        return helper(root , root.val , true);
    }
}