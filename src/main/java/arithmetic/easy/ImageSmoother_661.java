package arithmetic.easy;

/**
 * @Projectname: leetcode
 * @Filename: ImageSmoother_661
 * @Author: LWQ
 * @Data: 2023/8/18 21:46
 * @Description: easy
 */

/**
 * 图像平滑器 是大小为 3 x 3 的过滤器，用于对图像的每个单元格平滑处理，平滑处理后单元格的值为该单元格的平均灰度。
 *
 * 每个单元格的  平均灰度 定义为：该单元格自身及其周围的 8 个单元格的平均值，结果需向下取整。（即，需要计算蓝色平滑器中 9 个单元格的平均值）。
 *
 * 如果一个单元格周围存在单元格缺失的情况，则计算平均灰度时不考虑缺失的单元格（即，需要计算红色平滑器中 4 个单元格的平均值）。
 *
 * /Users/luwanqiang/project/leetcode/src/main/java/comm/img/661_smoother-grid.jpg
 *
 * 给你一个表示图像灰度的 m x n 整数矩阵 img ，返回对图像的每个单元格平滑处理后的图像 。
 *
 *
 *
 * 示例 1:
 *
 * /Users/luwanqiang/project/leetcode/src/main/java/comm/img/661_ex1.jpg
 *
 * 输入:img = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出:[[0, 0, 0],[0, 0, 0], [0, 0, 0]]
 * 解释:
 * 对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
 * 对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
 * 对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
 * 示例 2:
 * /Users/luwanqiang/project/leetcode/src/main/java/comm/img/661_ex2.jpg
 *
 * 输入: img = [[100,200,100],[200,50,200],[100,200,100]]
 * 输出: [[137,141,137],[141,138,141],[137,141,137]]
 * 解释:
 * 对于点 (0,0), (0,2), (2,0), (2,2): floor((100+200+200+50)/4) = floor(137.5) = 137
 * 对于点 (0,1), (1,0), (1,2), (2,1): floor((200+200+50+200+100+100)/6) = floor(141.666667) = 141
 * 对于点 (1,1): floor((50+200+200+200+200+100+100+100+100)/9) = floor(138.888889) = 138
 *
 *
 * 提示:
 *
 * m == img.length
 * n == img[i].length
 * 1 <= m, n <= 200
 * 0 <= img[i][j] <= 255
 */
public class ImageSmoother_661 {

    public int[][] imageSmoother(int[][] img) {
        return null;
    }

    public static void main(String[] args) {
        ImageSmoother_661 target = new ImageSmoother_661();
        int[][] param = {{1,1,1},{1,0,1},{1,1,1}};
        int[][] result = target.imageSmoother(param);
        System.out.println(result);
    }

    /**
     * 朴素解法，循环计算每一个元素的八连通平均数
     * @param img
     * @return
     */
    public int[][] imageSmoother2(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] ans = new int[m][n];
        int[][] dirs = new int[][]{{0,0},{1,0},{-1,0},{0,1},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int tot = 0, cnt = 0;
                for (int[] di : dirs) {
                    int nx = i + di[0], ny = j + di[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                    tot += img[nx][ny]; cnt++;
                }
                ans[i][j] = tot / cnt;
            }
        }
        return ans;
    }

    /**
     * 二维前缀和
     * @param img
     * @return
     */
    public int[][] imageSmoother3(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] sum = new int[m + 10][n + 10];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + img[i - 1][j - 1];
            }
        }
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int a = Math.max(0, i - 1), b = Math.max(0, j - 1);
                int c = Math.min(m - 1, i + 1), d = Math.min(n - 1, j + 1);
                int cnt = (c - a + 1) * (d - b + 1);
                int tot = sum[c + 1][d + 1] - sum[a][d + 1] - sum[c + 1][b] + sum[a][b];
                ans[i][j] = tot / cnt;
            }
        }
        return ans;
    }
}
