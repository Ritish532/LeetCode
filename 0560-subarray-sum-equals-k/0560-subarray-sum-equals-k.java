class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 1 ; i < nums.length ; i++) nums[i] += nums[i-1];

        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == k) count++;
            int rem = nums[i] - k;
            if(map.containsKey(rem)){
                int freq = map.get(rem);
                count += freq;
            }
            if(map.containsKey(nums[i])) map.put(nums[i] , map.get(nums[i]) + 1);
            else map.put(nums[i] , 1);
        }
        return count;
    }
}