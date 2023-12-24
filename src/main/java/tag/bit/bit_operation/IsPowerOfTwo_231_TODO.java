package tag.bit.bit_operation;

/**
 * @Projectname: leetcode
 * @Filename: IsPowerOfTwo_231_TODO
 * @Author: LWQ
 * @Data: 2023/12/24 12:11
 * @Description: easy
 */

/**
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 1
 * 输出：true
 * 解释：20 = 1
 * 示例 2：
 *
 * 输入：n = 16
 * 输出：true
 * 解释：24 = 16
 * 示例 3：
 *
 * 输入：n = 3
 * 输出：false
 * 示例 4：
 *
 * 输入：n = 4
 * 输出：true
 * 示例 5：
 *
 * 输入：n = 5
 * 输出：false
 *
 *
 * 提示：
 *
 * -231 <= n <= 231 - 1
 *
 *
 * 进阶：你能够不使用循环/递归解决此问题吗？
 */
public class IsPowerOfTwo_231_TODO {

    /**
     * 通过：
     * 时间详情：0ms，击败 100.00%使用 Java 的用户
     * 内存详情：39.89MB，击败 5.10%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/12/24 15:10
     * @Param [n]
     * @return boolean
     * @Description:
     */
    public boolean isPowerOfTwo(int n) {
        return n <= 0 ? false : (n & (n-1)) == 0;
    }

    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }

    public static void main(String[] args) {
        IsPowerOfTwo_231_TODO target = new IsPowerOfTwo_231_TODO();
        int n = -2;
        boolean result = target.isPowerOfTwo(n);
        System.out.println(result);
    }
}
