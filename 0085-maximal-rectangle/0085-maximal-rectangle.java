class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int nsi[] = new int[n];
        Stack<Integer> st = new Stack<>();

        nsi[n-1] = n;
        st.push(n-1);

        for(int i = n-2 ; i >= 0 ; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();

            nsi[i] = st.isEmpty()? n : st.peek();
            st.push(i);
        }


        int psi[] = new int[n];
        Stack<Integer> gt = new Stack<>();

        psi[0] = -1;
        gt.push(0);

        for(int i = 1 ; i < n ; i++){
            while(!gt.isEmpty() && arr[gt.peek()] >= arr[i]) gt.pop();

            psi[i] = gt.isEmpty()? -1 : gt.peek();
            gt.push(i);
        }

        int maxArea = -1;
        for(int i = 0; i < n ; i++){
            int Area = arr[i] * (nsi[i] - psi[i] - 1);
            maxArea = Math.max(Area,maxArea);
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length , m = matrix[0].length , ans = Integer.MIN_VALUE;
        int[] heights = new int[m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(matrix[i][j] == '1') heights[j]++;
                else heights[j] = 0;
            }
            ans = Math.max(ans , largestRectangleArea(heights));
        }
        return ans;
    }
}