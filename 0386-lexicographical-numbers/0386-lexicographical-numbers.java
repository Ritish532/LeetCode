class Solution {
    public List<Integer> lexicalOrder(int n) {
        ArrayList<String> a = new ArrayList<>();
        for(int i = 1 ; i <= n ; i++) a.add(""+i);
        Collections.sort(a);
        ArrayList<Integer> l = new ArrayList<>();
        for(String s : a) l.add(Integer.parseInt(s));
        return l;
    }
}