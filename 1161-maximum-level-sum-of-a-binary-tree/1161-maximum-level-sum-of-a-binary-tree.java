class Solution {
    public int maxLevelSum(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int count = 1 , maxCount = 1;
        int maxSum = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int sum = 0;
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode temp = q.poll();
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
                sum += temp.val;
            }
            if(maxSum < sum){
                maxSum = sum;
                maxCount = count;
            }
            count++;
        }
        return maxCount;
    }
}