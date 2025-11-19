class Solution {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int left = 0 , right = height.length - 1;
        while(left < right && left >= 0 && right < height.length){
            int width = right - left;
            int area = (Math.min(height[left] , height[right])) * width;
            max = Math.max(area , max);
            if(height[left] < height[right]) left++;
            else right--;
        }
        return max;
    }
}