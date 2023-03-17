/**
 * <a href=https://leetcode.cn/problems/longest-common-prefix>14. 最长公共前缀</a>
 * @author firefly
 * @date 2022/12/24
 */
public class Leetcode_14_longestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == i || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
