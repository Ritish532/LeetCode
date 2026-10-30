class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        if(k == 0) return -1;
        List<int[]>[] adj = new ArrayList[n];
        for(int i = 0 ; i < n ; i++) adj[i] = (new ArrayList<>());
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            adj[u].add(new int[]{v,w});
        }
        int[][] dist = new int[n][k+1]; // node , count
        for(int[] row : dist) Arrays.fill(row , Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0])); // Cost , Node , Count
        dist[0][1] = 0;
        pq.add(new int[]{0,0,1});
        while(!pq.isEmpty()){
            int[] state = pq.poll();
            int cost =  state[0];
            int node =  state[1];
            int count = state[2];
            if(dist[node][count] != cost) continue;
            if(node == n-1) return cost;
            for(int[] ele : adj[node]){
                int neighbour = ele[0];
                int weight = ele[1];

                char nextChar = labels.charAt(neighbour);
                char nowChar = labels.charAt(node);

                int newCount = 0;
                if(nextChar == nowChar) newCount = count + 1;
                else newCount = 1;

                if(newCount > k) continue;
                
                int newCost = cost + weight;

                if(newCost < dist[neighbour][newCount]){
                    dist[neighbour][newCount] = newCost;
                    pq.add(new int[]{newCost , neighbour , newCount});
                }
            }
        }
        return -1;
    }
}