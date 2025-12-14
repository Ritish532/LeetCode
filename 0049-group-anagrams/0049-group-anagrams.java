class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String ele : strs){
            char[] ch = ele.toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);

            map.putIfAbsent(s,new ArrayList<>());
            map.get(s).add(ele);
        }
        return new ArrayList<>(map.values());

    }
}
// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         List<List<String>> ans = new ArrayList<>();

//         List<String> org = new ArrayList<>();
//         HashSet<String> sort = new HashSet<>();

//         for(String ele : strs) org.add(ele);

//         for(String ele : strs){
//             char[] ch = ele.toCharArray();
//             Arrays.sort(ch);
//             sort.add(new String(ch));
//         }

//         for(String s : sort){
//             List<String> temp = new ArrayList<>();

//             for(String ele : org){
//                 char[] ch = ele.toCharArray();
//                 Arrays.sort(ch);
//                 String l = new String(ch);
//                 if(s.equals(l)) temp.add(ele);
//             }
//             for(int i = 0 ; i < temp.size() ; i++) org.remove(temp.get(i));
//             ans.add(temp);
//         }
//         return ans;
//     }
// }