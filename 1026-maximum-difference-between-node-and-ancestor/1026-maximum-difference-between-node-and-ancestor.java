class Solution {
    public int ans;
    public void dfs(TreeNode root , int max , int min){
        if(root == null) return;
        max = Math.max(root.val , max);
        min = Math.min(root.val , min);

        ans = Math.max(ans, max-min);

        dfs(root.left , max , min);
        dfs(root.right , max , min);
        return;
    }
    public int maxAncestorDiff(TreeNode root) {
        ans = 0;
        dfs(root, Integer.MIN_VALUE , Integer.MAX_VALUE);
        return ans;
    }
}