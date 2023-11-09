package tag.array.twodimensional_traversal;

/**
 * @Projectname: leetcode
 * @Filename: SpiralOrder_54
 * @Author: LWQ
 * @Data: 2023/11/8 13:25
 * @Description: medium
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 *
 *
 * 示例 1：
 * /Users/luwanqiang/project/leetcode/src/main/java/comm/img/54_ex1.jpg
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * /Users/luwanqiang/project/leetcode/src/main/java/comm/img/54_ex2.jpg
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class SpiralOrder_54 {

    /**
     * 通过：
     * 时间详情：0ms，击败 100.00%使用 Java 的用户
     * 内存详情：38.52MB，击败 63.66%使用 Java 的用户
     * @param matrix
     * @return
     * @description：划定上下左右四个界限，往内收缩
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 上、下、左、右
        int up = 0, down = m - 1, left = 0, right = n - 1;

        List<Integer> result = new ArrayList<>(m*n);
        while (true) {
            // 横向 - 正序
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }
            if (++up > down) {break;}

            // 纵向 - 正序
            for (int i = up; i <= down; i++) {
                result.add(matrix[i][right]);
            }
            if (--right < left) {break;}

            // 横向 - 逆序
            for (int i = right; i >= left; i--) {
                result.add(matrix[down][i]);
            }
            if (--down < up) {break;}

            // 纵向 - 逆序
            for (int i = down; i >= up; i--) {
                result.add(matrix[i][left]);
            }
            if (++left > right) {break;}
        }

        return result;
    }

    public static void main(String[] args) {
        SpiralOrder_54 target = new SpiralOrder_54();
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
//        matrix = new int[][]{{2,5,8}, {4,0,-1}};
        List<Integer> result = target.spiralOrder(matrix);
        System.out.println(result);
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int u = 0, d = m - 1, l = 0, r = n - 1;
        while (true) {
            for (int i = l; i <= r; i ++) res.add(matrix[u][i]);
            if (++u > d) break;
            for (int i = u; i <= d; i ++) res.add(matrix[i][r]);
            if (--r < l) break;
            for (int i = r; i >= l; i --) res.add(matrix[d][i]);
            if (--d < u) break;
            for (int i = d; i  >= u; i --) res.add(matrix[i][l]);
            if (++l > r) break;
        }
        return res;
    }
}
