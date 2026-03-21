class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);

        for(int i = 1 ; i < nums.length ; i++){
            nums[i] += nums[i-1];
        }

        int[] ans = new int[queries.length];
        for(int j = 0; j < queries.length ; j++){
            int x = queries[j];
            int low = 0 , high = nums.length-1 , mid = low + ((high-low) / 2);

            while(low <= high){
                mid = low + ((high-low) / 2);
                if(nums[mid] > x) high = mid-1;
                else{
                    low = mid+1;
                    ans[j] = Math.max(ans[j] , mid+1);
                }
            }
        }
        return ans;
    }
}