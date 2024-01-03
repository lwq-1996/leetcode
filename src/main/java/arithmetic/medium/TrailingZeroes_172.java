package arithmetic.medium;

/**
 * @Projectname: leetcode
 * @Filename: TrailingZeroes_172_TODO
 * @Author: LWQ
 * @Data: 2023/12/24 12:46
 * @Description: medium
 */

import java.math.BigDecimal;

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
public class TrailingZeroes_172 {

    /**
     * 通过：
     * 时间详情：0ms，击败 100.00%使用 Java 的用户
     * 内存详情：39.77MB，击败 5.17%使用 Java 的用户
     *
     * @param n
     * @return
     * @desception：题目用例中最大只有 10000
     */
    public int trailingZeroes(int n) {
        return n/5 + n/25 + n/125 + n/625 + n/3125;
    }

    /**
     * 通过：
     * 时间详情：0ms，击败 100.00%使用 Java 的用户
     * 内存详情：39.65MB，击败 8.09%使用 Java 的用户
     *
     * @param n
     * @return
     * @desception：
     */
    public int trailingZeroes2(int n) {
        int div = 5, result = 0;
        while (n >= div) {
            result += n/div;
            div *= 5;
        }

        return result;
    }

    public static void main(String[] args) {
        TrailingZeroes_172 target = new TrailingZeroes_172();
        int n = 3;
        int result = target.trailingZeroes(n);
        System.out.println(result);
        BigDecimal bigDecimal = new BigDecimal(1);
        for (int i = 1; i <= 25; i++) {
            if (i == 20) {
                System.out.println(i);
            }
            bigDecimal = bigDecimal.multiply(new BigDecimal(i));
        }
    }

    /**
     * @param n
     * @return
     * @的是测评体哦那：数学
     * n! 尾零的数量即为 n! 中因子 10 的个数，而 10=2×5，因此转换成求 n! 中质因子 2 的个数和质因子 5 的个数的较小值。
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/factorial-trailing-zeroes/solutions/1360892/jie-cheng-hou-de-ling-by-leetcode-soluti-1egk/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int trailingZeroes3(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }
}
