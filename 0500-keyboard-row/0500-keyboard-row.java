class Solution {
    public String[] findWords(String[] words) {
        ArrayList<String> arr = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 97 ; i <= 122 ; i++){
            char ch = (char)i;
            if(ch == 'z' || ch == 'x' || ch == 'c' || ch == 'v' || ch == 'b' || ch == 'n' || ch == 'm') map.put(ch,3);
            else if(ch == 'a' || ch == 's' || ch == 'd' || ch == 'f' || ch == 'g' || ch == 'h' || ch == 'j' || ch == 'k' || ch == 'l') map.put(ch , 2);
            else map.put(ch,1);
        }
        for(String l : words){
            String str = "";
            String k = l.toLowerCase();
            boolean flag = true;
            long idx = map.get(k.charAt(0));
            for(int i = 0 ; i < l.length(); i++){
                char a = k.charAt(i);
                if(idx != map.get(a)){
                    flag = false;
                    break;
                }
            }
            if(flag) arr.add(l);
        }
        return arr.toArray(new String[0]);
    }
}