class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int sum = Integer.MAX_VALUE;
        for(int i = 0 ; i < nums.size() ; i++){
            int s = nums.get(i);
            if(1 >= l && 1 <= r && s > 0) sum = Math.min(sum , s);
            for(int j = i+1 ; j < nums.size() ; j++){
                int c = j-i+1;
                s += nums.get(j);
                if(c >= l && c <= r && s > 0) sum = Math.min(sum , s);
            }
        }
        if(sum == Integer.MAX_VALUE) return -1;
        return sum;
    }
}