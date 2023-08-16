package offer;

/**
 * <a href=https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof>剑指 Offer 46. 把数字翻译成字符串</a>
 *
 * @Author phoebe
 * @date 2023/4/1
 */
public class Offer_46_TranslateNum {

    public int translateNum(int num) {
        String str = String.valueOf(num);
        int f1 = 1, f2 = 1;
        for (int i = 1; i < str.length(); i++) {
            String prev = str.substring(i - 1, i + 1);
            int tmp = f2;
            f2 = prev.compareTo("10") >= 0 && prev.compareTo("25") <= 0 ? f1 + f2 : f2;
            f1 = tmp;

        }
        return f2;
    }
}
