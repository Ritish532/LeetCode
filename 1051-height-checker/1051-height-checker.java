class Solution {
    public int heightChecker(int[] height) {
        int[] arr = new int[height.length];
        for(int i = 0; i < height.length;i++) arr[i] = height[i];
        Arrays.sort(arr);
        int count = 0;
        for(int j = 0 ; j < height.length ; j++){
            if(arr[j] != height[j]) count++;
        }
        return count;
    }
}