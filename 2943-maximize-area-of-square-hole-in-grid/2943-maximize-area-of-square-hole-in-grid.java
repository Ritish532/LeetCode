class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int x = hBars.length;
        int y = vBars.length;
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int h = 1 , v = 1 , maxh = 1 , maxv = 1;
        for(int i = 1; i < x ; i++){
            if(hBars[i] == hBars[i-1] + 1) h++;
            else h = 1;
            maxh = Math.max(maxh , h);
        }
        for(int i = 1; i < y ; i++){
            if(vBars[i] == vBars[i-1] + 1) v++;
            else v = 1;
            maxv = Math.max(maxv , v);
        }
        return (Math.min(maxv,maxh)+1) *  (Math.min(maxv,maxh)+1);
    }
    }
