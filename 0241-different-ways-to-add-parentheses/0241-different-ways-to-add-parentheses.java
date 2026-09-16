class Solution {
    public List<Integer> diffWaysToCompute(String exp) {
        List<Integer> ans = new ArrayList<>();
        int n = exp.length();
        for(int i = 0 ; i < n ; i++){
            char ch = exp.charAt(i);
            if(ch == '+' || ch == '*' || ch == '-'){
                List<Integer> left = diffWaysToCompute(exp.substring(0,i));
                List<Integer> right = diffWaysToCompute(exp.substring(i+1));
                for(int a : left){
                    for(int b : right){
                        if(ch == '+') ans.add(a+b);
                        else if(ch == '-') ans.add(a-b);
                        else ans.add(a*b);
                    }
                }
            }
        }
        if(ans.size() == 0) ans.add(Integer.parseInt(exp));
        return ans;
    }
}