/**
 * <a href=https://leetcode.cn/problems/rotate-image>48. 旋转图像</a>
 *
 * @Author phoebe
 * @Date 2023/8/13
 */
public class Leetcode_48_rotateImage {
    public void rotate(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // 上下按行翻
        for (int i = 0; i < m / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[m - 1 - i][j];
                matrix[m - 1 - i][j] = temp;
            }
        }
        // 按对角线翻转
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
