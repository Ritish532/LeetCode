class Solution {
    public List<List<String>> ans;
    public boolean palindrome(String s){
        int i = 0 , j = s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
    public void dfs(int i , String a , String s , List<String> arr){
        int n = s.length();
        if(i == n){
            ans.add(new ArrayList<>(arr));
            return;
        }
        for(int j = i; j < n ; j++){
            char ch = s.charAt(j);
            a = a + ch;
            if(palindrome(a)){
                arr.add(a);
                dfs(j+1 , "" , s , arr);
                arr.remove(arr.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        dfs(0 , "" , s , new ArrayList<>());
        return ans;  
    }
}