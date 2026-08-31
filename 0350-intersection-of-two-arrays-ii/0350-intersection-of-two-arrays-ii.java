class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int i = 0 , j = 0 , l = 0;
        int n = nums1.length , m = nums2.length;
        Arrays.sort(nums1); Arrays.sort(nums2);
        ArrayList<Integer> arr = new ArrayList<>();
        while(i < n && j < m){
            if(i < n && j < m && nums1[i] == nums2[j]){
                arr.add(nums1[i]);
                i++;j++;
            }
            else if(i < n && j < m && nums1[i] < nums2[j]) i++;
            else j++;
        }
        int[] ans = new int[arr.size()];
        for(int ele : arr) ans[l++] = ele;
        return ans;
    }
}