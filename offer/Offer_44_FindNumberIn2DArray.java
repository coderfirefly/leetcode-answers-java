package offer;

/**
 * <a href=https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof>剑指 Offer 04. 二维数组中的查找</a>
 *
 * @Author phoebe
 * @date 2023/3/12
 */
public class Offer_44_FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
