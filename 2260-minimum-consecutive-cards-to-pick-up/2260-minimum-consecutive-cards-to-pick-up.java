class Solution {
    public int minimumCardPickup(int[] cards) {
        HashSet<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE , count = 0 , strt = 0;
        boolean flag = false;
        for(int i = 0 ; i < cards.length ; i++){
            int ele = cards[i];
            while(set.contains(ele)){
                flag = true;
                min = Math.min(min,(i-strt+1));
                set.remove(cards[strt++]);
            }
            set.add(ele);
        }
        if(!flag) return -1;
        return min;
    }
}