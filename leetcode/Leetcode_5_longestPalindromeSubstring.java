/**
 * <a href=https://leetcode.cn/problems/longest-palindromic-substring>5. 最长回文子串</a>
 *
 * @Author phoebe
 * @date 2022/12/31
 */
public class Leetcode_5_longestPalindromeSubstring {
    public String longestPalindrome(String s) {
        int m = s.length();
        if (m < 2) {
            return s;
        }
        int beginIndex = 0;
        int maxLen = 1;
        // s[i..j] 是否为回文串
        boolean[][] dp = new boolean[m][m];
        for (int i = 0; i < m; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < m; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    dp[i][j] = j - i < 2 || dp[i + 1][j - 1];
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    beginIndex = i;
                }
            }
        }
        return s.substring(beginIndex, beginIndex + maxLen);
    }


}
