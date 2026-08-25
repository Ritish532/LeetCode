class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ls = new ArrayList<>();
        for(int i = 0 ; i < words.length ; i++){
            HashMap<Character , Character> map = new HashMap<>();
            HashMap<Character , Character> map1 = new HashMap<>();
            if(words[i].length() != pattern.length()) continue;
            boolean flag = true;
            for(int j = 0 ; j < words[i].length() ; j++){
                char a = words[i].charAt(j);
                char b = pattern.charAt(j);
                if((map.containsKey(a) && !map.get(a).equals(b)) || (map1.containsKey(b) && !map1.get(b).equals(a))){
                    flag = false;
                    break;
                } 
                map.put(a,b);
                map1.put(b,a);
            }
            if(flag) ls.add(words[i]);
        }
        return ls;
    }
}