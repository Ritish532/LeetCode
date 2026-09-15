class Solution {
    public int count(int n){
        int c = 0;
        for(int i = 0 ; i <= 31 ; i++){
            int mask = (1 << i);
            if((n & mask) != 0) c++;
        }
        return c;
    }
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i = 0;  i <= n ; i++){
            ans[i] = count(i);
        }
        return ans;
    }
}