class Solution {
    public HashSet<Integer> set;
    public void helper(int[] digits , boolean[] flag , String s){
        if(s.length() == 3){
            if(s.charAt(0) != '0' && ((s.charAt(2)-'0' ) % 2) == 0) set.add(Integer.parseInt(s));
            return;
        }
        for(int i = 0 ; i < digits.length ; i++){
            if(flag[i]) continue;
            flag[i] = true;
            helper(digits , flag , s+digits[i]);
            flag[i] = false;
        }

    }
    public int totalNumbers(int[] digits) {
        set = new HashSet<>();
        int n = digits.length;
        boolean[] flag = new boolean[n];
        helper(digits , flag , "");
        return set.size();
    }
}