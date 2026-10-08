class Solution {
    public String removeOuterParentheses(String s) {
        String ans = "";
        int i = 0 ;
        while(i < s.length()){
            int count = 0;
            while(i < s.length()){
                char ch = s.charAt(i);
                if(ch == '('){
                    count++;
                    if(count > 1) ans += '(';
                }
                else{
                    count--;
                    if(count > 0) ans+= ')'; 
                }
                i++;
                if(count == 0) break;
            }
        }
        return ans;
    }
}