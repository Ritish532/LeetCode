class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for(int ele : nums){
            if(set.contains(ele)){
                ans ^= ele;
            }
            else set.add(ele);
        }
        return ans;
    }
}