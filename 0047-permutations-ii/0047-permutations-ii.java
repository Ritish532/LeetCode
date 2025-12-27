class Solution {
    public List<List<Integer>> ans;
    public void helper(int[] nums , boolean[] used , List<Integer> temp){
        if(temp.size() == nums.length){
            if(!ans.contains(temp))ans.add(new ArrayList<>(temp));
        }
        for(int i = 0; i < nums.length ; i++){
            if(used[i] == true) continue;
            used[i] = true;
            temp.add(nums[i]);
            helper(nums , used , temp);
            temp.remove(temp.size()-1);
            used[i] = false;
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        helper(nums , new boolean[nums.length] , new ArrayList<>());
        return ans;
    }
}