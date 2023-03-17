package offer;

/**
 * <a href=https://leetcode.cn/problems/ti-huan-kong-ge-lcof>剑指 Offer 05. 替换空格</a>
 *
 * @author firefly
 * @date 2023/3/12
 */
public class Offer_05_ReplaceSpace {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
