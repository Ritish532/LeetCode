class Solution {
    public List<String> ans;
    public void dfs(String s , int i , StringBuilder temp){
        if(temp.length() == s.length()){
            ans.add(temp.toString());
            return;
        }
            if((s.charAt(i) >= 65 && s.charAt(i) <= 90) || (s.charAt(i) >= 96 && s.charAt(i) <= 122)){
                char ch = s.charAt(i);
                ch = Character.toLowerCase(ch);
                temp.append(ch);
                dfs(s , i+1 , temp);
                temp.deleteCharAt(temp.length()-1);

                ch = Character.toUpperCase(ch);
                temp.append(ch);
                dfs(s , i+1 , temp);
                temp.deleteCharAt(temp.length()-1);
            }
            else{
                temp.append(s.charAt(i));
                dfs(s , i+1 , temp);
                temp.deleteCharAt(temp.length()-1);
            }
    }
    public List<String> letterCasePermutation(String s) {
        ans = new ArrayList<>();
        dfs(s , 0 , new StringBuilder());
        return ans;
    }
}