class Solution {
    public String largestOddNumber(String num) {
        int n = num.length()-1;
        int i = n;
        for(; i  >= 0 ; i--){
            if((num.charAt(i)-'0')  % 2 != 0) break;
        }
        return (i < 0)? "" : num.substring(0,i+1);
    }
}