class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        if(root == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int idx = 0;
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 0 ; i < size ; i++){
                TreeNode temp = q.poll();
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
                arr.add(temp.val);
            }
            int i = 0 , j = 1;
            if(idx % 2 == 0){ // Even level == odd + inc
                if(arr.get(i) % 2 == 0) return false;
                for(;j < arr.size(); i++,j++){
                    if(arr.get(j) % 2 == 0) return false;
                    if(arr.get(i) >= arr.get(j)) return false;
                }
            }
            else { // Odd level == even + dec
                if(arr.get(i) % 2 != 0) return false;
                for(;j < arr.size(); i++,j++){
                    if(arr.get(j) % 2 != 0) return false;
                    if(arr.get(i) <= arr.get(j)) return false;
                }
            }
            idx++;
        }
        return true;
    }
}