class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while(curr != null){
            if(curr.left != null){
                TreeNode pred = curr.left;
                TreeNode r = curr.right;
                curr.right = curr.left;
                while(pred.right != null) pred = pred.right;
                pred.right = r;
                curr.left = null;
                curr = curr.right;
            }
            else{
                    curr = curr.right;
                }
        }
    }
}
// class Solution {
//     public void flatten(TreeNode root) {
//       TreeNode curr = root;
//       while(curr != null){
//         if(curr.left != null){
//             TreeNode r = curr.right;
//             curr.right = curr.left;
//             TreeNode pred = curr.left;
//             while(pred.right != null) pred = pred.right;
//             pred.right = r;
//             curr.left = null;
//             curr = curr.right;
//         }
//         else{
//             curr = curr.right;
//         }
//       }
//     }
// }



// class Solution {
//     public void flatten(TreeNode root) {
//         if(root == null) return;
//         TreeNode curr = root;
//         TreeNode LST = root.left;
//         TreeNode RST = root.right;
//         root.left = null;
//         flatten(LST);
//         flatten(RST);
//         root.right = LST;
//         TreeNode temp = root;
//         while(temp.right != null) temp = temp.right;
//         temp.right = RST;

//         return;
//     }
// }



// class Solution {
//     public List<TreeNode> ans;
//     public void preorder(TreeNode root){
//         if(root == null) return;
//         ans.add(root);
//         preorder(root.left);
//         preorder(root.right);
//         return;
//     }
//     public void flatten(TreeNode root) {
//         ans = new ArrayList<>();
//         preorder(root);
//         for(int i = 0 ; i < ans.size()-1 ; i++){
//             ans.get(i).right = ans.get(i+1);
//             ans.get(i).left = null;
//         }
//         return ;
//     }
// }