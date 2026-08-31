class Solution {
    public List<Integer> intersection(int[][] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int[] arr : nums){
            if(ans.size() == 0) for(int i = 0 ; i < arr.length ; i++) ans.add(arr[i]);
            else{
                Collections.sort(ans);
                Arrays.sort(arr);
                int i = 0 , j = 0;
                while(i < ans.size() && j < arr.length){
                    if(ans.get(i) == arr[j]){
                        i++;j++;
                        continue;
                    }
                    else if(ans.get(i) < arr[j]) ans.remove(ans.get(i));
                    else j++;
                }
                while(i < ans.size()) ans.remove(ans.get(i));
            }
        }
        Collections.sort(ans);
        return ans;
    }
}