class Solution {
    public boolean isExist(TreeNode root , TreeNode a){
        if(root == null) return false;
        if(a.val == root.val) return true;
        return isExist(root.left,a) || isExist(root.right,a);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p == root || q == root) return root;
        boolean pinLst = isExist(root.left , p);
        boolean qinLst = isExist(root.left , q);

        if(pinLst == true && qinLst == true) return lowestCommonAncestor(root.left , p , q);
        if(pinLst == false && qinLst == false) return lowestCommonAncestor(root.right , p , q);
        
        else return root;
    }
}