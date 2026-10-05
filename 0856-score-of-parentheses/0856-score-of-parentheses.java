class Solution {
    public int scoreOfParentheses(String s) {
        int ans = 0 , i = 0 , n = s.length() , count = 0;
        for(; i< n ; i++){
            if(s.charAt(i) == '(') count++;
            else{
                count--;
                if(s.charAt(i-1) == '(') ans += (int)Math.pow(2,count);
            }
        }
       return ans;
    }
}