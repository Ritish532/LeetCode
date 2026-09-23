class Solution {
    public int scheduleCourse(int[][] courses) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.sort(courses, (a,b) -> a[1] - b[1]);
        int time = 0;
        for(int[] c : courses){
            int a = c[0] , b = c[1];
            time += a;
            pq.add(a);
            if(time > b){
                time -= pq.remove();
            }
        }
        return pq.size();
    }
}