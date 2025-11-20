class Solution {
    public int intersectionSizeTwo(int[][] nums) {
        Arrays.sort(nums, (a,b) ->
            a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]
        );

        ArrayList<Integer> ans = new ArrayList<>();
        int p1 = -1 , p2 = -1;
        for(int i = 0 ; i < nums.length ; i++){
            int count = 0;
            if(p1 >= nums[i][0] && p1 <= nums[i][1]) count++;
            if(p2 >= nums[i][0] && p2 <= nums[i][1]) count++;

            if(ans.size() == 0){
                int j = nums[i][nums[i].length-1];
                ans.add(j);
                p1 = j;
                j -= 1;
                ans.add(j);
                p2 = j;
            }
            else if(count == 0){
                int j = nums[i][nums[i].length-1];
                ans.add(j);
                p1 = j;
                j -= 1;
                ans.add(j);
                p2 =j;
            }
            else if(count == 1){
                int j = nums[i][nums[i].length-1];
                ans.add(j);
                p2 = p1;
                p1 = j;
            }
        }
        return ans.size();
    }
}