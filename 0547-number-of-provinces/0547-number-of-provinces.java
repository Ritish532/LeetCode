class Solution {
    public void bfs(int i , int[][] adj , boolean[] vis){
        Queue<Integer> q = new LinkedList<>();
        int n = adj.length;
        q.add(i);
        while(q.size() > 0){
            int front = q.remove();
            for(int j = 0 ; j < n ; j++){
                if(!vis[j] && adj[front][j] == 1){
                    q.add(j);
                    vis[j] = true;
                }
            }
        }
    }
    public int findCircleNum(int[][] adj) {
        int n = adj.length , count = 0;
        boolean vis[] = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            if(!vis[i]){
                bfs(i,adj,vis);
                count++;
            }
        }
        return count;
    }
}