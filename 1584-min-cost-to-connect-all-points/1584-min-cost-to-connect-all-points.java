// Krushals Algo
class Solution {
    public int[] parent , size;
    public int Leader(int a){
        if(parent[a] == a) return a;
        return parent[a] = Leader(parent[a]);
    }
    public void Union(int a , int b){
        a = Leader(a);
        b = Leader(b);
        if(size[a] > size[b]){
            parent[b] = a;
            size[a] += size[b];
        }
        else{
            parent[a] = b;
            size[b] += size[a];
        }
    }
    public class Triplet implements Comparable<Triplet>{
        int u ;
        int v;
        int dist;
        Triplet(int u , int v , int dist){
            this.u = u;
            this.v = v;
            this.dist = dist;
        }
        public int compareTo(Triplet t){
            if(t.dist == this.dist) return Integer.compare(this.u , t.u);
            return Integer.compare(this.dist , t.dist);
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length , sum = 0;;
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        parent = new int[n];
        size = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
            size[i] = 1;
        }
        for(int u = 0 ; u < n ; u++){
            for(int v = u+1 ; v < n ; v++){
                int x1 = points[u][0] , y1 = points[u][1];
                int x2 = points[v][0] , y2 = points[v][1];
                int dist = Math.abs(x1-x2) + Math.abs(y1-y2);
                pq.add(new Triplet(u,v,dist));
            }
        }
        while(pq.size() > 0){
            Triplet top = pq.remove();
            int u = top.u , v = top.v , dist = top.dist;
            if(Leader(u) != Leader(v)){
                Union(u,v);
                sum += dist;
            }
        }

        return sum;
    }
}
// // Prims Algo
// class Solution {
//     public class Triplet implements Comparable<Triplet>{
//         int node ;
//         int parent;
//         int dist;
//         Triplet(int node , int parent , int dist){
//             this.node = node;
//             this.parent = parent;
//             this.dist = dist;
//         }
//         public int compareTo(Triplet t){
//             if(t.dist == this.dist) return Integer.compare(this.node , t.node);
//             return Integer.compare(this.dist , t.dist);
//         }
//     }
//     public int minCostConnectPoints(int[][] points) {
//         int sum = 0 , n = points.length;
//         boolean[] vis = new boolean[n];
//         PriorityQueue<Triplet> pq = new PriorityQueue<>();
//         pq.add(new Triplet(0,-1,0));
//         while(pq.size() > 0){
//             Triplet top = pq.remove();
//             int node = top.node , parent = top.parent , dist = top.dist;
//             if(vis[node]) continue;
//             sum += dist;
//             vis[node] = true;
//             int x1 = points[node][0] , y1 = points[node][1];
//             for(int i = 0 ; i < n ; i++){
//                 if( i == node || i == parent) continue;
//                 if(vis[i]) continue;
//                 int x2 = points[i][0] , y2 = points[i][1];
//                 int manhattan = Math.abs(x2-x1) + Math.abs(y2-y1);
//                 pq.add(new Triplet(i , node , manhattan));
//             }
//         }
//         return sum;
//     }
// }