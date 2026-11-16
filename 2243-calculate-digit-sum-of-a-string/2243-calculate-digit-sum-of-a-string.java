class Solution {
    public String helper(String s , int k){
        String a = "";
        int i = 0;
        while(i < s.length()){
            int l = i + k , sum = 0;
            while(i < s.length() && i < l){
                sum += Integer.parseInt("" + s.charAt(i));
                i++;
            }
            a += sum;
        }
        return a;
    }
    public String digitSum(String s, int k) {
        int n = s.length();
        while(s.length() > k){
            s = helper(s , k);
        }
        return s;
    }   
}