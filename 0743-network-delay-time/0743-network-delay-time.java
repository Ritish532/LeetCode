class Solution {
    public class Pair implements Comparable<Pair>{
        int node ; int time;
        Pair(int node , int time){
            this.node = node;
            this.time = time;
        }
        public int compareTo(Pair p){
            if(this.time == p.time) return this.node - p.node;
            return this.time - p.time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int src) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++) adj.add(new ArrayList<>());
        for(int i = 0 ; i < times.length ; i++){
            int a = times[i][0] , b = times[i][1] , time = times[i][2];
            adj.get(a).add(new Pair(b,time));
        }
        int[] ans = new int[n+1];
        Arrays.fill(ans,Integer.MAX_VALUE);
        PriorityQueue<Pair> q = new PriorityQueue<>();
        ans[src] = 0;
        q.add(new Pair(src,0));
        while(q.size() > 0){
            Pair top = q.remove();
            int node = top.node , time = top.time;
            if(time > ans[node]) continue;
            for(Pair p : adj.get(node)){
                int totalTime = time + p.time;
                if(totalTime < ans[p.node]){
                    ans[p.node] = totalTime;
                    q.add(new Pair(p.node , totalTime));
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1 ; i <= n ; i++){
            if(ans[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max , ans[i]);
        }
        return max;
    }
}