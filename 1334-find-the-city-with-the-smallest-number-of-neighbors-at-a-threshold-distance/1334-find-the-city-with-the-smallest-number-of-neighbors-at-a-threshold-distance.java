// Floyd Warshal Algo
class Solution {
    public int findTheCity(int n, int[][] edges, int m) {
        int[][] dist = new int[n][n];
        for(int ele[] : dist) Arrays.fill(ele , Integer.MAX_VALUE);
        for(int ele[] : edges){
            int u = ele[0] , v = ele[1] , wt = ele[2];
            dist[u][v] = wt ; dist[v][u] = wt;
        }
        for(int k = 0 ; k < n ; k++){
            for(int i = 0 ; i < n ; i++){
                if(i == k) continue;
                for(int j = 0 ;j < n ; j++){
                    if(j == k || dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) continue;
                    dist[i][j] = Math.min(dist[i][j] , dist[i][k] + dist[k][j]);
                }
            }
        }
        int City = -1 , minCount = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            int count = 0;
            for(int j = 0 ; j < n ; j++){
                if(i == j) continue;
                if(dist[i][j] <= m) count++;
            }
            if(count <= minCount){
                minCount = count;
                City = i;
            }
        }
        return City;
    }
}