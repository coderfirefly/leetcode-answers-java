import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/first-unique-character-in-a-string/">字符串的第一个唯一字符</a>
 */
public class Leetcode_387_firstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
