class Solution {
    public int maxSum;
    public int pathSum(TreeNode root){
        if(root == null) return 0;
        int leftPath = pathSum(root.left);
        int rightPath = pathSum(root.right);
        int pathsum = root.val;
        if(leftPath >= 0) pathsum += leftPath;
        if(rightPath >= 0) pathsum += rightPath;
        maxSum = Math.max(maxSum , pathsum);
        return root.val + Math.max(0 , Math.max(leftPath , rightPath));
    }
    public int maxPathSum(TreeNode root) {
        maxSum = root.val;
        pathSum(root);
        return maxSum;
    }
}