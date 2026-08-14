class Solution {
    public String reorderSpaces(String text) {
        int spaces= 0;
        StringBuilder ans = new StringBuilder();
        for(int i = 0 ; i < text.length() ; i++){
            char ch = text.charAt(i);
            if(ch == ' '){
                spaces++;
            }
        }
        text = text.trim().replaceAll(" +"," ");
        ans.append(text);

        int spa = 0;
        for(int i = 0 ; i < ans.length() ; i++){
            char ch = ans.charAt(i);
            if(ch == ' '){
                spa++;
            }
        }
        if(spa == 0){
            return ans.toString() + " ".repeat(spaces);
        }
        int words = spa ;
        int a = spaces/words;
        String b = ans.toString().replaceAll(" "," ".repeat(a));
        for(int j = 0 ; j < spaces % words ; j++) b += " ";
        return b;
    }
}