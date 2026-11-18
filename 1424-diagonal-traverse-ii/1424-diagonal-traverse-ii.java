class Solution {
    class Pair implements Comparable<Pair>{
        int sum;
        int ele;
        int row;
        Pair(int sum , int ele , int row){
            this.sum = sum;
            this.ele = ele;
            this.row = row;
        }
        public int compareTo(Pair p){
            if(p.sum == this.sum) return Integer.compare(p.row , this.row);
            return Integer.compare(this.sum , p.sum);
        }
    }
    public int[] findDiagonalOrder(List<List<Integer>> list) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0;  i < list.size() ; i++){
            for(int j = 0 ; j < list.get(i).size() ; j++){
                pq.offer(new Pair(i+j , list.get(i).get(j) , i));
            }
        }
        int[] ans = new int[pq.size()];
        int i = 0;
        while(pq.size() > 0) ans[i++] = pq.poll().ele;
        return ans;
    }
}