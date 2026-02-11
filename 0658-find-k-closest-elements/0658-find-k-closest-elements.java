class Solution {
    class Pair implements Comparable<Pair>{
        int n ;
        int d;
        Pair(int n , int d){
            this.n = n;
            this.d = d;
        }
        public int compareTo(Pair p){
            if(p.d == this.d) return this.n - p.n;
            return this.d - p.d;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0;  i < arr.length ; i++){
            int d = Math.abs(x-arr[i]);
            pq.add(new Pair(arr[i],d));
            if(pq.size() > k) pq.remove();
        }

        List<Integer> ans = new ArrayList<>();
        while(pq.size() > 0) ans.add((pq.poll()).n);
        Collections.sort(ans);

        return ans;
    }
}