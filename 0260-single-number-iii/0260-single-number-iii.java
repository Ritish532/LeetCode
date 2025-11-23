class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums.length == 2) return nums;
        int[] arr = new int[2];
        Arrays.sort(nums);
        int i = 0 , j = 1 , k = 0;
        while(j < nums.length){
            int count = 0;
            while(j < nums.length && nums[i] == nums[j]){
                count++;
                j++;
            }
            if(count == 0) arr[k++] = nums[i];
            if(k == 2) break;
            i = j;
            j++;
        }
        if(nums[i] != nums[i-1]) arr[1] = nums[i];
        return arr;
    }
}

// 1 1 2 2 3 5

// 0 1 2 2