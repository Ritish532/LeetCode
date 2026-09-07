class Solution {
    public Stack<Integer> st;
    public void work(String s){
        int j = st.pop();
        int i = st.pop();
        if(s.equals("+")) st.push(i+j);
        else if(s.equals("-")) st.push(i-j);
        else if(s.equals("*")) st.push(i*j);
        else st.push(i/j);
    }
    public int evalRPN(String[] tokens) {
        st = new Stack<>();
        for(int i = 0 ; i < tokens.length ; i++)if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("/") || tokens[i].equals("*")) work(tokens[i]); else st.push(Integer.parseInt(tokens[i]));    
        int x = st.peek();
        return x;
    }
}