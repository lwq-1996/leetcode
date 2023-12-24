package arithmetic.easy;

/**
 * @Projectname: leetcode
 * @Filename: IsPowerOfFour_342_TODO
 * @Author: LWQ
 * @Data: 2023/12/24 12:13
 * @Description: easy
 */

/**
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 16
 * 输出：true
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：false
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：true
 *
 *
 * 提示：
 *
 * -231 <= n <= 231 - 1
 *
 *
 * 进阶：你能不使用循环或者递归来完成本题吗？
 */
public class IsPowerOfFour_342 {

    /**
     * 通过：
     * 时间详情：0ms，击败 100.00%使用 Java 的用户
     * 内存详情：39.68MB，击败 5.11%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/12/24 15:17
     * @Param [n]
     * @return boolean
     * @Description: 4的幂次方一定也是2的幂次方，且1的位置在从右往左基数位上
     * 0xaaaaaaaa --> 10101010101010101010101010101010
     */
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n-1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }

    public static void main(String[] args) {
        IsPowerOfFour_342 target = new IsPowerOfFour_342();
        int n = 16;
        boolean result = target.isPowerOfFour(n);
        System.out.println(result);
    }

    /**
     * @Author LWQ
     * @Date 2023/12/24 15:34
     * @Param [n]
     * @return boolean
     * @Description: 4的幂次方一定也是2的幂次方，且对3取余一定是1
     */
    public boolean isPowerOfFour2(int n) {
        return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
    }
}
