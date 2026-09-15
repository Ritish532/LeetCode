class Solution {
    public int maxRepeating(String s, String w) {
        int count = 0;
        String t = w;
        while(s.contains(t)){
            count++;
            t += w;
        }
        return count;
    }
}