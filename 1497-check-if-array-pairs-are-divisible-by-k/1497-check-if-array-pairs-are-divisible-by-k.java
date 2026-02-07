class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=  0; i < arr.length ; i++){
            int ele = arr[i] % k;
            if(ele < 0) ele += k;
            if(map.containsKey(ele)) map.put(ele,map.get(ele)+1);
            else map.put(ele,1);
        }       
        if(map.containsKey(0)){
            if(map.get(0) % 2 != 0) return false;
            map.remove(0);
        }
        for(int key : map.keySet()){
            int rem = k - key;
            if(!map.containsKey(rem)) return false;
            if(map.get(rem) != map.get(key)) return false;
        }
        return true;
    }
}