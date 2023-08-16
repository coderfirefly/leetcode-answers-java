import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 最长公共子串
 *
 * @Author phoebe
 * @date 2021/3/30
 */
public class Leetcode_LongestCommonSubstring {
    public static String lcs(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        int maxLen = 0, maxEnd = 0;
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                if (dp[i][j] > maxLen) {
                    maxLen = dp[i][j];
                    maxEnd = j - 1;
                }
            }
        }

        return str2.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

    @Test
    public void test() {
        assertEquals("12345", lcs("1AB2345CD", "12345EF"));
    }
}
