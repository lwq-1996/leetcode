package tag.bit.bit_operation;

/**
 * @Projectname: leetcode
 * @Filename: NearestPalindromic_564_HARD
 * @Author: LWQ
 * @Data: 2023/12/24 12:09
 * @Description: hard
 */

/**
 * 给定一个表示整数的字符串 n ，返回与它最近的回文整数（不包括自身）。如果不止一个，返回较小的那个。
 *
 * “最近的”定义为两个整数差的绝对值最小。
 *
 *
 *
 * 示例 1:
 *
 * 输入: n = "123"
 * 输出: "121"
 * 示例 2:
 *
 * 输入: n = "1"
 * 输出: "0"
 * 解释: 0 和 2是最近的回文，但我们返回最小的，也就是 0。
 *
 *
 * 提示:
 *
 * 1 <= n.length <= 18
 * n 只由数字组成
 * n 不含前导 0
 * n 代表在 [1, 1018 - 1] 范围内的整数
 */
public class NearestPalindromic_564_HARD {

    public String nearestPalindromic(String n) {
        return "";
    }

    public static void main(String[] args) {
        NearestPalindromic_564_HARD target = new NearestPalindromic_564_HARD();
        String n = "123";
        String result = target.nearestPalindromic(n);
        System.out.println(result);
    }
}
