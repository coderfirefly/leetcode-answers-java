/**
 * <a href=https://leetcode.cn/problems/check-if-number-is-a-sum-of-powers-of-three>1780. 判断一个数字是否可以表示成三的幂的和</a>
 * @author firefly
 * @date 2022/12/9
 */
public class Leetcode_1780_checkIfNumberIsASumOfPowersOfThree {
    public boolean checkPowersOfThree(int n) {
        while (n != 0) {
            if (n % 3 == 2) {
                return false;
            }
            n = n / 3;
        }
        return true;
    }


}
