class Solution {
    public boolean canFinish(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int[] inorder = new int[n];
        for(int i = 0 ; i< n ; i++) adj.add(new ArrayList<>());
        for(int[] ar : pre){
            int a = ar[0] , b = ar[1];
            adj.get(b).add(a);
            inorder[a]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++) if(inorder[i] == 0) q.add(i);
        while(q.size() > 0) {
            int front = q.remove();
            ans.add(front);
            for(int ele : adj.get(front)){
                inorder[ele]--;
                if(inorder[ele] == 0) q.add(ele);
            }
        }
        return ans.size() == n;
    }
}