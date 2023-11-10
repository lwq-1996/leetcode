package arithmetic.medium;

/**
 * @Projectname: leetcode
 * @Filename: GenerateMatrix_59
 * @Author: LWQ
 * @Data: 2023/11/8 13:30
 * @Description: medium
 */

import java.util.Arrays;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 *
 *
 * 示例 1：
 * /Users/luwanqiang/project/leetcode/src/main/java/comm/img/59_ex1.jpg
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 *
 *
 * 提示：
 *
 * 1 <= n <= 20
 */
public class GenerateMatrix_59 {

    /**
     * 通过：
     * 时间详情：0ms，击败 100.00%使用 Java 的用户
     * 内存详情：37.95MB，击败 99.16%使用 Java 的用户
     * @param n
     * @return
     * @description：同54
     */
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int current = 1;
        int up = 0, down = n - 1, left = 0, right = n - 1;

        while (true) {
            // 横向 - 正序
            for (int i = left; i <= right ; i++) {
                result[up][i] = current++;
            }
            if (++up > down) {break;}

            // 纵向 - 正序
            for (int i = up; i <= down; i++) {
                result[i][right] = current++;
            }
            if (--right < left) {break;}

            // 横向 - 逆序
            for (int i = right; i >= left ; i--) {
                result[down][i] = current++;
            }
            if (--down < up) {break;}

            // 纵向 - 逆序
            for (int i = down; i >= up; i--) {
                result[i][left] = current++;
            }
            if (++left > right) {break;}
        }

        return result;
    }

    public static void main(String[] args) {
        GenerateMatrix_59 target = new GenerateMatrix_59();
        int n = 3;
        int[][] result = target.generateMatrix(n);
        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
