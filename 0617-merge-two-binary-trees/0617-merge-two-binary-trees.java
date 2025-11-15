class Solution {
    public TreeNode traversal(TreeNode root1 , TreeNode root2){
        if(root1 == null) return root2;
        if(root2 == null) return root1;

        TreeNode merged = new TreeNode(root1.val + root2.val); 
        merged.left = traversal(root1.left , root2.left);
        merged.right = traversal(root1.right , root2.right);
        return merged;
    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        
        return traversal(root1,root2);
    }
}