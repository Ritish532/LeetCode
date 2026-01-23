class Solution {
    public int[] findEvenNumbers(int[] digits) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : digits){
            if(map.containsKey(ele)) map.put(ele , map.get(ele) + 1);
            else map.put(ele,1);
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 100 ; i <= 999 ; i+=2){
            int x = i;
            int a = x%10; x/= 10;
            int b = x%10; x/= 10;
            int c = x%10; x/= 10;
            if(map.containsKey(a)){
                int a_freq = map.get(a);
                map.put(a,a_freq-1);
                if(a_freq == 1) map.remove(a);
                if(map.containsKey(b)){
                    int b_freq = map.get(b);
                    map.put(b,b_freq-1);
                    if(b_freq == 1) map.remove(b);
                    if(map.containsKey(c)){
                        arr.add(i);
                    }
                    map.put(b,b_freq);
                }
                map.put(a,a_freq);
            }
        }
        int[] ans = new int[arr.size()];
        for(int i = 0 ; i < arr.size(); i++) ans[i] = arr.get(i);
        return ans;
    }
}