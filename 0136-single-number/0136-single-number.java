class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int ele : nums){
            ans ^= ele;
        }
        return ans;
    }
}
// class Solution {
//     public int singleNumber(int[] nums) {
//         Arrays.sort(nums);
//         int i = 0;
//         for(int j = 1 ; j < nums.length; j+=2){
//             if(nums[i] != nums[j]) return nums[i];
//             i+=2;
//         }
//         return nums[i];
//     }
// }