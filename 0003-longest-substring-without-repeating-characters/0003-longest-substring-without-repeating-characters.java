class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0 , strt = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            while(set.contains(ch)){
                set.remove(s.charAt(strt));
                strt++;
            }
            set.add(ch);
            count = Math.max(count,set.size());
        }
        return count;

    }
}