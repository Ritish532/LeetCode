class Solution {
    public int findFinalValue(int[] nums, int var) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int ele : nums) arr.add(ele);

        while(true){
            if(!arr.contains(var)) return var;
            var = var * 2;
        }
    }
}