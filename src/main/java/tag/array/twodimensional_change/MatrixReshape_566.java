package tag.array.twodimensional_change;

/**
 * @Projectname: leetcode
 * @Filename: MatrixReshape_566
 * @Author: LWQ
 * @Data: 2023/11/8 21:59
 * @Description: easy
 */

import java.util.Arrays;

/**
 * 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
 *
 * 给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
 *
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
 *
 * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 *
 *
 * 示例 1：
 * /Users/luwanqiang/project/leetcode/src/main/java/comm/img/566_ex1.jpg
 *
 * 输入：mat = [[1,2],[3,4]], r = 1, c = 4
 * 输出：[[1,2,3,4]]
 * 示例 2：
 * /Users/luwanqiang/project/leetcode/src/main/java/comm/img/566_ex2.jpg
 *
 * 输入：mat = [[1,2],[3,4]], r = 2, c = 4
 * 输出：[[1,2],[3,4]]
 *
 *
 * 提示：
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * -1000 <= mat[i][j] <= 1000
 * 1 <= r, c <= 300
 */
public class MatrixReshape_566 {

    /**
     * 通过：
     * 时间详情：0ms，击败 100.00%使用 Java 的用户
     * 内存详情：42.55MB，击败 5.95%使用 Java 的用户
     * @param mat
     * @param r
     * @param c
     * @return
     * @desception：原始遍历方法
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int rowLth = mat.length;
        int colLth = mat[0].length;
        if (rowLth * colLth != r * c) {
            return mat;
        }

        int[][] result = new int[r][c];
        int rowIndex = 0, colIndex = 0;
        for (int i = 0; i < rowLth; i++) {
            for (int j = 0; j < colLth; j++) {
                result[rowIndex][colIndex] = mat[i][j];
                colIndex++;
                if (colIndex < c) {
                    continue;
                }
                colIndex = 0;
                rowIndex++;
            }
        }

        return result;
    }

    /**
     * 通过：
     * 时间详情：0ms，击败 100.00%使用 Java 的用户
     * 内存详情：42.05MB，击败 92.71%使用 Java 的用户
     * @param mat
     * @param r
     * @param c
     * @return
     * @desception：此方法代码简洁，但是每次需要进行 / % 计算，效率上会比原始方法略低
     */
    public int[][] matrixReshape3(int[][] mat, int r, int c) {
        int rowLth = mat.length;
        int colLth = mat[0].length;
        if (rowLth * colLth != r * c) {
            return mat;
        }

        int[][] result = new int[r][c];
        for (int i = 0; i < rowLth * colLth; i++) {
            result[i / c][i % c] = mat[i / colLth][i % colLth];
        }

        return result;
    }

    public static void main(String[] args) {
        MatrixReshape_566 target = new MatrixReshape_566();
        int[][] mat = {{1,2}, {3,4}};
        int r = 1;
        int c = 4;
        int[][] result = target.matrixReshape3(mat, r, c);
        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     *
     * @param nums
     * @param r
     * @param c
     * @return
     * @descption：将二维数组映射成一个一维数组，再将这个一维数组映射到新数组上
     */
    public int[][] matrixReshape2(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }

        int[][] ans = new int[r][c];
        for (int x = 0; x < m * n; ++x) {
            ans[x / c][x % c] = nums[x / n][x % n];
        }
        return ans;
    }
}
