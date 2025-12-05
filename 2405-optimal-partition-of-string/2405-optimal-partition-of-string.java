class Solution {
    public int partitionString(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 1 , strt = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            boolean flag = false;
            while(set.contains(ch)){
                flag = true;
                set.remove(s.charAt(strt));
                strt++;
            }
            if(flag) count++;
            set.add(ch);
        }
        return count;
    }
}