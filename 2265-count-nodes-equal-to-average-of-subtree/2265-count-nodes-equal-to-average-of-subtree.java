/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int levels(TreeNode root){
        if(root == null) return 0;
        return 1 + levels(root.left) + levels(root.right);
    }
    public int add(TreeNode root){
        if(root == null) return 0;
        return root.val + add(root.left) + add(root.right);
    }
    public int helper(TreeNode root){
        if(root == null) return 0;
        int count = 0;
        if(add(root) / levels(root) == root.val) count++;
        return count + helper(root.left) + helper(root.right);
    }
    public int averageOfSubtree(TreeNode root) {
        return helper(root);
    }
}