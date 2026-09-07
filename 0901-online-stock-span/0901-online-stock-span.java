class StockSpanner {
    public Stack<Integer> st;
    public Stack<Integer> st2;
    public StockSpanner() {
        st = new Stack<>();
        st2 = new Stack<>();
    }
    
    public int next(int price) { 
        int count = 1;
        while(st.size() > 0 && st.peek() <= price){
            count += st2.pop();
            st.pop();
        }
        st.push(price);
        st2.push(count);
        
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */