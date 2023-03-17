import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a href=https://leetcode.cn/problems/reverse-words-in-a-string-iii/>557. 反转字符串中的单词 III</a>
 *
 * @author firefly
 * @date 2022/12/24
 */
public class Leetcode_557_ReverseWordsInsStringIII {

    public String reverseWords(String s) {
        List<String> result = Arrays.stream(s.split(" +"))
                .map(Leetcode_557_ReverseWordsInsStringIII::reverseStr)
                .collect(Collectors.toList());
        return String.join(" ", result);

    }

    public static String reverseStr(String s) {
        char[] array = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            char tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
        return String.valueOf(array);
    }

    @Test
    public void test1() {
        Assert.assertEquals("s'teL ekat edoCteeL tsetnoc", reverseWords("Let's take LeetCode contest"));
    }
}
