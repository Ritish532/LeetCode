class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(s.length == 0 || g.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0 , j = 0 , count = 0 , n = g.length , m = s.length;
        while(i < n && j < m){
            if(g[i] <= s[j]) {
                count++;
                i++;j++;
            }
            else j++;
        }
        return count;
    }
}