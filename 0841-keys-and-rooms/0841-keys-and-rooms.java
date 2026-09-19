class Solution {
    public void bfs(List<List<Integer>> rooms , boolean[] vis , int n , int i){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        vis[i] = true;
        while(q.size() > 0){
            List<Integer> a = rooms.get(q.remove());
            for(int j = 0 ; j < a.size() ; j++){
                int l = a.get(j);
                if(!vis[l]){
                    vis[l] = true;
                    q.add(l);
                }
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        bfs(rooms , vis , n , 0);
        for(boolean v : vis) if(!v) return false;
        return true;
    }
}