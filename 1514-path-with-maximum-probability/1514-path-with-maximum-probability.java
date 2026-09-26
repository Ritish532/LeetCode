class Solution {
    class Pair implements Comparable<Pair>{
        int node ; 
        double prob;
        Pair(int node , double prob){
            this.node = node;
            this.prob = prob;
        }
        public int compareTo(Pair p){
            if(this.prob == p.prob) return p.node - this.node;
            return Double.compare(this.prob,p.prob);
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) adj.add(new ArrayList<>());
        for(int i = 0 ; i < edges.length ; i++){
            int a = edges[i][0] , b = edges[i][1];
            double prob = succProb[i];
            adj.get(a).add(new Pair(b,prob));
            adj.get(b).add(new Pair(a,prob));
        }
        double[] ans = new double[n];
        Arrays.fill(ans,0);
        ans[start] = 1;
        PriorityQueue<Pair> q = new PriorityQueue<>(Collections.reverseOrder());
        q.add(new Pair(start,1));
        while(q.size() > 0){
            Pair top = q.remove();
            int node = top.node;
            double prob = top.prob;
            if(prob < ans[node]) continue;
            for(Pair p : adj.get(node)){
                double totalProb = p.prob * prob;
                if(totalProb > ans[p.node]){
                    ans[p.node] = totalProb;
                    q.add(new Pair(p.node , totalProb));
                }
            }
        }
        return ans[end];
    }
}