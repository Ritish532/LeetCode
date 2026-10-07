class Solution {
    public int min;
    public List<String> ans;
    public void dfs(int i , int m , int n , String s , String a){
        if(i == n){
            if(m <= min){
                int count = 0;
                for(int j = 0 ; j < a.length() ; j++){
                    char ch = a.charAt(j);
                    if(ch != '(' && ch != ')') continue;
                    if(ch == '(') count++;
                    else count--;
                    if(count < 0) return;
                }
                if(count != 0) return;
                if(m < min){
                    List<String> l = new ArrayList<>();
                    l.add(a);
                    ans = l;
                    min = m;
                }
                else if(min == m && !ans.contains(a))ans.add(a);    
            }
            return;
        }
        char ch = s.charAt(i);
        if(ch != ')' && ch != '(') dfs(i+1 , m , n , s , a+ch);
        else{
            dfs(i+1 , m+1 , n , s , a);
            dfs(i+1 , m , n , s , a+ch);
        }
        return;        
    }
    public List<String> removeInvalidParentheses(String s) {
        min = Integer.MAX_VALUE;
        ans = new ArrayList<>();
        dfs(0 , 0 , s.length() , s , "");
        return ans;
    }
}