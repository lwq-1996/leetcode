package arithmetic.medium;

/**
 * @Projectname: leetcode
 * @Filename: Rotate_48
 * @Author: LWQ
 * @Data: 2023/11/8 22:05
 * @Description: medium
 */

import java.util.Arrays;

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 *
 *
 * 示例 1：
 * /Users/luwanqiang/project/leetcode/src/main/java/comm/img/48_ex1.jpg
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * 示例 2：
 * /Users/luwanqiang/project/leetcode/src/main/java/comm/img/48_ex2.jpg
 *
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 *
 * 提示：
 *
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 */
public class Rotate_48 {

    /**
     * 钻牛角尖了，没搞懂！
     * No Pass
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        // 左右/上下 边界
        int n = 0, m = matrix.length - 1;

        int tmp;
        while (n < m) {
            // n+1不包含对角线
            for (int i = n; i < m; i++) {
                // 上边界一列
                tmp = matrix[n][i];
                matrix[n][i] = matrix[m-i][n];
                matrix[m-i][n] = matrix[m][m-i];
                matrix[m][m-i] = matrix[i][m];
                matrix[i][m] = tmp;
            }
            /*// 对角线旋转
            tmp = matrix[n][n];
            matrix[n][n] = matrix[m][n];
            matrix[m][n] = matrix[m][m];
            matrix[m][m] = matrix[n][m];
            matrix[n][m] = tmp;*/
            // 边界收缩
            n++;
            m--;
        }
    }

    public static void main(String[] args) {
        Rotate_48 target = new Rotate_48();
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        matrix = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        matrix = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        target.rotate(matrix);
        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     *
     * @param matrix
     * @description： 原地旋转
     */
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    /**
     *
     * @param matrix
     * @description：水平翻转后，翻转主对角线
     */
    public void rotate3(int[][] matrix) {
        int n = matrix.length;
        // 水平翻转
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
