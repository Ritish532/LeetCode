class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int ans[] = new int[n];
        for(int i = 0 ; i < bookings.length ; i++){
            int first = bookings[i][0]-1;
            int last = bookings[i][1];
            int seats = bookings[i][2];

            ans[first] += seats;
            if(last < n) ans[last] -= seats;
        }

        for(int i = 1 ; i < n ; i++) ans[i] += ans[i-1];
        return ans;
    }
}