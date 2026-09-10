class Solution {
    public String makeGood(String s) {
        if(s.length() <= 1) return s;
        StringBuilder a = new StringBuilder();
        for(char ch : s.toCharArray()){
            int len = a.length();
            if(len > 0 && (ch+32 == (int) (a.charAt(len-1)) || a.charAt(len-1)+32 == (int)(ch))) a.deleteCharAt(len-1);
            else a.append(ch);
        }
        return a.toString();
    }
}