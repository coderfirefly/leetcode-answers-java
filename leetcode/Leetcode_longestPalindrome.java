/**
 * @Author phoebe
 * @date 2021/3/30
 */
public class Leetcode_longestPalindrome {

    public static int getLongestPalindrome(String A, int n) {
        boolean[][] dp = new boolean[n][n];
        int res = 0;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n - k; i++) {
                int j = i + k;
                if (k == 0) {
                    dp[i][j] = true;
                } else if (k == 1) {
                    dp[i][j] = (A.charAt(i) == A.charAt(j));
                } else {
                    dp[i][j] = A.charAt(i) == A.charAt(j) && dp[i + 1][j - 1];
                }

                if (dp[i][j] && k + 1 > res) {
                    res = k + 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getLongestPalindrome("abc1234321ab", 12));
    }
}
