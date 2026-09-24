class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inorder = new int[graph.length];
        for(int i = 0 ; i < graph.length ; i++) adj.add(new ArrayList<>());
        for(int i = 0 ; i < graph.length ; i++) 
            for(int j : graph[i]){
                adj.get(j).add(i);
                inorder[i]++;
            }
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < inorder.length ; i++) if(inorder[i] == 0) q.add(i);
        while(q.size() > 0){
            int front = q.remove();
            ans.add(front);
            for(int ele : adj.get(front)){
                inorder[ele]--;
                if(inorder[ele] == 0) q.add(ele);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}