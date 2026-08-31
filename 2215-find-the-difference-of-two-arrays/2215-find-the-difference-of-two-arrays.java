class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int ele : nums1) set1.add(ele);
        for(int ele : nums2) set2.add(ele);
        for(int ele : nums1) if(set2.contains(ele)) {set1.remove(ele); set2.remove(ele);} 
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        for(int ele : set1) ans.get(0).add(ele);
        for(int ele : set2) ans.get(1).add(ele);
        return ans;
    }
}