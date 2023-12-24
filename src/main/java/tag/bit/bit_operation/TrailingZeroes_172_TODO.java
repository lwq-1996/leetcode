package tag.bit.bit_operation;

/**
 * @Projectname: leetcode
 * @Filename: TrailingZeroes_172_TODO
 * @Author: LWQ
 * @Data: 2023/12/24 12:46
 * @Description: medium
 */

/**
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 *
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：0
 * 解释：3! = 6 ，不含尾随 0
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：1
 * 解释：5! = 120 ，有一个尾随 0
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：0
 *
 *
 * 提示：
 *
 * 0 <= n <= 104
 *
 *
 * 进阶：你可以设计并实现对数时间复杂度的算法来解决此问题吗？
 */
public class TrailingZeroes_172_TODO {

    public int trailingZeroes(int n) {
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        TrailingZeroes_172_TODO target = new TrailingZeroes_172_TODO();
        int n = 3;
        int result = target.trailingZeroes(n);
        System.out.println(result);
    }
}
