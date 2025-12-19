class Solution {
    List<List<Integer>> ans;
    public void solve(int[] arr , int target , int sum , int idx , List<Integer> temp){
        if(target < sum) return;
        if(target == sum){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = idx; i < arr.length ; i++){
            if(i > idx && arr[i] == arr[i-1]) continue;
            temp.add(arr[i]);
            solve(arr , target, sum+arr[i] , i+1 , temp);
            if(temp.size() > 0) temp.remove(temp.size() - 1);
        }
        
        return;
    }
    public List<List<Integer>> combinationSum2(int[] arr, int target){
        ans = new ArrayList<>();
        Arrays.sort(arr);
        solve(arr , target , 0 , 0 , new ArrayList<>());
        return ans;
    }
}