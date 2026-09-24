class Solution {
    class Pair{
        int a;
        int time; 
        Pair(int a , int time){
            this.a = a;
            this.time = time;
        }
    }
    public int minimumTime(int n, int[][] arr, int[] time) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++) adj.add(new ArrayList<>());
        int[] inorder = new int[n+1];
        int[] dp = new int[n+1];
        for(int[] ele : arr){
            int a = ele[0] , b = ele[1];
            adj.get(a).add(b);
            inorder[b]++;
        }
        inorder[0] = -1;
        int max = Integer.MIN_VALUE;
        Queue<Pair> q = new LinkedList<>();
        for(int i = 1 ; i <= n ; i++) 
            if(inorder[i] == 0) {
                dp[i] = time[i-1];
                q.add(new Pair(i , dp[i]));
            }
        while(q.size() > 0){
            Pair front = q.remove();
            max = Math.max(max,front.time);
            for(int ele : adj.get(front.a)){
                dp[ele] = Math.max(dp[ele] , front.time + time[ele-1]);
                inorder[ele]--;
                if(inorder[ele] == 0) q.add(new Pair(ele , dp[ele]));
            }
        }
        return max;
    }
}