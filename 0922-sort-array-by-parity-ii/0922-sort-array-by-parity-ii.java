class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int i = 0 , j = 0 , n = nums.length;
        int[] ans = new int[n];
        int[] a = new int[n/2];
        int[] b = new int[n/2];
        for(int ele : nums) if(ele % 2 != 0) b[i++] = ele; else a[j++] = ele;
        i = 0 ; j = 0;
        for(int k = 0 ; k < n ; k++){
            ans[k] = a[i++];
            k++;
            ans[k] = b[j++];
        }
        return ans;
    }
}