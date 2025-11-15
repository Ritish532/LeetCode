class Solution {
    public String ans;
    public void traversal(TreeNode root){
        if(root == null) return;

        ans += root.val;

        if(root.left == null && root.right == null){
            return;
        }

        ans += "(";
        if(root.left != null){
            traversal(root.left);
        }
        ans += ")";

        if(root.right != null){
            ans += "(";
            traversal(root.right);
            ans += ")";
            return;
        }
        

    }
    public String tree2str(TreeNode root) {
        if(root == null) return "";
        ans = "";
        traversal(root);
        return ans;
            
    }
}