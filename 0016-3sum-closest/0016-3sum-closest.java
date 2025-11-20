class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int closest = Integer.MAX_VALUE , final_sum = 0;
        Arrays.sort(nums);
        for(int i = 0 ; i < n ; i++){
            if(i > 0 && nums[i] == nums[i-1])continue;
            int left = i+1 , right = n-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                int closer = Math.abs(target - sum);
                if(closer < closest){
                    closest = closer;
                    final_sum = sum;
                }
                if(sum > target) right--;
                else left++;
            }
        }
        return final_sum; 
    }
}

// 0 0 0