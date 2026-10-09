class Solution {
    public int minInsertions(String s) {
        int count = 0 , ans = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                count += 2;
                if(count % 2 != 0){
                    count--;
                    ans++;
                }
            }
            else{
                count--;
                if(count < 0){
                    count = 1;
                    ans++;
                }
            }
        }
        return ans + count;
    }
}