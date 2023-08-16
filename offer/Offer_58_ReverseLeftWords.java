package offer;

/**
 * <a href=https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/?favorite=xb9nqhhg>剑指 Offer 58 - II. 左旋转字符串</a>
 *
 * @Author phoebe
 * @date 2023/3/12
 */
public class Offer_58_ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        char[] array = s.toCharArray();
        reverse(array, 0, n - 1);
        reverse(array, n, s.length() - 1);
        reverse(array, 0, s.length() - 1);
        return String.valueOf(array);
    }

    private void reverse(char[] s, int left, int right) {
        while (left < right) {
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            left++;
            right--;
        }
    }

    public String reverseLeftWords2(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
