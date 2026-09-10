class Solution {
    public String makeGood(String s) {
        if(s.length() <= 1) return s;
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(st.size() > 0 && (ch+32 == (int) (st.peek()) || st.peek()+32 == (int) (ch))) st.pop();
            else st.add(ch);
        }
        String a = "";
        while(st.size() > 0){
            a = a + st.pop();
        }
        return new StringBuilder(a).reverse().toString();
    }
}