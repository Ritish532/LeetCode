class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0 , j = 0 , n = nums.length;
        if(n == 1) return nums;
        int[] ans = new int[n];
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for(int ele : nums) if(ele % 2 != 0) b.add(ele); else a.add(ele);
        i = 0 ; j = 0;
        for(int k = 0 ; k < n ; k++){
            if(i < a.size()) ans[k] = a.get(i++);
            else ans[k] = b.get(j++);
        }
        return ans;
    }
}