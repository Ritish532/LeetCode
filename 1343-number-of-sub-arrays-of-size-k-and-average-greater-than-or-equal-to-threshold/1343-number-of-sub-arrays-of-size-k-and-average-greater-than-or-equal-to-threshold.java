class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length , count = 0 , i = 0 , j = k-1 , sum = 0;
        for(int l = 0 ; l < k ; l++) sum += arr[l];
        if(sum/k >= threshold) count++;
        i++;j++;
        while(j < n){
            sum = sum + arr[j] - arr[i-1];
            if((sum)/k >= threshold) count++;
            i++;j++;
        }
        return count;
    }
}