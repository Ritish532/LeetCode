class Solution {
    public int minSwaps(String s) {
        int min1 = 0 , min2 = 0 , n1 = 0 , n0 = 0;
        String s1 = "" , s2 = "";
        int n = s.length();
        for(int i = 0 ; i < n ; i++){
            s1 += (i % 2 == 0)? "1" : "0";
            s2 += (i % 2 == 0)? "0" : "1";
            if(s.charAt(i) == '1') n1++;
            else n0++;
            if(s.charAt(i) != s1.charAt(i)) min1++;
            if(s.charAt(i) != s2.charAt(i)) min2++;
        }
        if(Math.abs(n1-n0) >= 2) return -1;
        if(n1 > n0) return min1/2;
        if(n1 < n0) return min2/2;
        return Math.min(min1 , min2) / 2;
    }
}