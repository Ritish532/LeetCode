class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] idx = new int[nums.length];
        int n = nums.length;
        Arrays.fill(idx,-1);
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < n*2 ; i++){
            int curr = nums[i%n];
            while(!st.isEmpty() && nums[st.peek()] < curr) {
                idx[st.pop()] = curr;
            }
            if(i < n) st.push(i);
        }
        return idx;
    }
}
// class Solution {
//     public int[] nextGreaterElements(int[] nums) {
//         int[] idx = new int[nums.length];
//         Arrays.fill(idx,-1);
//         for(int i = 0 ; i < nums.length ; i++){
//             int k = i+1;
//             while(k != i) {
//                 if(k == nums.length) k = 0;
//                 if(nums[k] > nums[i]){
//                     idx[i] = nums[k];
//                     break;
//                 }
//                 k++;
//             }
//         }
//         return idx;
//     }
// }