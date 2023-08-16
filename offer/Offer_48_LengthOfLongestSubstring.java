package offer;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href=https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof>剑指 Offer 48. 最长不含重复字符的子字符串</a>
 *
 * @Author phoebe
 * @date 2023/4/1
 */
public class Offer_48_LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int maxLen = 0, j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && !charSet.contains(s.charAt(j))) {
                charSet.add(s.charAt(j));
                j++;
            }
            charSet.remove(s.charAt(i));
            maxLen = Math.max(maxLen, j - i);
        }
        return maxLen;
    }
}
