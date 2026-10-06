class Solution {
    public int minAddToMakeValid(String s) {
        int count = 0;
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == ')'){
                if(st.size() == 0) count++;
                else st.pop(); 
            }
            else st.push(ch);
        }

        return count + st.size();
    }
}