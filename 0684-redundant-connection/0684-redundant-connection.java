class Solution {
    public int[] parent , size;
    public int Leader(int a){
        if(parent[a] == a) return a;
        return parent[a] = Leader(parent[a]);
    }
    public void Union(int a , int b){
        a = Leader(a);
        b = Leader(b);
        if(size[a] > size[b]){
            parent[b] = a;
            size[a]+=size[b];
        }
        else {
            parent[a] = b;
            size[b] += size[a];
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        size = new int[n+1];
        for(int i = 0 ;i <= n ;i++) {
            parent [i] = i;
            size[i] = 1;
        }
        parent[0] = 56789;
        for(int[] arr : edges){
            int u = arr[0] , v = arr[1];
            if(Leader(u) == Leader(v)) return new int[]{u,v};
            Union(u,v);
        }
        return new int[2];
    }
}