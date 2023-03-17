/**
 * <a href="https://leetcode.com/problems/jump-game/">跳跃游戏</a>
 */
public class Leetcode_55_jumpGame {

    /**
     * 贪心法
     */
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) {
                return false;
            }
            reachable = Math.max(i + nums[i], reachable);
        }
        return true;
    }
}
