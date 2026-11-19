class Solution {
    public int maxProduct(String[] words) {
        int max = 0;
        for(int i = 0 ; i < words.length ; i++){
            String s = words[i];
            int[] freq = new int[26];
            for(int k = 0 ; k < s.length() ; k++) freq[s.charAt(k) - 'a']++ ;
            for(int j = i+1 ; j < words.length ; j++){
                String s1 = words[j];
                boolean flag = true;
                for(int l = 0 ; l < s1.length() ; l++){
                    if(freq[s1.charAt(l)-'a'] != 0){
                        flag = false;
                        break;
                    }
                }
                if(flag) max = Math.max(max , s1.length()*s.length());
            }
        }
        return max;
    }
}