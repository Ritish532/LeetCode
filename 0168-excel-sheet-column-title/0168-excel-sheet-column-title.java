class Solution {
    public String convertToTitle(int i) {
        String ans = "";
        while(i > 0){
            i--;
            ans = ( (char) (i % 26 + 'A')) + ans;
            i/=26;
        }
        return ans;
    }
}