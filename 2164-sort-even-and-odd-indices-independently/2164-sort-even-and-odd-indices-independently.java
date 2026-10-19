class Solution {
    public int[] sortEvenOdd(int[] nums) {
        int i = 0 , j = 0 , n = nums.length;
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        for(int k = 0 ; k < n ; k++){
            a.add(nums[k++]);
            if(k < n) b.add(nums[k]);
        }
        i = 0 ; j = 0;
        Collections.sort(a);
        Collections.sort(b);
        Collections.reverse(b);

        for(int k = 0 ; k < n ; k++){
            nums[k++] = a.get(i++); 
            if(k < n) nums[k] = b.get(j++); 
        }
        return nums;
    }
}