class Solution {
    public int[][] insert(int[][] intervals, int[] newIntervals) {
        List<int[]> ls2 = new ArrayList<>();
        List<int[]> ls = new ArrayList<>();
        ls.addAll(Arrays.asList(intervals));
        ls.addAll(Arrays.asList(newIntervals));
        ls.sort((a,b) -> Integer.compare(a[0],b[0]));

        int i = 1 , j = 0 , m = ls.size();

        ls2.add(ls.get(j));

        for(; i < m ; i++){
            int[] arr = ls2.get(j);
            int[] brr = ls.get(i);
            if(arr[1] >= brr[0]){
                if(arr[1] <= brr[1]){
                    ls2.remove(j);
                    ls2.add(new int[]{arr[0] , brr[1]});
                }
            } 
            else{
                ls2.add(new int[]{brr[0] ,brr[1]});
                j++;
            }
        }
        return ls2.toArray(new int[ls2.size()-1][]);
    }
}