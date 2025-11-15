class Solution {
    public int sum;
    public void preorder(TreeNode root , String s){
        if(root == null) return;
        s += root.val;
        if(root.left == null && root.right == null){
            sum += Integer.parseInt(s);
            s = s.substring(0,s.length()-1);
            return;
        }
        preorder(root.left , s);
        preorder(root.right , s);

        s = s.substring(0,s.length()-1);
        return;
    }
    public int sumNumbers(TreeNode root) {
        sum = 0;
        preorder(root,"");
        return sum;
    }
}
// class Solution {
//     List<String> sb;
//     public void preorder(TreeNode root , String s){
//         if(root == null) return;
//         s += root.val;
//         if(root.left == null && root.right == null){
//             sb.add(s);
//             s = s.substring(0,s.length()-1);
//             return;
//         }
//         preorder(root.left , s);
//         preorder(root.right , s);

//         s = s.substring(0,s.length()-1);
//         return;
//     }
//     public int sumNumbers(TreeNode root) {
//         sb = new ArrayList<>();
//         preorder(root,"");
//         int sum = 0;
//         for(String s : sb){
//             int a = Integer.parseInt(s);
//             sum += a;
//         }
//         return sum;
//     }
// }