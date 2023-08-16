/**
 * <a href=https://leetcode.cn/problems/wildcard-matching/>44. 通配符匹配</a>
 *
 * @Author phoebe
 * @date 2023/01/01
 */
public class Leetcode_44_wildcardMatching {

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        // s 和 p 均为空
        dp[0][0] = true;
        // p 为空，s不为空，均为false
        // s 为空:
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = true;
            } else {
                // warning
                break;
            }
        }
        // 更新dp
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

}
