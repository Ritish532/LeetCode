class Solution {
    public void Zero(int[] code){
        for(int i = 0 ; i < code.length ; i++) code[i] = 0;
    }

    public int[] Greater(int[] code, int k){
        int len = code.length;
        int[] correct = new int[len];

        for(int i = 0 ; i < len ; i++){
            correct[i] = 0;
            int j = i+1;
            for(int n = 0 ; n < k ; n++){
                if(j == len) j = 0;
                correct[i] += code[j++];
            }
        }
        return correct;
    }

    public int[] Smaller(int[] code , int k){
        k = -1 * k;
        int len = code.length;
        int[] correct = new int[len];

        for(int i = 0 ; i < len ; i++){
            correct[i] = 0;
            int j = i - 1;
            for(int n = 0 ; n < k ; n++){
                if(j < 0) j = len-1;
                correct[i] += code[j--];
            }
        }
        return correct;
    }

    public int[] decrypt(int[] code, int k) {
        if(k == 0) Zero(code);
        else if(k > 0) return Greater(code , k);
        else return Smaller(code , k);
        return code;
    }
}