/**
 * <a href=https://www.nowcoder.com/practice/11ae12e8c6fe48f883cad618c2e81475>大数加法</a>
 * @author firefly
 * @date 2021/3/25
 */
public class Leetcode_bigSum {

    public static String solve(String s, String t) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = s.length() - 1, j = t.length() - 1,  carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i < 0 ? 0 : s.charAt(i--) - '0';
            int y = j < 0 ? 0 : t.charAt(j--) - '0';
            int sum = x + y + carry;
            stringBuilder.append(sum % 10);
            carry = sum  / 10;
        }
        return stringBuilder.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(solve("12367", "89"));
        System.out.println(solve("10001", "99"));

    }
}
