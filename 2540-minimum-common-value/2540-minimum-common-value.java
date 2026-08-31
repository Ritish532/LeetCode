class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        TreeSet<Integer> set1 = new TreeSet<>();
        TreeSet<Integer> set2 = new TreeSet<>();
        for(int ele : nums1) set1.add(ele);
        for(int ele : nums2) set2.add(ele);
        set1.retainAll(set2);
        if(set1.isEmpty()) return -1;
        return set1.first();
    }
}