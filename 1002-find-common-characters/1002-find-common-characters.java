class Solution {
    public List<String> commonChars(String[] words) {
        int[] arr = new int[26];
        Arrays.fill(arr,Integer.MAX_VALUE);
        for(String s : words){
            char[] ch = s.toCharArray();
            int[] count = new int[26];
            for(char c : ch) count[c-'a']++;
            for(int i = 0 ;i < 26 ; i++) arr[i] = Math.min(arr[i] , count[i]);
        }
        List<String> ls = new ArrayList<>();
        for(int i = 0 ; i < 26 ; i++){
            while(arr[i] > 0) {
                ls.add("" +(char)(i+'a'));
                arr[i]--;
            }
        }
        return ls;
    }
}