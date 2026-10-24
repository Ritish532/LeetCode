class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] dates = {31 , 28 , 31 , 30 , 31 , 30 , 31 , 31 , 30 , 31 , 30 , 31};
        int aliceStart = convert(arriveAlice , dates);
        int aliceEnd   = convert(leaveAlice , dates);
        int BobStart   = convert(arriveBob , dates);
        int BobEnd     = convert(leaveBob , dates);

        int start = Math.max(aliceStart , BobStart);
        int end = Math.min(aliceEnd , BobEnd);

        return Math.max(0 , end - start + 1);
    }

    public int convert(String s , int[] dates){
        int total = Integer.parseInt(s.substring(3));
        int month = Integer.parseInt(s.substring(0,2));
        for(int i = 0 ; i < month-1 ; i++){
            total += dates[i];
        }
        return total;
    }
}