class Solution {
    public int countPalindromicSubsequence(String s) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();

        for(int i = 0 ; i < s.length();i++){
            if(!map1.containsKey(s.charAt(i))) map1.put(s.charAt(i),i);
            map2.put(s.charAt(i),i);
        }
        
        int count = 0;
        for(char key : map1.keySet()){
            int freq1 = map1.get(key);
            int freq2 = map2.get(key);
            HashSet<Character> set = new HashSet<>();
            for(int i = freq1+1 ; i < freq2 ; i++){
                char a = s.charAt(i);
                set.add(a);
            }
            count += set.size();

        }
        return count;
    }
}