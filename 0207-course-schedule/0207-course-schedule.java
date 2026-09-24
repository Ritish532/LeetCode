class Solution {
    public boolean ans;
    public void dfs(int i , List<List<Integer>> adj , boolean[] vis , boolean[] path){
        vis[i] = true;
        path[i] = true;
        for(int ele : adj.get(i)){
            if(path[ele]) {
                ans = false;
                return;
            }
            if(!vis[ele]) dfs(ele , adj , vis , path);
        }
        path[i] = false;
    }
    public boolean canFinish(int n, int[][] pre) {
        ans = true;
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[n];
        boolean[] path = new boolean[n];
        for(int i = 0 ; i< n ; i++) adj.add(new ArrayList<>());
        for(int[] ar : pre) adj.get(ar[1]).add(ar[0]);
        for(int i = 0 ; i < n ; i++) if(!vis[i]) dfs(i , adj , vis , path);
        return ans;
    }
}