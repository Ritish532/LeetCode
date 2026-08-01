class Solution {
    public List<String> ans;
    public List<String> pair;
    public void Solve(int idx , String str , String digits){
        if(idx == digits.length()){
            ans.add(str);
            return ;
        }
        int digit = digits.charAt(idx) - '0';

        for(int i = 0 ; i < pair.get(digit).length() ; i++){
            Solve(idx+1 , str + pair.get(digit).charAt(i) , digits);
        }
    }
    public List<String> letterCombinations(String digits) {
        pair = Arrays.asList("" , "", "abc" , "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");
        ans = new ArrayList<>();
        int n = digits.length();
        if(n==0) return ans;
        Solve(0,"",digits);
        return ans;
    }
}