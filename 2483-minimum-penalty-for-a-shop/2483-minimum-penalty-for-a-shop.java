class Solution {
    public int bestClosingTime(String s) {
        int n = s.length();
        int prefix[] = new int[n+1];
        prefix[0] = 0;
        int suffix[] = new int[n+1];
        suffix[n] = 0;
        int count = 0;
        for(int i = 0;  i < n ; i++){
            prefix[i+1] += prefix[i];
            if(s.charAt(i) == 'N') prefix[i+1] += 1;
        }
        count = 0;
        for(int i = n-1 ; i >= 0 ; i--){
            suffix[i] += suffix[i+1];
            if(s.charAt(i) == 'Y') suffix[i] += 1; 
        }
        int min = Integer.MAX_VALUE;
        count = 0;
        for(int i = 0; i <= n ; i++){
            prefix[i] += suffix[i];
            if(min > prefix[i]){
                min = prefix[i];
                count = i;
            }
        }
        return count;
    }
}

// 0 0 0 1 1
// 3 2 1 1 0
// 3 2 1 2 1