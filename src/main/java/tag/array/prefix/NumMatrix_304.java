package tag.array.prefix;

/**
 * @Projectname: leetcode
 * @Filename: NumMatrix_304
 * @Author: LWQ
 * @Data: 2023/11/8 22:37
 * @Description: medium
 */

/**
 * 给定一个二维矩阵 matrix，以下类型的多个请求：
 *
 * 计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1, col1) ，右下角 为 (row2, col2) 。
 * 实现 NumMatrix 类：
 *
 * NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
 * int sumRegion(int row1, int col1, int row2, int col2) 返回 左上角 (row1, col1) 、右下角 (row2, col2) 所描述的子矩阵的元素 总和 。
 *
 *
 * 示例 1：
 *
 * /Users/luwanqiang/project/leetcode/src/main/java/comm/img/304_ex1.jpg
 *
 * 输入:
 * ["NumMatrix","sumRegion","sumRegion","sumRegion"]
 * [[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]
 * 输出:
 * [null, 8, 11, 12]
 *
 * 解释:
 * NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]);
 * numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
 * numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
 * numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
 *
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 200
 * -105 <= matrix[i][j] <= 105
 * 0 <= row1 <= row2 < m
 * 0 <= col1 <= col2 < n
 * 最多调用 104 次 sumRegion 方法
 */
public class NumMatrix_304 {
    int[][] sums;

    /**
     * 通过：
     * 时间详情：118ms，击败 34.00%使用 Java 的用户
     * 内存详情：69.25MB，击败 5.04%使用 Java 的用户
     * @param matrix
     * @desception：一维前缀和，记录每一行的前缀和
     */
    /*public NumMatrix_304(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        sums = new int[m][n+1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sums[i][j+1] = sums[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        for (int i = row1; i <= row2; i++) {
            result += sums[i][col2+1] - sums[i][col1];
        }
        return result;
    }*/

    /**
     * 通过：
     * 时间详情：97ms，击败 99.66%使用 Java 的用户
     * 内存详情：68.86MB，击败 12.09%使用 Java 的用户
     * @param matrix
     * @desception：二维前缀和，
     *      田字形，已知整体面积，上面面积，左边面积，左上面积，求右下角矩形的面积。 右下角矩形的面积=整体面积-上面面积-左边面积+左上面积
     *      计算时需要减去重复想加的部分
     */
    public NumMatrix_304(int[][] matrix) {
        int m = matrix.length;
        if (m <= 0) {return;}
        int n = matrix[0].length;
        sums = new int[m+1][n+1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sums[i+1][j+1] = sums[i][j+1] + sums[i+1][j] - sums[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (sums == null) {return 0;}
        return sums[row2+1][col2+1] - sums[row2+1][col1] - sums[row1][col2+1] + sums[row1][col1];
    }
    /**
     * Your NumMatrix object will be instantiated and called as such:
     * NumMatrix obj = new NumMatrix(matrix);
     * int param_1 = obj.sumRegion(row1,col1,row2,col2);
     */

    public static void main(String[] args) {
        int[][] matrix = {{3,0,1,4,2}, {5,6,3,2,1}, {1,2,0,1,5}, {4,1,0,1,7}, {1,0,3,0,5}};
        matrix = new int[][]{};
        int[][] region = {{2,1,4,3}, {1,1,2,2}, {1,2,2,4}};
        NumMatrix_304 numMatrix304 = new NumMatrix_304(matrix);
        for (int[] arr : region) {
            int result = numMatrix304.sumRegion(arr[0], arr[1], arr[2], arr[3]);
            System.out.println(result);
        }
    }
}
