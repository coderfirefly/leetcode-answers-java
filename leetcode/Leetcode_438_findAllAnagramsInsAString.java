import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href=https://leetcode.cn/problems/find-all-anagrams-in-a-string/>438. 找到字符串中所有字母异位词</a>
 * @Author phoebe
 * @date 2022/12/24
 */
public class Leetcode_438_findAllAnagramsInsAString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLen = s.length(), pLen = p.length();
        char[] pArray = p.toCharArray();
        Arrays.sort(pArray);
        for (int i = 0; i <= sLen - pLen; i++) {
            char[] cArray = s.substring(i, i + pLen).toCharArray();
            Arrays.sort(cArray);
            if (Arrays.equals(cArray, pArray)) {
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int[] sArray = new int[26];
        int[] pArray = new int[26];
        for (int i = 0; i < p.length(); i++) {
            sArray[s.charAt(i) - 'a']++;
            pArray[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sArray, pArray)) {
            result.add(0);
        }
        for (int i = 0; i < s.length() - p.length(); i++) {
            sArray[s.charAt(i) - 'a']--;
            sArray[s.charAt(i + p.length()) - 'a']++;
            if (Arrays.equals(sArray, pArray)) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
