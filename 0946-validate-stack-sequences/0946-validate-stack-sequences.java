class Solution {
    public boolean validateStackSequences(int[] a, int[] b) {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        for(int i = b.length-1 ; i >= 0 ; i--) st2.push(b[i]);
        for(int i = 0 ; i < a.length ; i++){
            st.push(a[i]);
            while(st.size() > 0 && st2.peek().equals(st.peek())){
                st2.pop();
                st.pop();
            }
        }
        while(st.size() > 0 && st2.peek() == st.peek()){
            st2.pop();
            st.pop();
        }
        return st.isEmpty();
    }
}