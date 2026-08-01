import java.math.BigInteger;

class Solution {
    public int[] plusOne(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for(int i : digits){
            sb.append(i);
        }
        BigInteger big = new BigInteger(sb.toString());
        big = big.add(BigInteger.ONE);
        String s = big.toString();
        int[] ans = new int[s.length()];
        for(int i = 0 ; i < s.length() ; i++){
            ans[i] = s.charAt(i)-'0';
        }
        return ans;
    }
}