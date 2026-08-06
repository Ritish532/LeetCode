class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals , (a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> ls = new ArrayList<>();
        int i = 1 , j = 0 , m = intervals.length;

        ls.add(new int[]{intervals[0][0] , intervals[0][1]});

        for(; i < m ; i++){
            int[] arr = ls.get(j);
            if(arr[1] >= intervals[i][0]){
                if(arr[1] <= intervals[i][1]){
                    ls.remove(j);
                    ls.add(new int[]{arr[0] , intervals[i][1]});
                }
            } 
            else{
                ls.add(new int[]{intervals[i][0] , intervals[i][1]});
                j++;
            }
        }
        return ls.toArray(new int[ls.size()-1][]);
    }
}