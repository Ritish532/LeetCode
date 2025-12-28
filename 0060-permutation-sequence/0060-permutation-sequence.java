class Solution {
    public String ans;
    public int count;
    public void helper(int n , boolean[] used , StringBuilder sb){
        if(sb.length() == n){
            count--;
            if(count == 0){
                ans = sb.toString();
                return;
            }
        }
        for(int i = 1 ; i <= n ; i++){
            if(used[i-1]) continue;

            used[i-1] = true;

            sb.append(i);
            helper(n , used , sb);
            sb.deleteCharAt(sb.length()-1);

            used[i-1] = false;
            
        }
    }
    public String getPermutation(int n, int k) {
        ans = "";
        count = k;
        helper(n , new boolean[n] , new StringBuilder());
        return ans;
    }
}