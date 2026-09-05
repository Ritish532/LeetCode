class Solution {
    public List<List<Integer>> ans;
    public void helper(int[] nums , int idx){
        int n = nums.length;
        if(idx == n-1){
            List<Integer> ls = new ArrayList<>(); 
            for(int i = 0 ; i < n ; i++) ls.add(nums[i]);
            ans.add(ls);
            return;
        }
        for(int i = idx ; i < n ; i++){
            swap(idx,i,nums);
            helper(nums, idx+1);
            swap(idx,i,nums);
        }
    }
    public void swap(int i , int j , int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        helper(nums, 0);
        return ans;
    }
}


// class Solution {
//     public List<List<Integer>> ans;
//     public void helper(String s , String t){
//         if(s.equals("")){
//             List<Integer> ls = new ArrayList<>();
//             for(int i = 0 ; i < t.length() ; i++) ls.add(Integer.parseInt(""+t.charAt(i)));
//             ans.add(ls);
//             return;
//         }
//         for(int i = 0 ; i < s.length() ; i++){
//             char ch = s.charAt(i);
//             String left = s.substring(0,i);
//             String right = s.substring(i+1);
//             String rem = left + right;
//             helper(rem , t+ch);
//         }
//         return;
//     }
//     public List<List<Integer>> permute(int[] nums) {
//         ans = new ArrayList<>();
//         String s = "";
//         for(int ch : nums) s = s + ch;
//         helper(s, "" );
//         return ans;
//     }
// }



// class Solution {
//     public List<List<Integer>> ans;
//     public void helper(int[] nums , boolean[] used , List<Integer> temp){
//         if(temp.size() == nums.length){
//             ans.add(new ArrayList<>(temp));
//         }
//         for(int i = 0; i < nums.length ; i++){
//             if(used[i] == true) continue;
//             used[i] = true;

//             // critical section
//             temp.add(nums[i]);
//             helper(nums , used , temp);
//             temp.remove(temp.size()-1);

//             used[i] = false;
//         }
//     }
//     public List<List<Integer>> permute(int[] nums) {
//         ans = new ArrayList<>();
//         helper(nums , new boolean[nums.length] , new ArrayList<>());
//         return ans;
//     }
// }