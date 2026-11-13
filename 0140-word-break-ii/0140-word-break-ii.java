class Solution {
    public List<String> ans;
    public void dfs(int i , String s , HashSet<String> set , String s1 , String a){
        if(i == s.length()){
            if(s1.isEmpty()) ans.add(a.trim());
            return;
        }
        s1 += s.charAt(i);
        if(set.contains(s1)){
            dfs(i+1 , s , set , "" , a + s1 + " ");
        }
        dfs(i+1 , s , set , s1 , a);
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(String s1 : wordDict) set.add(s1);
        ans = new ArrayList<>();
        dfs(0 , s , set , "" , "");
        return ans;
    }
}