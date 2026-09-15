class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int total = (1<<n);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i < total ; i++){
            List<Integer> arr = new ArrayList<>();
            for(int j = 0 ; j < n ; j++){
                int mask = (1<<j);
                if((i & mask )!= 0) arr.add(nums[j]);
            }
            ans.add(arr);
        }
        return ans;
    }
}