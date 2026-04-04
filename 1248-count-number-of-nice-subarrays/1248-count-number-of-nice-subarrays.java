class Solution {
public int numberOfSubarrays(int[] arr, int k) {
        for(int i = 0 ; i < arr.length ; i++) arr[i] = arr[i] % 2;

        int i = 0 , j = 0 , a = 0 , b = 0 , count = 0 , n = arr.length , m = 0;

        while(i < n && arr[i] == 0) i++;
        while(j < n && m < k) if(arr[j++] == 1) m++;
        if(m < k) return 0;
        j--;
        b = j + 1;
        while(b < n && arr[b] == 0) b++;
        b--;

        while(b < n){
            count += ((i-a+1) * (b-j+1));
            a = i + 1;
            i++;
            while(i < n && arr[i] == 0) i++;

            j = b+1;
            b+=2;
            while(b < n && arr[b] == 0) b++;
            b--;
        }
        return count;
    }
}