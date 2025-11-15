class Solution {
    public boolean isValidSerialization(String s) {
        String[] c = s.split(",");
        int v = 1;
        for(String ch : c){
            v--;
            if(v < 0) return false;
            if(!ch.equals("#")) v += 2; 
        }
        return v == 0;
    }
}