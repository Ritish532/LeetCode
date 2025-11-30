class Solution {
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele : nums){
            set.add(ele);
            int r = 0;
            while(ele > 0){
                r = r*10 + ele%10;
                ele /= 10;
            }
            set.add(r);
        }
        return set.size();
    }
}