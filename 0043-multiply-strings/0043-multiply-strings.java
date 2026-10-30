class Solution {
    public String multiply(String num1, String num2) {
        int n = num1.length() , m = num2.length();
        if(num1.equals("0") || num2.equals("0")) return "0";
        int[] result = new int[n + m];
        for(int i = n-1 ; i >= 0 ; i--){
            for(int j = m-1 ; j >= 0 ; j--){
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';

                int product = a * b;
                int sum = product + result[i+j+1];
                result[i+j+1] = sum % 10;
                result[i+j] += sum / 10;
            }
        }
        StringBuilder s = new StringBuilder();
        for(int digit : result){
            if(s.length() == 0 && digit == 0) continue;
            s.append(digit);
        }
        return s.toString();
    }
}