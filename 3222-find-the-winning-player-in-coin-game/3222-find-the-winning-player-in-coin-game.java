class Solution {
    public String winningPlayer(int x, int y) {
        int a = Math.min(x,y/4);
        if(a % 2 != 0) return "Alice";
        return "Bob";
    }
}