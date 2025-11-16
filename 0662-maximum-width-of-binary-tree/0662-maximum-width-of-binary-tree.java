class Solution {
    class pair{
        TreeNode node;
        int idx;
        pair(TreeNode node , int idx){
            this.node = node;
            this.idx = idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(root,1));
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int size = q.size();
            int first = q.peek().idx , last = first;
            for(int i = 0 ; i < size ; i++){
                pair temp = q.poll();
                last = temp.idx;
                if(temp.node.left != null) q.add(new pair(temp.node.left , 2 * temp.idx));
                if(temp.node.right != null) q.add(new pair(temp.node.right , 2 * temp.idx + 1));

            }
            max = Math.max(max , Math.abs(first-last)+1);
        }
        return max;
    }
}