class Solution {
    public boolean ans;
    public void bfs(int i , int[] vis , int[][] graph){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        vis[i] = 0;
        while(q.size() > 0){
            int a = q.remove();
            int color = vis[a];
            for(int ele : graph[a]){
                if(vis[ele] == vis[a]){
                    ans = false;
                    return;
                }
                if(vis[ele] == -1){
                    if(vis[a] == 0) vis[ele] = 1;
                    else vis[ele] = 0;
                    q.add(ele);
                }
            }
        }
    }
    public boolean isBipartite(int[][] graph) {
        ans = true;
        int n = graph.length;
        int[] vis = new int[n];
        Arrays.fill(vis,-1);
        for(int i = 0 ; i < n ; i++){
            if(vis[i] == -1){
                bfs(i , vis , graph);
                if(!ans) return ans;
            }
        }
        return ans;
    }
}