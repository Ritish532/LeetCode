class Solution {
    public int[] parent;
    public int find(int a){
        if(parent[a] == a) return a;
        return find(parent[a]);
    }
    public void Union (int a , int b){
        int leaderA = find(a);
        int leaderB = find(b);
        parent[leaderB] = leaderA;
    } 
    public int findCircleNum(int[][] adj) {
        int count = 0 , n = adj.length;
        parent = new int[n+1];
        for(int i = 0 ; i <= n ; i++) parent[i] = i;
        parent[0] = 5678;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i != j && adj[i][j] == 1) Union(i+1,j+1);
            }
        }
        for(int i = 0 ; i <= n ; i++) if(parent[i] == i) count++;
        return count;
    }
// class Solution {
//     public void dfs(int i , int[][] adj , boolean[] vis){
//         vis[i] = true;
//         int n = adj[0].length;
//         for(int j = 0 ; j < n ; j++){
//             if(adj[i][j] == 1 && !vis[j]) dfs(j,adj,vis);
//         }
//     }
//     public int findCircleNum(int[][] adj) {
//         int n = adj.length , count = 0;
//         boolean vis[] = new boolean[n];
//         for(int i = 0 ; i < n ; i++){
//             if(!vis[i]){
//                 dfs(i,adj,vis);
//                 count++;
//             }
//         }
//         return count;
//     }
}
// class Solution {
//     public void bfs(int i , int[][] adj , boolean[] vis){
//         Queue<Integer> q = new LinkedList<>();
//         int n = adj.length;
//         q.add(i);
//         while(q.size() > 0){
//             int front = q.remove();
//             for(int j = 0 ; j < n ; j++){
//                 if(!vis[j] && adj[front][j] == 1){
//                     q.add(j);
//                     vis[j] = true;
//                 }
//             }
//         }
//     }
//     public int findCircleNum(int[][] adj) {
//         int n = adj.length , count = 0;
//         boolean vis[] = new boolean[n];
//         for(int i = 0 ; i < n ; i++){
//             if(!vis[i]){
//                 bfs(i,adj,vis);
//                 count++;
//             }
//         }
//         return count;
//     }
// }