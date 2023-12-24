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
public class IsPalindrome_9_TODO {

    public boolean isPalindrome(int x) {
        return Boolean.FALSE;
    }

    public static void main(String[] args) {
        IsPalindrome_9_TODO target = new IsPalindrome_9_TODO();
        int x = 121;
        boolean result = target.isPalindrome(x);
        System.out.println(result);
    }
}
