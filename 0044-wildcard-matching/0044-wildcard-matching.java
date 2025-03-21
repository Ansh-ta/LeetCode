import java.util.Arrays;

class Solution {
    public boolean isMatch(String s, String p) {
        int[][] dp = initializeDp(s.length(), p.length());
        return spaceOptimization(s, p);
    }

    private boolean spaceOptimization(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[] prev = new boolean[n + 1];
        prev[0] = true;
        for (int i = 1; i <= n; i++) {
            prev[i] = isAllStars(p, i - 1);
        }
        for (int i = 1; i <= m; i++) {
            boolean[] curr = new boolean[n + 1];
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    curr[j] = prev[j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    curr[j] = curr[j - 1] || prev[j];
                }
            }
            prev = curr;
        }
        return prev[n];
    }

    private boolean tabulation(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = isAllStars(p, i - 1);
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    private boolean memorization(String s, String p, int si, int pi, int[][] dp) {
        if (si < 0 && pi < 0) {
            return true;
        }
        if (si < 0) {
            return isAllStars(p, pi);
        }
        if (pi < 0) {
            return false;
        }

        if (dp[si][pi] != -1) {
            return dp[si][pi] == 1;
        }
        boolean ans = false;
        if (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?') {
            ans = memorization(s, p, si - 1, pi - 1, dp);
        } else if (p.charAt(pi) == '*') {
            ans = memorization(s, p, si, pi - 1, dp) || memorization(s, p, si - 1, pi, dp);
        }
        dp[si][pi] = ans ? 1 : 0;
        return ans;
    }

    private boolean recurssion(String s, String p, int si, int pi) {
        if (si < 0 && pi < 0) {
            return true;
        }
        if (si < 0) {
            return isAllStars(p, pi);
        }
        if (pi < 0) {
            return false;
        }

        if (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?') {
            return recurssion(s, p, si - 1, pi - 1);
        } else if (p.charAt(pi) == '*') {
            return recurssion(s, p, si, pi - 1) || recurssion(s, p, si - 1, pi);
        } else {
            return false;
        }
    }

    private boolean isAllStars(String s, int i) {
        while (i >= 0) {
            if (s.charAt(i) != '*') {
                return false;
            }
            i--;
        }
        return true;
    }

    private int[][] initializeDp(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dp;
    }
}