class Solution {
    public String[] divideString(String s, int k, char fill) {
        int i = s.length() % k;
        if(i != 0) for(; i < k ; i++) s += fill;
        int n = s.length();
        String[] str = new String[n/k];
        int count = 0 , j = 0;String a = "";
        for(int g = 0 ; g < n ; g++){
            if(count == k){
                str[j++] = a;
                count = 0;
                a = "";
            }
            a += s.charAt(g);
            count++;
        }
        if(count == k){
            str[j] = a;
        }
        return str;

    }
}