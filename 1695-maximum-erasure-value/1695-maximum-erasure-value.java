class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int strt = 0,sum =0;
        for(int ele : nums){
            while(set.contains(ele)){
                set.remove(nums[strt]);
                strt++;
            }
            set.add(ele);
            int temp = 0;
            for(int val : set) temp += val;

            sum = Math.max(sum,temp);
        }
        
        return sum;
    }

}