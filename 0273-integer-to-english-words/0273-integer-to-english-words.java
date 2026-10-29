class Solution {
    String[] belowTwenty = {
        "", "One", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    String[] tens = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        StringBuilder result = new StringBuilder();
        int grp = 0;
        while(num > 0){
            int part = num % 1000;
            if(part != 0){
                String words = convert(part);
                if(!thousands[grp].isEmpty()){
                    words += " " + thousands[grp];
                }
                if(result.length() == 0) result.insert(0,words);
                else result.insert(0 , words + " ");
            }
            num /= 1000;
            grp++;
        }
        return result.toString();
    }

    public String convert(int num){
        if(num == 0) return " ";
        if(num < 20) return "" + belowTwenty[num];
        if(num < 100){
            String ans = tens[num / 10];
            if(num % 10 != 0) ans += " " + belowTwenty[num % 10];
            return ans;
        }
        String ans = belowTwenty[num / 100] + " Hundred";
        if(num % 100 != 0) ans += " " + convert(num % 100);
        return ans;
    }
}