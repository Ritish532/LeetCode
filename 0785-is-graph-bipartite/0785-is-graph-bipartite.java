// Krushal's Algo || DSU
class Solution {
    public int[] parent , size;
    public boolean[] parity;
    public int Leader(int a){
        if(parent[a] == a) return a;
        return parent[a] = Leader(parent[a]);
    }
    public void Union(int u , int v){
        int a = Leader(u);
        int b = Leader(v);
        if(size[a] > size[b]){
            parent[b] = a;
            size[a] += size[b];
            parity[v] = !parity[u];
        }
        else{
            parent[a] = b;
            size[b] += size[a];
            parity[u] = !parity[v];
        }
    }
    public boolean isBipartite(int[][] adj) {
        int n = adj.length;
        parent = new int[n];
        size = new int[n];
        parity = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
            size[i] = 1;
            parity[i] = false;
        }
        for(int u = 0 ; u < adj.length ; u++){
            for(int j = 0 ; j < adj[u].length ; j++){
                int v = adj[u][j];
                if(v > u){
                    if(Leader(u) == Leader(v)){
                        if(parity[u] == parity[v]) return false;
                    }
                    else Union(u,v);
                }
            }
        }
        return true;
    }
}

// class Solution {
//     public boolean ans;
//     public void dfs(int i , int color , int[][] adj , int[] vis){
//         if(vis[i] != -1){
//             if(vis[i] == 1-color) ans = false;
//             return;
//         }
//         vis[i] = color;
//         for(int ele : adj[i]){
//             dfs(ele , 1-color , adj , vis);
//             if(!ans) return;
//         }
//     }
//     public boolean isBipartite(int[][] adj) {
//         ans = true;
//         int n = adj.length;
//         int[] vis = new int[n];
//         Arrays.fill(vis,-1);
//         for(int i =0 ; i < n ; i++){
//             if(vis[i] == -1){
//                 dfs(i , 0 , adj , vis);
//                 if(!ans) return ans;
//             }
//         }
//         return true;
//     }
// }
// class Solution {
//     public boolean ans;
//     public void bfs(int i , int[] vis , int[][] graph){
//         Queue<Integer> q = new LinkedList<>();
//         q.add(i);
//         vis[i] = 0;
//         while(q.size() > 0){
//             int a = q.remove();
//             int color = vis[a];
//             for(int ele : graph[a]){
//                 if(vis[ele] == vis[a]){
//                     ans = false;
//                     return;
//                 }
//                 if(vis[ele] == -1){
//                     vis[ele] = 1-color;
//                     q.add(ele);
//                 }
//             }
//         }
//     }
// 0 -> Red , 1 -> Blue
//     public boolean isBipartite(int[][] graph) {
//         ans = true;
//         int n = graph.length;
//         int[] vis = new int[n];
//         Arrays.fill(vis,-1);
//         for(int i = 0 ; i < n ; i++){
//             if(vis[i] == -1){
//                 bfs(i , vis , graph);
//                 if(!ans) return ans;
//             }
//         }
//         return ans;
//     }
// }