class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int ele : nums){
            if(set.contains(ele)){
                arr.add(ele);
            }
            else set.add(ele);
        }
        int ans = 0;
        for(int i = 0 ; i < arr.size() ; i++) ans ^= arr.get(i);
        return ans;
    }
}