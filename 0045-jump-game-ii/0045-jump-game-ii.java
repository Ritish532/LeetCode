class Solution {
    public int jump(int[] nums) {
        int jump = 1 , i = 0 , n = nums.length;
        if(n == 1) return 0;
        while(i < n-1){
            int k = nums[i];
            if(i+k >= n-1) return jump;
            jump++;
            int maxi = 0 , max = -1 , j = 1;
            while(k > 0){
                if(j+i == n-1) return jump;
                if(max <= i+ j + nums[i+j]){
                    max = i + j + nums[i+j];
                    maxi = i+j;
                }
                k--;
                j++;
            }
            i = maxi;
        }
        return jump;
    }
}