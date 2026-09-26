class Solution {
    public class Triplet implements Comparable<Triplet>{
        int row;
        int col;
        int efforts;
        Triplet(int row , int col , int efforts){
            this.row = row;
            this.col = col;
            this.efforts = efforts;
        }
        public int compareTo(Triplet t){
            if(this.efforts == t.efforts) return this.row - t.row;
            return Integer.compare(this.efforts , t.efforts);
        }
    }
    public int minimumEffortPath(int[][] arr) {
        int n = arr.length , m = arr[0].length;
        int[][] ans = new int[n][m];
        int[] r = {-1,0,1,0}; int[] c = {0,-1,0,1};
        for(int[] ele : ans) Arrays.fill(ele,Integer.MAX_VALUE);
        ans[0][0] = 0;
        PriorityQueue<Triplet> q = new PriorityQueue<>();
        q.add(new Triplet(0,0,0));
        while(q.size() > 0){
            Triplet top = q.remove();
            int row = top.row , col = top.col , efforts = top.efforts;
            if(row== n-1 && col == m-1) break;
            for(int i = 0 ; i < 4 ; i++){
                int temprow = row + r[i] , tempcol = col + c[i];
                if(temprow < 0 || tempcol < 0 || temprow >= n || tempcol >= m) continue;
                int e = Math.abs(arr[row][col] - arr[temprow][tempcol]);
                e = Math.max(e , efforts);
                if(e < ans[temprow][tempcol]){
                    ans[temprow][tempcol] = e;
                    q.add(new Triplet(temprow , tempcol , e));
                }
            }
        }
        return ans[n-1][m-1];
    }
}