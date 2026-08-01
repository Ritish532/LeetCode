class Solution {
    public boolean isPalindrome(String s1) {
        if(s1.length() == 1) return true;
        String s2 = s1.toLowerCase();
        String s3 = s2.replace(" ","");
        StringBuilder sb = new StringBuilder();
       for(int i = 0 ; i < s3.length() ; i++){
        char ch = s3.charAt(i);
        if((ch >= 97 && ch <= 122)  ||  (ch >= 48 && ch <= 57)) sb.append(ch);
       }
       String s = sb.toString();
        int i = 0 , j = s.length()-1;
        while(j > i){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}