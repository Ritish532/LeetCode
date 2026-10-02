class Solution {
    List<String> ans;
    public void helper(String s , int i , int j , int n){
        if(i == n && j == n){
            ans.add(s);
            return;
        }
        if(i < n ) helper(s+"(" , i+1 , j , n);
        
        if(j < i) helper(s+")" , i , j+1 , n);
    }
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        helper("(" , 1 , 0 , n);
        return ans;
    }
}