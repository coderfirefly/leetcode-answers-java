/**
 * <a href="https://leetcode.com/problems/length-of-last-word/">最后一个单词的长度</a>
 */
public class Leetcode_58_lengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int lastLen = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && lastLen > 0) {
                return lastLen;
            } else if (s.charAt(i) != ' ') {
                lastLen++;
            }
        }
        return lastLen;
    }
}
