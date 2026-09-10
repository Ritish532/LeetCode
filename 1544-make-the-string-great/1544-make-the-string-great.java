class Solution {
    public String makeGood(String s) {
        if(s.length() <= 1) return s;
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(st.size() > 0 && (ch+32 == (int) (st.peek()) || st.peek()+32 == (int) (ch))) st.pop();
            else st.add(ch);
        }
        StringBuilder a = new StringBuilder();
        for(char ch : st){
            a.append(ch);
        }
        return a.toString();
    }
}