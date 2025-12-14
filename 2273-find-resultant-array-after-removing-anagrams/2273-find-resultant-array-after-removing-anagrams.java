class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        String prev = "";

        for(String s : words){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String ss = new String(ch);

            if(!prev.equals(ss)){
                ans.add(s);
                prev = ss;
            }
            
        }
        return ans;
    }
}