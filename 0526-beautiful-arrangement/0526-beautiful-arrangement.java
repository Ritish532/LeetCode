class Solution {
    public int dfs(int position , int n , boolean[] used){
        if(position > n) return 1;
        int count = 0;
        for(int i = 1; i <= n ; i++){
            if(!used[i] && (i % position == 0 || position % i == 0)){
                used[i] = true;
                count += dfs(position + 1 , n , used);
                used[i] = false;
            }
        }
        return count;
    }
    public int countArrangement(int n) {
        return dfs(1 , n , new boolean[n+1]);
    }
}