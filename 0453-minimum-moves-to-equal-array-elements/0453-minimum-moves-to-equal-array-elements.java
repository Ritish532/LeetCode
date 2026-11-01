class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int count = 0;
        for(int i : nums) min = Math.min(min , i);
        for(int i : nums) count += i - min;
        return count;
    }
}