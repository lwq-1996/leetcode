package tag.array.twodimensional_traversal;

/**
 * @Projectname: leetcode
 * @Filename: FindDiagonalOrder_498
 * @Author: LWQ
 * @Data: 2023/11/8 13:33
 * @Description: medium
 */

import java.util.Arrays;

/**
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 *
 *
 *
 * 示例 1：
 * /Users/luwanqiang/project/leetcode/src/main/java/comm/img/498_ex1.jpg
 *
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,4,7,5,3,6,8,9]
 * 示例 2：
 *
 * 输入：mat = [[1,2],[3,4]]
 * 输出：[1,2,3,4]
 *
 *
 * 提示：
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * -105 <= mat[i][j] <= 105
 */
public class FindDiagonalOrder_498 {

    /**
     * 通过：
     * 时间详情：1ms，击败 99.24%使用 Java 的用户
     * 内存详情：43.62MB，击败 97.23%使用 Java 的用户
     * @param mat
     * @return
     * @descption：对角线遍历时，对角线存在下一元素时row、col一增一减，当到达边界时row/col加1，进行下次对角线遍历
     *  到达边界后的下一位一栋分上下部分，若上半部分是col右移一位在越过整个矩阵对角线后，
     *  每次遍历row都会到达边界，col已不可右移，此时需要将row下移一位
     */
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] result = new int[m*n];
        // 遍历的当前坐标，row范围[0，mat.length-1]，col范围[0, mat[0].length-1]
        int row = 0, col = 0;
        // 结果数组当前下标
        int current = 0;

        while (true) {
            // m、n为二维数组长度，不是边界坐标，不需要=
            // 左下往右上方向对角线
            while (row >= 0 && col < n) {
                result[current++] = mat[row--][col++];
            }
            // 使用单'&' 将上一步到边界后多加的一轮恢复，此逻辑走过后，row、col为当前的二维下标
            if (++row == m & --col == n) {
                break;
            } else if (col < n-1){
                // 上半部分，此时到达边界后右移一位，此时未到右边界
                col++;
            } else {
                // 已到达右边界，下一步需要下移一位
                row++;
            }

            // 右上往左下方向对角线
            while (row < m && col >= 0) {
                result[current++] = mat[row++][col--];
            }
            if (--row == m & ++col == n) {
                break;
            } else if (row < m-1){
                // 上半部分，此时到达边界后下移一位，此时未到下边界
                row++;
            } else {
                // 已到达下边界，下一步需要右移一位
                col++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindDiagonalOrder_498 target = new FindDiagonalOrder_498();
        int[][] mat = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[] result = target.findDiagonalOrder(mat);
        System.out.println(Arrays.toString(result));
    }
}
