class Solution {
    public String evaluate(String s, List<List<String>> kn) {
        HashMap<String,String> map = new HashMap<>();
        for(List<String> x : kn) map.put(x.get(0) , x.get(1));
        StringBuilder sb = new StringBuilder(s);
        int idx = sb.indexOf("(");
        int Lidx;
        while(idx != -1){
            Lidx = sb.indexOf(")",idx);
            String key = sb.substring(idx+1,Lidx);
            String value = map.getOrDefault(key , "?");
            sb.replace(idx , Lidx+1 , value);
            idx = sb.indexOf("(" , idx);
        }
        return sb.toString();
    }
}