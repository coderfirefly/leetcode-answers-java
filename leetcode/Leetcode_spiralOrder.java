import java.util.ArrayList;

/**
 * <a href=https://www.nowcoder.com/practice/7edf70f2d29c4b599693dc3aaeea1d31>数组螺旋遍历</a>
 * Input:
 *  1 2 3
 *  4 5 6
 *  7 8 9
 *  Output:
 *  1 2 3 6 9 8 7 4 5
 * @author firefly
 * @date 2021/3/30
 */
public class Leetcode_spiralOrder {

    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int up = 0, down = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (up < (matrix.length + 1) / 2 && left < (matrix[0].length + 1) / 2) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            for (int i = up + 1; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            for (int i = right - 1; i >= left; i--) {
                res.add(matrix[down][i]);
            }
            for (int i = down - 1; i > up; i--) {
                res.add(matrix[i][left]);
            }
            up++;
            down--;
            left++;
            right--;
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(spiralOrder(matrix));
    }
}
