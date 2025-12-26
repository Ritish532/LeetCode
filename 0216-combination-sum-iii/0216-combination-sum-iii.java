class Solution {
    public List<List<Integer>> ans;
    public void helper(int k , int n , int idx , int sum , List<Integer> temp){
        if(sum == n && temp.size() == k){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(sum > n || temp.size() == k) return;
        for(int i = idx ; i <= n ; i++){
            if(i > 9) break;
            temp.add(i);
            helper(k , n , i + 1 , sum + i , temp);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        helper(k , n , 1 , 0 , new ArrayList<>());
        return ans; 
    }
}