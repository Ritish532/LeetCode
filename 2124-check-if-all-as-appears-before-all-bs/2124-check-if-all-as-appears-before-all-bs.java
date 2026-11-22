class Solution {
    public boolean checkString(String s) {
        int i = 0;
        while(i < s.length()) if(s.charAt(i) != 'a') break; else i++;
        while(i < s.length()) if(s.charAt(i) == 'a') return false; else i++;
        return true;
    }
}