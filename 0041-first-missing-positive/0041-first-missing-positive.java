class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 1){
            if(nums[0] == 0) return 1;
            else if(nums[0] == 1) return 2;
            else return 1;
        }
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length && nums[i] <= 0) i++;
        if(i == nums.length) return 1;
        int k = 1;int j = i ;
        for(; j < nums.length;  j++){
            if(j > 0 && nums[j] == nums[j-1]) continue;
            if(nums[j] != k) return k;
            else k++;
        }
        return k;
    }
}

