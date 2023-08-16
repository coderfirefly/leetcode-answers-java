import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;

/**
 * <a href=https://leetcode.cn/problems/reverse-words-in-a-string/>151. 反转字符串中的单词</a>
 * @Author phoebe
 * @date 2021/3/30
 */
public class Leetcode_151_reverseWordsInaString {

    public String reverseWords(String s) {
        String[] array = s.trim().split(" +");
        Collections.reverse(Arrays.asList(array));
        return String.join(" ", array);
    }

    @Test
    public void test1() {
        Leetcode_151_reverseWordsInaString solution = new Leetcode_151_reverseWordsInaString();
        Assert.assertEquals("world hello", solution.reverseWords("  hello world  "));
    }

}
