package arithmetic.easy;

/**
 * @Projectname: leetcode
 * @Filename: MaxCount_598
 * @Author: LWQ
 * @Data: 2023/8/18 21:49
 * @Description: easy
 */

/**
 * 给你一个 m x n 的矩阵 M ，初始化时所有的 0 和一个操作数组 op ，其中 ops[i] = [ai, bi]
 * 意味着当所有的 0 <= x < ai 和 0 <= y < bi 时， M[x][y] 应该加 1。
 *
 * 在 执行完所有操作后 ，计算并返回 矩阵中最大整数的个数 。
 *
 *
 *
 * 示例 1:
 *
 * /Users/luwanqiang/project/leetcode/src/main/java/comm/img/598_ex1.jpg
 *
 * 输入: m = 3, n = 3，ops = [[2,2],[3,3]]
 * 输出: 4
 * 解释: M 中最大的整数是 2, 而且 M 中有4个值为2的元素。因此返回 4。
 * 示例 2:
 *
 * 输入: m = 3, n = 3, ops = [[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3]]
 * 输出: 4
 * 示例 3:
 *
 * 输入: m = 3, n = 3, ops = []
 * 输出: 9
 *
 *
 * 提示:
 *
 * 1 <= m, n <= 4 * 104
 * 0 <= ops.length <= 104
 * ops[i].length == 2
 * 1 <= ai <= m
 * 1 <= bi <= n
 */
public class MaxCount_598 {

    /**
     * 通过
     * 时间详情：0ms，击败 100.00%使用 Java 的用户
     * 内存详情：42.42MB，击败 29.50%使用 Java 的用户
     * @param m
     * @param n
     * @param ops
     * @return
     * @desciption：每次一定在左上角范围进行累加，只需要找出被覆盖的最大区域即可
     */
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) {
            return m * n;
        }

        int row = m;
        int col = n;
        for (int i = 0; i < ops.length; i++) {
            row = row < ops[i][0] ? row : ops[i][0];
            col = col < ops[i][1] ? col : ops[i][1];
        }

        return row * col;
    }

    public static void main(String[] args) {
        MaxCount_598 target = new MaxCount_598();
        int param01 = 3;
        int param02 = 3;
        int[][] param03 = {{2,3},{3,3}};
        int result = target.maxCount(param01, param02, param03);
        System.out.println(result);
    }
}
