class Solution {
    public class Pair{
        int node ; int cost;
        Pair(int node , int cost){
            this.node = node;
            this.cost = cost;
        }
    }

    public class Triplet implements Comparable<Triplet>{
        int node ; int cost; int stops;
        Triplet(int node , int cost , int stops){
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
        public int compareTo(Triplet t){
            if(this.stops == t.stops) return Integer.compare(this.node,t.node);
            return Integer.compare(this.stops , t.stops);
        }

    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) adj.add(new ArrayList<>());
        for(int i = 0 ; i < flights.length ; i++){
            int from = flights[i][0] , to = flights[i][1] , cost = flights[i][2];
            adj.get(from).add(new Pair(to,cost));
        }
        int[] ans = new int[n];
        Arrays.fill(ans , Integer.MAX_VALUE);
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        pq.add(new Triplet(src,0,0));
        ans[src] = 0;
        while(pq.size() > 0){
            Triplet top = pq.remove();
            if(top.stops >= k+1) continue;
            
            for(Pair p : adj.get(top.node)){
                int cost = p.cost + top.cost;
                if(cost < ans[p.node]){
                    ans[p.node] = cost;
                    pq.add(new Triplet(p.node , cost , top.stops+1));
                }
            }
        }
        if(ans[dst] == Integer.MAX_VALUE) return -1;
        return ans[dst];
    }
}