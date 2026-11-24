class Solution {
    public int max;
    public void helper(int i , int[] nums , int n , int prod , int g , int l){
        if(i == nums.length) return ;
        prod *= nums[i];
        g = gcd(g , nums[i]);
        l = lcm(l , nums[i]);
        n++;
        if(prod == g * l) max = Math.max(max , n);
        helper(i+1 , nums , n , prod , g , l);
    }
    public int lcm(int a , int b){
        if(b == 0 || a == 0) return 0;
        return (a / gcd(a , b)) * b;
    }
    public int gcd(int a , int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public int maxLength(int[] nums) {
        max = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            helper(i , nums , 0 , 1 , 0 , 1);
        }
        return max;
    }
}