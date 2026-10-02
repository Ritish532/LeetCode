class Solution {
    public boolean vis[];
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        vis = new boolean[n];
        return dfs(arr , start , n);
    }
    public boolean dfs(int[] arr , int i , int n){
        if(i < 0 || i >= n || vis[i]) return false;
        if(arr[i] == 0) return true;
        vis[i] = true;
        return dfs(arr , i + arr[i] , n) || dfs(arr , i - arr[i] , n);
    }
}