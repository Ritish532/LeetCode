class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        int reach = 0;
        boolean flag = false;
        for(int i = 0 ; i < n-1 ; i++){
            if (i + nums[i] >= n - 1)
                return reach + 1;
            int max = -1 , maxi = i;
            int j = 1;
            while(j+i < n && j <= nums[i]){
                if(max < i+j+nums[j+i]){
                    max = i+j+ nums[j+i];
                    maxi = j+i;
                }
                j++;
            }
            reach++;
            // if(max >= n-1) return reach;
            i = maxi-1;
        }
        return reach;
    }
}