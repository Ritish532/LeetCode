class Solution {
    public int[] twoSum(int[] no, int target) {
        int[] ans = new int[2];
        int n = no.length;
        int lft = 0 , ryt = n-1;
        while(lft < ryt){
            if(no[lft] + no[ryt] == target){
                ans[0] = lft+1;
                ans[1] = ryt+1;
                break;
            }
            else if(no[lft] + no[ryt] > target) ryt--;
            else lft++;
        }
        return ans;
    }
}