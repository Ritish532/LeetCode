class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] s = sentence.split(" ");
        int n = s.length;
        boolean flag = true;
        for(int i = 0 ; i < n ; i++){
            char c1 = s[i].charAt(s[i].length()-1);
            char c2 = (i == n-1)? s[0].charAt(0) : s[i+1].charAt(0);
            if(c1 != c2) flag = false;
            if(!flag) return false;
        }
        return true;
    }
}