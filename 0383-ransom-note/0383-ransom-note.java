class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < magazine.length() ; i++) {
            char ch = magazine.charAt(i);
            map.put(ch , map.getOrDefault(ch , 0)+1);
        }
        for(int i = 0 ; i < ransomNote.length() ; i++){
            char ch = ransomNote.charAt(i);
            if(!map.containsKey(ch)) return false;
            else{
                int count = map.get(ch);
                if(count > 1) map.put(ch , count-1);
                else map.remove(ch);
            }
        }
        return true;
    }
}