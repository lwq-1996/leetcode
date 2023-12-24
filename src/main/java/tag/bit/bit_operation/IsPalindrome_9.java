package tag.bit.bit_operation;

/**
 * @Projectname: leetcode
 * @Filename: IsPalindrome_9_TODO
 * @Author: LWQ
 * @Data: 2023/12/24 12:05
 * @Description: easy
 */

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 例如，121 是回文，而 123 不是。
 *
 *
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 *
 *
 * 提示：
 *
 * -231 <= x <= 231 - 1
 *
 *
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 */
public class IsPalindrome_9 {

    /**
     * 通过：
     * 时间详情：5ms，击败 98.33%使用 Java 的用户
     * 内存详情：43.04MB，击败 5.01%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/12/24 14:57
     * @Param [x]
     * @return boolean
     * @Description: 维护一个 前位除数 与一个 后位取余数
     * 前位每次取商的最后一位，后位每次取余数的最前一位
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int pre = 1;
        int tm = x;
        while (tm > 9) {
            tm /= 10;
            pre *= 10;
        }
        int fix = 10;

        while (pre >= fix) {
            int re_pre = x / pre % 10;
            int re_fix = (x % fix) / (fix/10);
            if (re_pre != re_fix) {
                return false;
            }

            pre /= 10;
            fix *= 10;
        }


        return true;
    }

    public static void main(String[] args) {
        IsPalindrome_9 target = new IsPalindrome_9();
        int x = 12000321;
        boolean result = target.isPalindrome(x);
        System.out.println(result);
    }

    /**
     * @Author LWQ
     * @Date 2023/12/24 15:01
     * @Param [x]
     * @return boolean
     * @Description: 反转一半数字
     */
    public boolean isPalindrome2(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
