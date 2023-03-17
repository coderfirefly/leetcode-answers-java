/**
 *  数组拆分成两个子集，差值最小
 * <a href=https://www.cnblogs.com/ranjiewen/p/9085049.html />
 * @author firefly
 * @date 2021/5/7
 */
public class Leetcode_arrayMinDiff {

    public static void main(String[] args) {
        int[] array = {1, 0, 1, 7, 2, 4};
        // {1, 0, 1, 2, 4} , {7}
        System.out.println(minDiff(array));
    }

    private static int minDiff(int[] array) {
        int sum = 0;
        for (int anArray : array) {
            sum += anArray;
        }
        int[][] dp = new int[array.length + 1][sum / 2 + 1];
        for (int i = 1; i <= array.length; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                if (j >= array[i - 1]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - array[i - 1]] + array[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return sum - 2 * dp[array.length][sum / 2];
    }
}
