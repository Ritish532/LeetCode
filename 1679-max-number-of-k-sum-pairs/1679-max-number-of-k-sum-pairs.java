class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0 ;
        for(int num : nums){
            int need = k - num;
            if(map.containsKey(need) && map.get(need) > 0){
                count++;
                int freq = map.get(need)-1;
                if(freq ==0) map.remove(need);
                else map.put(need,freq);
            }
            else{
                if(map.containsKey(num)) map.put(num,map.get(num)+1);
                else map.put(num,1);
            }
        }
        
        return count;
    }
}