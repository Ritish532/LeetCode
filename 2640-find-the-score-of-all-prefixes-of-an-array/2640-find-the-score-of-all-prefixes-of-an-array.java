class Solution {
    public long[] findPrefixScore(int[] nums) {
        long[] ans = new long[nums.length];
        long max = (long)nums[0];
        for(int i = 0 ; i < nums.length ; i++){
            max = Math.max(max , (long) nums[i]);
            ans[i] = (long)nums[i] + max;
        }
        for(int j = 1 ; j < nums.length ; j++) ans[j] += ans[j-1];
        return ans;
    }
}

// [4 , 6 , 14 , 12 , 20 ]
// [4 , 10 , 24 , 36 , 56]