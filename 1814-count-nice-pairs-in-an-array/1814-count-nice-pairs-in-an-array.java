class Solution {
    public int rev(int a){
        int x = 0;
        while(a>0){
            x = x*10 + (a%10);
            a = a/10;
        }
        return x;
    }

    public int countNicePairs(int[] nums) {
        int n = nums.length , i = 0;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(; i < n ; i++){
            int val = nums[i] - rev(nums[i]);
            if(map.containsKey(val)){
                count+=map.get(val);
                map.put(val , map.get(val)+1);
                count %= 1000000007;
            }
            else map.put(val,1);
        }
        return count;
    }
}