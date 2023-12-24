package tag.bit.bit_operation;

/**
 * @Projectname: leetcode
 * @Filename: LargestPalindrome_479_HARD
 * @Author: LWQ
 * @Data: 2023/12/24 12:07
 * @Description: hard
 */

/**
 * 给定一个整数 n ，返回 可表示为两个 n 位整数乘积的 最大回文整数 。因为答案可能非常大，所以返回它对 1337 取余 。
 *
 *
 *
 * 示例 1:
 *
 * 输入：n = 2
 * 输出：987
 * 解释：99 x 91 = 9009, 9009 % 1337 = 987
 * 示例 2:
 *
 * 输入： n = 1
 * 输出： 9
 *
 *
 * 提示:
 *
 * 1 <= n <= 8
 */
public class LargestPalindrome_479_HARD {

    public int largestPalindrome(int n) {
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        LargestPalindrome_479_HARD target = new LargestPalindrome_479_HARD();
        int n = 2;
        int result = target.largestPalindrome(n);
        System.out.println(result);
    }
}
