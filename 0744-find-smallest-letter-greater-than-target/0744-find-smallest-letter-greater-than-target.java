class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char ch = target;
        for(int i = 0 ; i < letters.length ; i++) if(letters[i] > ch) return letters[i];
        return letters[0];
    }
}