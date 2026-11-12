class Solution {
    class Set{
        String s;
        int val;
        Set(String s , int val){
            this.s = s;
            this.val = val;
        }
    }
    public String largestWordCount(String[] msg, String[] senders) {
        HashMap<String , Integer> map = new HashMap<>();
        PriorityQueue<Set> pq = new PriorityQueue<>((a,b) -> {
            if(a.val != b.val) return Integer.compare(b.val , a.val);
            else return b.s.compareTo(a.s);
        });
        int n = msg.length;
        for(int i = 0 ; i < n ; i++){
            String s = msg[i];
            int c = 1;
            for(int j = 0 ; j < s.length() ; j++) if(s.charAt(j) == ' ') c++;
            map.put(senders[i] , map.getOrDefault(senders[i] , 0) + c);
        }
        for(String s : map.keySet()){
            pq.add(new Set(s , map.get(s)));
        }
        return pq.poll().s;
    }
}