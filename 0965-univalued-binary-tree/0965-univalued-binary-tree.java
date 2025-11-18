class Solution {
    public boolean helper(TreeNode root , int val , boolean flag){
        if(root == null) return true;
        if(root.val != val) flag = false;
        if(!flag) return flag;
        flag = helper(root.left , val , flag);
        if(!flag) return flag;
        flag = helper(root.right , val , flag);
        return flag;
    }
    public boolean isUnivalTree(TreeNode root) {
        
        return helper(root , root.val , true);
    }
}