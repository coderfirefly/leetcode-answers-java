import org.junit.Assert;
import org.junit.Test;

/**
 * <a href=https://leetcode.cn/problems/longest-common-subsequence>1143. 最长公共子序列</a>
 * @author firefly
 * @date 2021/3/30
 */
public class Leetcode_1143_longestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        return dp[m][n];
    }


    @Test
    public void test() {
        Assert.assertEquals(3, longestCommonSubsequence("abcde", "ace"));
    }
}
