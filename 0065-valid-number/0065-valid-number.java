class Solution {
    public boolean isNumber(String s) {
        boolean digitSeen = false;
        boolean eSeen = false;
        boolean dotSeen = false;
        boolean digitSeenAftere = true;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                digitSeen = true;
                if(eSeen) digitSeenAftere = true;
            }
            else if(ch == '.'){
                if(dotSeen || eSeen) return false;
                dotSeen = true;
            }
            else if(ch == '+' || ch == '-'){
                if(i != 0 && s.charAt(i-1) != 'E' && s.charAt(i-1) != 'e') return false;
            }
            else if(ch == 'e' || ch == 'E'){
                if(!digitSeen || eSeen) return false;
                eSeen = true;
                digitSeenAftere = false;
            }
            else return false;
        }
        return digitSeen && digitSeenAftere;
    }
}