class Solution {
    public List<String> stringSequence(String target) {
        List<String> list = new ArrayList<>();
        String s = "";
        for(int i = 0 ; i < target.length() ; i++){
            s += "a";
            list.add(s);
            char ch = 'a';
            while(ch != target.charAt(i)){
                ch++;
                s = s.substring(0 , s.length()-1)+ch;
                list.add(s);
            }
        }
        return list;
    }
}