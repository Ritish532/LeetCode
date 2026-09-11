class Solution {
    public String largestNumber(int[] nums) {
        String[] ans = new String[nums.length];
        for(int i = 0 ; i < nums.length ; i++) ans[i] = ""+nums[i];

        Arrays.sort(ans , (a,b) -> (b+a).compareTo(a+b));
        if(ans[0].charAt(0) == '0') return "0";
        String a = "";
        for(String s : ans) a += s;
        return a;
    }
}