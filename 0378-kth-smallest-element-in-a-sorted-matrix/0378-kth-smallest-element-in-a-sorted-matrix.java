class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length , m = matrix[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        for(int i = 0 ; i < n ; i++) pq.add(new int[]{matrix[i][0] , i , 0});

        int ans = -1;
        while(k-- > 0){
            int[] curr = pq.poll();
            int val = curr[0];
            int row = curr[1];
            int col = curr[2];
            ans = val;
            if(col + 1 < m){
                pq.add(new int[]{matrix[row][col+1] , row , col+1});
            }
        }
        return ans;
    }
}