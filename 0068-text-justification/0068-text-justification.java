class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int n = words.length; int count = 0;
        int i = 0;
        while(i < n){
            int len = 0;
            int j = i;
            while(i < n && len < maxWidth){
                if(i > j) len++;
                len += words[i].length();
                if(len > maxWidth){
                    len -= words[i].length();
                    if(i > j) len--;
                    break;
                }
                i++;
            }
            StringBuilder s = new StringBuilder();
            int start = j;
            for(; j < i ; j++){
                s.append(words[j]);
                if(j != i-1) s.append(" ");
            }
            if(i == n || i-start == 1){
                while(s.length() < maxWidth){
                    s.append(" ");
                }
            }
            else{
                while(s.length() < maxWidth){
                    for(int l = 0 ; l < s.length() &&  s.length() < maxWidth ; l++){
                        if(s.charAt(l) == ' '){
                            s.replace(l , l+1 , "  ");
                            l++;
                        }
                        while(l < s.length() && s.charAt(l) == ' ')
                                l++;
                    }
                }
            }
            ans.add(s.toString());
        }
        return ans;
    }
}