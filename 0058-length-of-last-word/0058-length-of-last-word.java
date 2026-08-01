class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length() == 1) return 1;
        int i = s.length()-1;
        while(i > 0 && s.charAt(i) == ' ') i--;
        int j = i;
        while(i >= 0 && s.charAt(i) != ' ') i--;
        return j-i;
    }
}