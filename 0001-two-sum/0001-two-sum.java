class Solution {
    public int[] twoSum(int[] nums, int k) {
        int[] arr = new int[2];
        for(int i = 0 ; i < nums.length-1 ; i++){
            for(int j = i+1 ; j < nums.length ; j++){
                int sum = nums[i] + nums[j];
                if(sum == k){
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return arr;
    }
}