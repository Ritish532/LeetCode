class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int i = 0 , j = 0 , sum = 0 , minLen = Integer.MAX_VALUE , n = arr.length;
        while(j < n && sum < target) sum += arr[j++];
        j--;
        while(i < n && j < n){
            int len = j-i+1;
            if(sum >= target) minLen = Math.min(minLen , len);
            sum -= arr[i];
            i++;j++;
            while(j < n && sum < target) sum += arr[j++];
            j--;
        }
        if(minLen == Integer.MAX_VALUE) return 0;
        return minLen;
    }
}