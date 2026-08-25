class Solution {
    public boolean wordPattern(String pattern, String s) {
        String str[] = s.split(" ");
        if(pattern.length() != str.length) return false;
        HashMap<Character,String> map = new HashMap<>();
        HashMap<String,Character> map1 = new HashMap<>();
        for(int i = 0 ; i < pattern.length() ; i++){
            char a = pattern.charAt(i);
            if(map.containsKey(a) && !map.get(a).equals(str[i])) return false;
            if(map1.containsKey(str[i]) && !map1.get(str[i]).equals(a)) return false;
            map.put(a , str[i]);
            map1.put(str[i] , a);
        }
        return true;
    }
}