class Solution {
    public int beautySum(String s) {
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++){
            HashMap<Character,Integer> map = new HashMap<>();
            
            for(int j = i ; j < s.length() ; j++){
                if(map.containsKey(s.charAt(j))) map.put(s.charAt(j),map.get(s.charAt(j))+1);
                else map.put(s.charAt(j),1);
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for(int val : map.values()){
                    max = Math.max(max,val);
                    min = Math.min(min,val);
                }
                
                count += (max-min);
            }
            
        }
        return count;
    }
}