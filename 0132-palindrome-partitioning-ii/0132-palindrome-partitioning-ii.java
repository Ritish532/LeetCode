class Solution {
    public int dfs(int i, String s, int[] dp, boolean[][] isPal) {
        int n = s.length();

        if (i == n) return 0;

        if (dp[i] != -1) return dp[i];

        int min = Integer.MAX_VALUE;

        for (int j = i; j < n; j++) {
            if (isPal[i][j]) {
                min = Math.min(min, 1 + dfs(j + 1, s, dp, isPal));
            }
        }

        return dp[i] = min;
    }

    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) &&
                    (j - i <= 2 || isPal[i + 1][j - 1])) {
                    isPal[i][j] = true;
                }
            }
        }

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return dfs(0, s, dp, isPal) - 1;
    }
}