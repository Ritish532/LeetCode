class Solution {
    public String convert(String s, int m) {
        if(m == 1) return s;
        int n = s.length();
        List<List<String>> arr = new ArrayList<>();

        for(int k = 0 ; k < m ; k++) arr.add(new ArrayList<>());

        int i = 0 , j = 0;
        while(i < n){
            while(i<n && j < m) arr.get(j++).add(""+s.charAt(i++));
            j-=2;
            while(i<n && j > 0) arr.get(j--).add(""+ s.charAt(i++));
        }
        StringBuilder str = new StringBuilder();
        for(List<String> lst : arr){
            for(String a : lst) str.append(a);
        }
        return str.toString();
    }
}