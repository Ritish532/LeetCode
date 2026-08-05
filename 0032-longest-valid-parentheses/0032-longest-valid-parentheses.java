class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int i = 0 , n = s.length() , count = 0 , max = 0;
        st.push(-1);
        if(n == 0) return 0;
        while(i < n){
            if(s.charAt(i) == '('){
                st.push(i);
            }
            else{
                st.pop();
                if(st.isEmpty()) st.push(i);
                else max = Math.max(max , i-st.peek());
            }
            i++;
        }
        return max;
    }
}