package tag.bit.bit_operation;

/**
 * @Projectname: leetcode
 * @Filename: IsUgly_263_TODO
 * @Author: LWQ
 * @Data: 2023/12/24 12:19
 * @Description: easy
 */

/**
 * 丑数 就是只包含质因数 2、3 和 5 的正整数。
 *
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 6
 * 输出：true
 * 解释：6 = 2 × 3
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：true
 * 解释：1 没有质因数，因此它的全部质因数是 {2, 3, 5} 的空集。习惯上将其视作第一个丑数。
 * 示例 3：
 *
 * 输入：n = 14
 * 输出：false
 * 解释：14 不是丑数，因为它包含了另外一个质因数 7 。
 *
 *
 * 提示：
 *
 * -231 <= n <= 231 - 1
 */
public class IsUgly_263 {

    /**
     * 通过：
     * 时间详情：0ms，击败 100.00%使用 Java 的用户
     * 内存详情：39.82MB，击败 5.09%使用 Java 的用户
     *
     * @param n
     * @return
     * @desception：一直除以2、3、5
     */
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] data = {2,3,5};
        for (int d : data) {
            while (n % d == 0) {
                n /= d;
            }
        }

        return n == 1;
    }

    public static void main(String[] args) {
        IsUgly_263 target = new IsUgly_263();
        int n = 6;
        boolean result = target.isUgly(n);
        System.out.println(result);
    }
}
