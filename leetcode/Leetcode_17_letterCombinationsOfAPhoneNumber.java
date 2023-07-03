import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/">电话号码的字母组合</a>
 */
public class Leetcode_17_letterCombinationsOfAPhoneNumber {

    /**
     * 回溯法
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (null == digits || digits.isEmpty()) {
            return res;
        }

        Map<Character, String> dict = new HashMap<>();
        initDict(dict);

        helper(digits, dict, res, new StringBuilder(), 0);
        return res;
    }

    private void helper(String digits, Map<Character, String> dict, List<String> res, StringBuilder curStr, int level) {
        if (level == digits.length()) {
            res.add(curStr.toString());
            return;
        }

        String str = dict.get(digits.charAt(level));
        for (int i = 0; i < str.length(); i++) {
            curStr.append(str.charAt(i));
            helper(digits, dict, res, curStr, level + 1);
            curStr.deleteCharAt(level);
        }
    }

    private void initDict(Map<Character, String> dict) {
        dict.put('2', "abc");
        dict.put('3', "def");
        dict.put('4', "ghi");
        dict.put('5', "jkl");
        dict.put('6', "mno");
        dict.put('7', "pqrs");
        dict.put('8', "tuv");
        dict.put('9', "wxyz");
    }
}
