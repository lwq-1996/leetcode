package arithmetic.medium;

/**
 * @Projectname: leetcode
 * @Filename: SetZeroes_73
 * @Author: LWQ
 * @Data: 2023/11/8 22:11
 * @Description: medium
 */

import java.util.Arrays;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 *
 *
 * 示例 1：
 * /Users/luwanqiang/project/leetcode/src/main/java/comm/img/73_ex1.jpg
 *
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * 示例 2：
 * /Users/luwanqiang/project/leetcode/src/main/java/comm/img/73_ex2.jpg
 *
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 *
 *
 * 进阶：
 *
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 */
public class SetZeroes_73 {

    /**
     * 通过：
     * 时间详情：0ms，击败 100.00%使用 Java 的用户
     * 内存详情：42.26MB，击败 88.37%使用 Java 的用户
     * @param matrix
     * @descption：
     *      1.左 & 上：遍历行，若当前元素为0，则左、上方全部变为0
     *      2.右方：往右遍历，若有为0的数，不处理，横向指针跳转至下一个0处，若没有为0的数，将当前行全部变为0，当前行遍历结束
     *      3.下方：从下往上遍历该列，寻找每一行是否包含数字0，遍历过程遇到的第一个含有0的行处，将该值变为0，若遍历结束都没有为0 的行，将该列全部置0，且后续不需要遍历下方的行
     */
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int colSignal = 0, rowSignal = 0;
        for (int i = 0; i < row; i++) {
            // 重置行信号
            colSignal = 0;
            // 当前行下面没有0
            if (rowSignal < 0) {return;}
            for (int j = 0; j < col; j++) {
                // 当前列后续不需要遍历的信号，直接将列索引跳转至下一个0处
                if (colSignal > j) {
                    // for循环还会+1，需要减掉
                    j = colSignal - 1;
                    continue;
                }
                if (matrix[i][j] != 0) {
                    continue;
                }

                // 左
                for (int k = 0; k < j; k++) {
                    matrix[i][k] = 0;
                }
                // 上
                for (int k = 0; k < i; k++) {
                    matrix[k][j] = 0;
                }
                // 右
                for (int k = j+1; k < col; k++) {
                    // 右方还有为0的数，不处理，交与后方的0时处理
                    if (matrix[i][k] == 0) {
                        colSignal = k;
                        break;
                    }
                }
                // 当前行后续没有0
                if (colSignal <= j) {
                    for (int l = j+1; l < col; l++) {
                        matrix[i][l] = 0;
                        // 后续可以结束当前列的遍历
                        colSignal = col;
                    }
                }
                // 下
                // 已经确定下方没有0，直接将当前列下方变为0即可
                if (rowSignal < 0) {
                    for (int k = i+1; k < row; k++) {
                        matrix[k][j] = 0;
                    }
                }
                downFlag:
                for (int k = row-1; k > i; k--) {
                    for (int l = 0; l < col; l++) {
                        if (matrix[k][l] == 0) {
                            // 当前行有0，将当前元素置为0，跳出
                            matrix[k][j] = 0;
                            break downFlag;
                        }
                    }
                    // 遍历到当前遍历行都没有0，则将当前列置为0，且后续不需要再遍历后续行
                    if (k == i + 1) {
                        for (int l = row-1; l > i; l--) {
                            matrix[l][j] = 0;
                        }
                        // 下方没有0，通知循环不需要往下遍历后续行
                        rowSignal = -1;
                    }
                }
            }
        }


    }

    public static void main(String[] args) {
        SetZeroes_73 target = new SetZeroes_73();
        int[][] matrix = {{1,1,1}, {1,0,1}, {1,1,1}};
        matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        matrix = new int[][]{{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}};
        target.setZeroes(matrix);
        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 我们可以用矩阵的第一行和第一列代替方法一中的两个标记数组，以达到 O(1) 的额外空间。
     * 但这样会导致原数组的第一行和第一列被修改，无法记录它们是否原本包含 0。
     * 因此我们需要额外使用两个标记变量分别记录第一行和第一列是否原本包含 0。
     *
     * 在实际代码中，我们首先预处理出两个标记变量，接着使用其他行与列去处理第一行与第一列，
     * 然后反过来使用第一行与第一列去更新其他行与列，最后使用两个标记变量更新第一行与第一列即可。
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/set-matrix-zeroes/solutions/669901/ju-zhen-zhi-ling-by-leetcode-solution-9ll7/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param matrix
     * @description：使用数组第一行第一列去记录当前遍历的行与列，另使用两个标记遍量去记录第一行和第一列是否需要置为0
     */
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false, flagRow0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flagRow0 = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
