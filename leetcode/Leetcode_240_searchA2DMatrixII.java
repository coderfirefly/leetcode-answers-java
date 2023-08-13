/**
 * <a href=https://leetcode.cn/problems/search-a-2d-matrix-ii>240. 搜索二维矩阵 II</a>
 *
 * @Author phoebe
 * @Date 2023/8/13
 */
public class Leetcode_240_searchA2DMatrixII {
    /**
     * 方法1： 暴力查找
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 方法2： Z字形查找
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

}
