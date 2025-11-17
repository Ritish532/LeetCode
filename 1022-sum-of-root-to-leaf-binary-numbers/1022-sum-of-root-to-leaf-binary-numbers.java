class Solution {
    public List<Integer> ans;
    public int sum;
    public void dfs(TreeNode root){
        if(root == null) return;
        ans.add(root.val);
        if(root.left == null && root.right == null){
            int num = 0;
            for(int n : ans){
                num = num * 2 + n;
            }
            sum += num;
            ans.remove(ans.size()-1);
            return;
        }
        dfs(root.left);
        dfs(root.right);

        ans.remove(ans.size()-1);
        return;
    }
    public int sumRootToLeaf(TreeNode root) {
        ans = new ArrayList<>();
        sum = 0;
        dfs(root);
        return sum;
    }
}