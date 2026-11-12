class Solution {
    class Set{
        String s;
        int val;
        Set(String s , int val){
            this.s = s;
            this.val = val;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        Arrays.sort(words);
        PriorityQueue<Set> pq = new PriorityQueue<>((a,b) -> {
            if(a.val != b.val) return Integer.compare(b.val , a.val);
            else return a.s.compareTo(b.s);
        });
        int i = 0 , j = 0;
        while(j < words.length){
            while(j < words.length && words[i].equals(words[j])) j++;
            int val = j-i;
            pq.add(new Set(words[i] , val));
            i = j;
        }
        List<String> ans = new ArrayList<>();
        while(k-- > 0 && pq.size() > 0) ans.add(pq.poll().s);
        return ans;
    }
}