class Solution {
    public int titleToNumber(String s) {
        int ans = 0;
        int i = 0;
        while(i < s.length()){
            ans = ans * 26 + ( (int) (s.charAt(i) - 'A'+1));
            i++;
        }
        return ans;
    }
}