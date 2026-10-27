class Solution {
    public int solve(int val1 , char op , int val2){
        if(op == '+') return val1 + val2;
        else return val1 - val2;
    }
    public int calculate(String s) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == ' ') continue;
            if(Character.isDigit(ch)){
                int num = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    num  = num*10 + (s.charAt(i)-'0');
                    i++;
                }
                st1.push(num);
                i--;
            }
            else{
                if(ch == '(') st2.push('(');
                if(ch ==')'){
                    while(!st2.isEmpty() && st2.peek() != '('){
                        char op = st2.pop();
                        int val2 = st1.pop();
                        int val1 = st1.pop();
                        st1.push(solve(val1 , op , val2));
                    }
                    st2.pop();
                }
                else{
                    if(ch == '+' || ch == '-'){
                        int j = i-1;
                        while(j >= 0 && s.charAt(j) == ' ') j--;
                        boolean unary = j < 0 || s.charAt(j) == '+' || s.charAt(j) == '-' || s.charAt(j) == '(';
                        if(unary){
                            st1.push(0);
                            st2.push('-');
                        }
                        else{
                            while(!st2.isEmpty() && st2.peek() != '('){
                            char op = st2.pop();
                            int val2 = st1.pop();
                            int val1 = st1.pop();
                            st1.push(solve(val1 , op , val2));
                        }
                        st2.push(ch);
                        }
                    }
                }
            }
        }
        while(st2.size() > 0){
            char op = st2.pop();
            int val2 = st1.pop();
            int val1 = st1.pop();
            st1.push(solve(val1 , op , val2));
        }
        return st1.pop();
    }
}