import java.util.HashMap;
import java.util.Map;

/**
 * <a href=https://leetcode.cn/problems/longest-substring-without-repeating-characters/>3. 无重复字符的最长子串</a>
 *
 * @Author phoebe
 * @date 2023/2/11
 */
public class Leetcode_3_longestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            result = Math.max(result, i - j + 1);
        }
        return result;
    }
}
