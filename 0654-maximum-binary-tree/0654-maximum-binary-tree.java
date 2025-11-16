class Solution {
    public TreeNode helper(int[] nums , int strt , int end){
        if(strt > end) return null;
        int maxValue = Integer.MIN_VALUE , idx =-1;
        for(int i = strt ; i <= end ; i++){
            if(maxValue < nums[i]){
                idx = i;
                maxValue = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxValue);
        root.left = helper(nums , strt , idx-1);
        root.right = helper(nums , idx+1 , end);
        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums , 0 , nums.length-1);

    }
}