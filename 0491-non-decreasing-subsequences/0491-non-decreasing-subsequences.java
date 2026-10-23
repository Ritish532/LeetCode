class Solution {
    public List<List<Integer>> ans;
    public void dfs(int i , int[] nums , List<Integer> temp , boolean[] used){
        if(temp.size() >= 2){
            ans.add(new ArrayList<>(temp));
        }
        Set<Integer> set = new HashSet<>();
        for(int j = i ; j < nums.length ; j++){
            if(set.contains(nums[j])) continue;
            if(!temp.isEmpty() && nums[j] < temp.get(temp.size()-1)) continue;
            used[j] = true;
            set.add(nums[j]);
            temp.add(nums[j]);
            dfs(j+1 , nums , temp , used);
            temp.remove(temp.size()-1);
            used[j] = false;
        }
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        ans = new ArrayList<>();
        dfs(0 , nums , new ArrayList<>() , new boolean[nums.length]);
        return ans;
    }
}