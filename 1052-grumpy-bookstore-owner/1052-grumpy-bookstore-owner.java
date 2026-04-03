class Solution {
    public int maxSatisfied(int[] c, int[] grumpy, int k) {
        int i = 0 , j = k-1 , a = 0 ,b = j , maxUnSatisfied = 0 , n = grumpy.length , sum = 0;
        for(int h = 0 ; h <= j ; h++) if(grumpy[h] == 1) sum += c[h];

        while(j < n){
            if(sum > maxUnSatisfied){
                a = i ; b = j;
                maxUnSatisfied = sum;
            }
            i++;j++;

            if(i < n && grumpy[i-1] == 1) sum -= c[i-1];
            if(j< n && grumpy[j] == 1) sum += c[j];

        }
        for(int l = a ; l <= b; l++) grumpy[l] = 0;

        int Satisfied = 0;
        for(int m = 0 ; m < n ; m++) if(grumpy[m] == 0) Satisfied += c[m];
        return Satisfied;
    }
}