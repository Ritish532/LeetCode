class Solution {
    public class Triplet implements Comparable<Triplet>{
        int ele , row , col;
        Triplet(int ele , int row , int col){
            this.ele = ele;
            this.row = row;
            this.col = col;
        }
        public int compareTo(Triplet t){
            return this.ele - t.ele;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        int max = Integer.MIN_VALUE , k = nums.size();
        int[] ans = {0,Integer.MAX_VALUE};
        for(int i = 0; i < k ; i++){
            int ele = nums.get(i).get(0);
            pq.add(new Triplet(ele , i , 0));
            max = Math.max(max,ele);            
        }

        while(true){
            Triplet t = pq.remove();

            if(max-t.ele < ans[1]-ans[0]){
                ans[0] = t.ele;
                ans[1] = max;
            }

            if(t.col+1 == nums.get(t.row).size()) break;
            int x = nums.get(t.row).get(t.col + 1);
            max = Math.max(max,x);
            pq.add(new Triplet(x , t.row , t.col+1));
        }

        return ans;
    }
}