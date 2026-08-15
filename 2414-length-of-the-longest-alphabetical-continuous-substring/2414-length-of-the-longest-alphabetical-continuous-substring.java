class Solution {
    public int longestContinuousSubstring(String s) {
        int n = s.length();
        if(n <= 1) return n;
        int max = Integer.MIN_VALUE , count = 1;
        for(int i = 1 ; i < n ; i++){
            if(s.charAt(i) == s.charAt(i-1) + 1) count++;
            else count = 1;
            max = Math.max(max , count);
        }
        return max;
    }
}