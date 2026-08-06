class Solution {
    public boolean search(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele : nums) set.add(ele);
        return set.contains(target);
    }
}