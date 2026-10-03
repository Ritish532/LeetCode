class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length , jumps = 0;
        boolean[] vis = new boolean[n];
        if(n == 1) return 0;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            int ele = arr[i];
            if(map.containsKey(ele)) map.get(ele).add(i);
            else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(ele , list);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;
        while(q.size() > 0){
            int size = q.size();
            while(size > 0){
                size--;
                int idx = q.poll();
                if(idx == n-1) return jumps;
                if(idx >= 1 && !vis[idx-1]){
                    vis[idx-1] = true;
                    q.add(idx-1);
                }
                if(idx+1 < n && !vis[idx+1]){
                    vis[idx+1] = true;
                    q.add(idx+1);
                }
                List<Integer> a = map.get(arr[idx]);
                for(int ele : a){
                    if(!vis[ele]){
                        vis[ele] = true;
                        q.add(ele);
                    }
                }
                a.clear();
            }
            jumps++;
        }
        return -1;
    }
}