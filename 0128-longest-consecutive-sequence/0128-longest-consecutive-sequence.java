class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        if (n <= 1) return n;

        int[] temp = new int[n];

        Arrays.sort(nums);

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1])
                temp[i] = 0;
            else
                temp[i] = nums[i] - nums[i - 1];
        }

        int count = 1;
        int max = 1;

        for (int i = 1; i < n; i++) {

            if (temp[i] == 0) {
                continue;       // duplicate
            }

            if (temp[i] == 1) {
                count++;        // consecutive
            }
            else {
                count = 1;      // break
            }

            max = Math.max(max, count);
        }

        return max;
    }
}