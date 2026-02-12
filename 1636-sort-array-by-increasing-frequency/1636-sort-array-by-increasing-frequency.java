class Solution {
    class Pair implements Comparable<Pair>{
        int v;
        int f;
        Pair(int v , int f){
            this.v = v;
            this.f = f;
        }
        public int compareTo(Pair p) {
            if(this.f == p.f) return p.v - this.v;
            return this.f - p.f;
        }
    }
    public int[] frequencySort(int[] nums) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Arrays.sort(nums);
        int i = 0 , j = 1;
        while(j < nums.length){
            if(nums[i] != nums[j]){
                pq.add(new Pair(nums[i] , j-i));
                i = j;
            }
            j++;
            
        }
        pq.add(new Pair(nums[i] , j-i));

        int[] ans = new int[nums.length];
        i = 0;
        while(i < nums.length){
            Pair p = pq.poll();
            int f = p.f;
            for(int k = 0 ; k < f ; k++){
                ans[i++] = p.v;
            }
        }
        return ans;

    }
}