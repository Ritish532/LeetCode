class Solution {
    public double pow(double x , long n){
        if(n == 0) return 1;
        double half = pow(x,n/2);
        if(n%2 == 0) return half * half;
        else return x * half*half;
    }
    public double myPow(double x, int n) {
        double ans;
        long N = n;
        if(n < 0){
            x = 1/x;
            N *= -1;
        }
        return pow(x,N);

    }
}