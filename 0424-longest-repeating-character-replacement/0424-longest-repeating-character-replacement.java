class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int ans = 0 , maxFreq = 0 , left = 0;
        for(int ryt = 0 ; ryt < s.length() ; ryt++){
            int idx = s.charAt(ryt) - 'A';
            freq[idx]++;
            maxFreq = Math.max(maxFreq , freq[idx]);
            int len = ryt - left + 1;
            int changes = len - maxFreq;
            if(changes > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            ans = Math.max(ans , ryt - left + 1);
        }
        return ans;
    }
}