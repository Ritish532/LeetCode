class Solution {
    public void dfs(int i , List<List<Integer>> rooms , boolean[] vis){
        vis[i] = true;
        for(int ele : rooms.get(i)){
            if(!vis[ele]) dfs(ele , rooms , vis);
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        dfs(0 , rooms , vis);
        for(boolean v : vis) if(!v) return false;
        return true;
    }
}
// class Solution {
//     public void bfs(List<List<Integer>> rooms , boolean[] vis){
//         Queue<Integer> q = new LinkedList<>();
//         q.add(0);
//         vis[0] = true;
//         while(q.size() > 0){
//             List<Integer> a = rooms.get(q.remove());
//             for(int j = 0 ; j < a.size() ; j++){
//                 int l = a.get(j);
//                 if(!vis[l]){
//                     vis[l] = true;
//                     q.add(l);
//                 }
//             }
//         }
//     }
//     public boolean canVisitAllRooms(List<List<Integer>> rooms) {
//         int n = rooms.size();
//         boolean[] vis = new boolean[n];
//         bfs(rooms , vis);
//         for(boolean v : vis) if(!v) return false;
//         return true;
//     }
// }