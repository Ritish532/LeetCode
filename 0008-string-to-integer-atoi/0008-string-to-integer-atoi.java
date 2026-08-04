class Solution {
    public int myAtoi(String s) {
        int a = 1 , i = 0 , n = s.length();
        while( i < n && (s.charAt(i) == ' ' || s.charAt(i) == 0)) i++;  
        if( i < n && s.charAt(i) == '-'){
            a = -1;i++;
        }
        else if(i < n && s.charAt(i) == '+') i++;
        long no = 0;
        while(i < n){
            if(s.charAt(i) >= 48 && s.charAt(i) <= 57){
                int l = s.charAt(i) - '0';
                no = no*10 + l;
                i++;
                if(a == 1 && no > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if(a == -1 && -no < Integer.MIN_VALUE) return -Integer.MIN_VALUE;
            }
            else{
                break;
            }
        }
        return (int) no*a;

    }
}