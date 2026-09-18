class Solution {
    public boolean judgeCircle(String moves) {
        int up = 0 , down = 0 , right = 0 , left = 0;
        for(int i = 0 ; i < moves.length() ; i++){
            char ch = moves.charAt(i);
            if(ch == 'U') up++;
            else if(ch == 'D') down++;
            else if(ch == 'R') right++;
            else left++;
        }
        return (left == right && up == down);
    }
}