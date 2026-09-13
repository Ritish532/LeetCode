class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> a = new ArrayList<>();
        List<int[]> b = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(img1[i][j] == 1) a.add(new int[]{i,j});
                if(img2[i][j] == 1) b.add(new int[]{i,j});
            }
        }

        HashMap<String,Integer> map = new HashMap<>();
        int ans = 0;
        for(int[] p : b){
            for(int[] q : a){
                int x = p[0] - q[0];
                int y = p[1] - q[1];
                String key = x + "," + y;
                map.put(key , map.getOrDefault(key,0)+1);
                ans = Math.max(ans,map.get(key));
            }
        }
        return ans;
    }
}