class Solution {
    public int longestSubarray(int[] arr) {
        int i = 0 , j = 0 , maxLen = 0 , n = arr.length , count = 0;int ele = 0 ;
        for(; ele < n ; ele++) if(arr[ele] == 0) break;
        if(ele == n) return n-1;

        while(i<n && arr[i] == 0) i++;
        j = i;

        while( i < n && j < n){
            while(j < n && count < 2){
                if(arr[j] == 0) count++;
                j++;
            }
            int len = j - i - count;
            while(i < n && arr[i] == 1)i++;
            i++;
            count--;
            maxLen = Math.max(maxLen , len);
        }
        int len = j - i -1;
        maxLen = Math.max(maxLen , len);
        return maxLen;

    }
}