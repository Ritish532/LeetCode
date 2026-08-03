class Solution {
    public HashMap<TreeNode , Integer> dp;
    public int levels(TreeNode root){
        if(root == null) return 0;
        if(dp.containsKey(root)) return dp.get(root);
        int left = levels(root.left);
        int right =  levels(root.right);
        dp.put(root , 1 + Math.max(left , right));
        return dp.get(root);
    }
    public int diameter(TreeNode root) {
        if(root == null) return 0;
        int myDia = levels(root.left) + levels(root.right);
        int left_dia = diameter(root.left);
        int right_dia = diameter(root.right);
        return Math.max(myDia , Math.max(left_dia , right_dia));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        dp = new HashMap<>();
        return diameter(root);
    }
}


// class Solution {
//     static int ans;
//     public int levels(TreeNode root){
//         if(root == null) return 0;
//         int left = levels(root.left);
//         int right = levels(root.right);

//         ans = Math.max(ans,left + right);

//         return 1 + Math.max(left , right); 
//     }
//     public int diameterOfBinaryTree(TreeNode root) {
//         ans = 0;
//         if(root == null) return ans;
//         int myDia = levels(root);

//         return ans;
//     }
// }


// class Solution {
//     public int levels(TreeNode root){
//         if(root == null) return 0;
//         return 1 + Math.max(levels(root.left) , levels(root.right));
//     }
//     public int diameterOfBinaryTree(TreeNode root) {
//         if(root == null) return 0;
//         int myDia = levels(root.left) + levels(root.right);
//         int leftDia = diameterOfBinaryTree(root.left);
//         int rightDia = diameterOfBinaryTree(root.right);

//         return Math.max(myDia,Math.max(leftDia,rightDia));
//     }
// }