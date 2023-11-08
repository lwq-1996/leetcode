package tag.array.twodimensional_and_roll;

/**
 * @Projectname: leetcode
 * @Filename: CountBattleships_419
 * @Author: LWQ
 * @Data: 2023/8/18 21:51
 * @Description: medium
 */

/**
 * 给你一个大小为 m x n 的矩阵 board 表示甲板，其中，每个单元格可以是一艘战舰 'X' 或者是一个空位 '.' ，
 * 返回在甲板 board 上放置的 战舰 的数量。
 *
 * 战舰 只能水平或者垂直放置在 board 上。换句话说，战舰只能按 1 x k（1 行，k 列）或 k x 1（k 行，1 列）的形状建造，
 * 其中 k 可以是任意大小。两艘战舰之间至少有一个水平或垂直的空位分隔 （即没有相邻的战舰）。
 *
 *
 *
 * 示例 1：
 * /Users/luwanqiang/project/leetcode/src/main/java/comm/img/419_ex1.jpg
 *
 * 输入：board = [['X','.','.','X'],['.','.','.','X'],['.','.','.','X']]
 * 输出：2
 * 示例 2：
 *
 * 输入：board = [['.']]
 * 输出：0
 *
 *
 * 提示：
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 是 '.' 或 'X'
 *
 *
 * 进阶：你可以实现一次扫描算法，并只使用 O(1) 额外空间，并且不修改 board 的值来解决这个问题吗？
 */
public class CountBattleships_419 {

    /**
     * 通过
     * 时间详情：0ms，击败 100.00%使用 Java 的用户
     * 内存详情：41.71MB，击败 40.42%使用 Java 的用户
     * @param board
     * @return
     * @description：统计每一行的战舰数量，统计时若当前元素上方也为战舰，则二者为同一战舰，不统计
     */
    public int countBattleships(char[][] board) {
        int row = board.length, col = board[0].length;

        int result = 0;
        char last = '.';
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 统计每一行的数量
                if (board[i][j] == 'X' && last == '.') {
                    // 每一列上方出现过，则不统计
                    if (i > 0 && board[i-1][j] == 'X') {
                        continue;
                    }
                    result += 1;
                }
                last = board[i][j];
            }
            // 每一行走完重置
            last = '.';
        }
        return result;
    }

    public static void main(String[] args) {
        CountBattleships_419 target = new CountBattleships_419();
        char[][] param = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        int result = target.countBattleships(param);
        System.out.println(result);
    }
}
