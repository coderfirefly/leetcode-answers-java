package offer;

/**
 * <a href=https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof>剑指 Offer 50. 第一个只出现一次的字符</a>
 * @author firefly
 * @date 2023/3/12
 */
public class Offer_50_FirstUniqChar {
    public char firstUniqChar(String s) {
        int[] dict = new int[26];
        char[] array = s.toCharArray();
        for (char c : array) {
            dict[c - 'a']++;
        }
        for (char c : array) {
            if (dict[c - 'a'] == 1) {
                return c;
            }
        }
        return ' ';
    }
}
