class Solution {
    class Pair implements Comparable<Pair>{
        int v;
        int d;
        Pair(int v , int d){
            this.v = v;
            this.d = d;
        }
        public int compareTo(Pair p) {
            if(this.d == p.d) return this.v - p.v;
            return this.d - p.d;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Arrays.sort(nums);
        int i = 0 , j = 1;
        while(j < nums.length){
            if(nums[i] != nums[j]){
                pq.add(new Pair(nums[i] , j-i));
                if(pq.size() > k) pq.remove();
                i = j;
            }
            j++;
            
        }
        pq.add(new Pair(nums[i] , j-i));
        if(pq.size() > k) pq.remove();

        int[] ans = new int[k];
        i = 0;
        while(i < k){
            Pair p = pq.poll();
            ans[i++] = p.v;
        }
        return ans;

    }
}