package tag.array.twodimensional_change;

/**
 * @Projectname: leetcode
 * @Filename: GameOfLife_289
 * @Author: LWQ
 * @Data: 2023/11/8 22:16
 * @Description: medium
 */

import java.util.Arrays;

/**
 * 根据 百度百科 ， 生命游戏 ，简称为 生命 ，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 *
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态： 1 即为 活细胞 （live），或 0 即为 死细胞 （dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
 *
 *
 *
 * 示例 1：
 * /Users/luwanqiang/project/leetcode/src/main/java/comm/img/289_ex1.jpg
 *
 * 输入：board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
 * 输出：[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
 * 示例 2：
 * /Users/luwanqiang/project/leetcode/src/main/java/comm/img/289_ex2.jpg
 *
 * 输入：board = [[1,1],[1,0]]
 * 输出：[[1,1],[1,1]]
 *
 *
 * 提示：
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 25
 * board[i][j] 为 0 或 1
 *
 *
 * 进阶：
 *
 * 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
 * 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？
 */
public class GameOfLife_289 {

    /**
     * 通过：
     * 时间详情：0ms，击败 100.00%使用 Java 的用户
     * 内存详情：38.66MB，击败 67.96%使用 Java 的用户
     * @param board
     * @descption：仅使用了int的最低位表示细胞存活状态，其他位未使用，使用第二位表示变更后的状态，即使用额外的状态
     */
    public void gameOfLife(int[][] board) {
        int rowLth = board.length;
        int colLth = board[0].length;

        // 周围1的数量
        int count = 0;
        for (int i = 0; i < rowLth; i++) {
            for (int j = 0; j < colLth; j++) {
                // count 需要排除自己
                for (int k = i-1; k <= i+1; k++) {
                    if (k < 0 || k >= rowLth) {continue;}
                    for (int l = j-1; l <= j+1; l++) {
                        if (l < 0 || l >= colLth) {continue;}
                        if (k == i && l == j) {continue;}
                        if (board[k][l] % 2 == 1) {
                            count++;
                        }
                    }
                }

                // 死亡状态，原来第二位就是0，不处理
                // 少于2个死亡
                // 刚好2个时原存活的继续存活
                if (board[i][j] == 1 && count == 2) {
                    board[i][j] |= 2;
                }
                // 刚好3个时一定存活
                if (count == 3) {
                    board[i][j] |= 2;
                }
                // 超过3个时死亡

                // 重置
                count = 0;
            }
        }

        for (int i = 0; i < rowLth; i++) {
            for (int j = 0; j < colLth; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    public static void main(String[] args) {
        GameOfLife_289 target = new GameOfLife_289();
        int[][] board = {{0,1,0}, {0,0,1}, {1,1,1}, {0,0,0}};
        target.gameOfLife(board);
        for (int[] arr : board) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
