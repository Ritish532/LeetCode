class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(set.contains(ch)){
                count = Math.max(count,set.size());
                set.clear();
            }
            set.add(ch);
        }
        return count;

    }
}