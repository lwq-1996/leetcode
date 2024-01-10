package arithmetic.medium;

/**
 * @Projectname: leetcode
 * @Filename: CountNumbersWithUniqueDigits_357_TODO
 * @Author: LWQ
 * @Data: 2023/12/24 13:04
 * @Description: medium
 */

/**
 * 给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10n 。
 *
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：91
 * 解释：答案应为除去 11、22、33、44、55、66、77、88、99 外，在 0 ≤ x < 100 范围内的所有数字。
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：1
 *
 *
 * 提示：
 *
 * 0 <= n <= 8
 */
public class CountNumbersWithUniqueDigits_357 {

    public int countNumbersWithUniqueDigits(int n) {
        if (n < 2) {
            return (int) Math.pow(10, n);
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        CountNumbersWithUniqueDigits_357 target = new CountNumbersWithUniqueDigits_357();
        int n = 4;
        int result = target.countNumbersWithUniqueDigits2(n);
        System.out.println(result);
    }

    /**
     * @param n
     * @return
     * @desception：排列组合
     * 数学推导
     */
    public int countNumbersWithUniqueDigits2(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int res = 10, cur = 9;
        for (int i = 0; i < n - 1; i++) {
            cur *= 9 - i;
            res += cur;
        }
        return res;
    }
}
