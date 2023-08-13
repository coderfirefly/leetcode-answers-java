/**
 * <a href=https://leetcode.cn/problems/minimum-window-substring>76. 最小覆盖子串</a>
 *
 * @Author phoebe
 * @Date 2023/8/12
 */
public class Leetcode_76_minimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        // 字符和出现的次数
        int[] need = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++;
        }
        // count 表示还差几个字符凑够子串t
        int i = 0, j = 0, count = t.length(), minStart = 0, minSize = Integer.MAX_VALUE;
        while (j < s.length()) {
            char c = s.charAt(j);
            // 出现子串的字符
            if (need[c] > 0) {
                count--;
            }
            need[c]--;
            if (count == 0) {
                // 收缩左边界
                while (i < j && need[s.charAt(i)] < 0) {
                    need[s.charAt(i)]++;
                    i++;
                }
                // 更新结果
                if (j - i + 1 < minSize) {
                    minSize = j - i + 1;
                    minStart = i;
                }
                need[s.charAt(i)]++;
                i++;
                count++;
            }
            j++;
        }
        return minSize == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minSize);
    }
}
