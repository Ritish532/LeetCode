class Solution {
    public int countPalindromicSubsequence(String s) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();

        HashSet<String> set = new HashSet<>();
        for(int i = 0 ; i < s.length();i++) if(!map1.containsKey(s.charAt(i))) map1.put(s.charAt(i),i);
        
        for(int i = 0 ; i < s.length() ; i++) map2.put(s.charAt(i),i);

        for(char key : map1.keySet()){
            int freq1 = map1.get(key);
            int freq2 = map2.get(key);
            if(freq2 >= freq1+2){
                for(int i = freq1+1 ; i < freq2 ; i++){
                    String a = "" + key + s.charAt(i) + key;
                    set.add(a);
                }
            }

        }
        return set.size();
    }
}