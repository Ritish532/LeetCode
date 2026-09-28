class Solution {
    public int maxDepth(String s) {
        int max = 0;
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == '(') st.add('(');
            else if(ch == ')') st.pop();
            max = Math.max(st.size() , max);
        }
        return max;
    }
}