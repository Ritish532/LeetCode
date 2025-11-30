class Solution {
    public String rev(String s){
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        s = sb.toString();
        return s;
    }
    public int maximumNumberOfStringPairs(String[] words) {
        HashSet<String> set = new HashSet<>();
        set.add(words[0]);
        int count = 0;
        for(int i = 1 ; i < words.length ; i++){
            String s = words[i];
            if(set.contains(rev(s))){
                set.remove(s);
                count++;
                }
            else set.add(s);
        }
        return count;
    }
}