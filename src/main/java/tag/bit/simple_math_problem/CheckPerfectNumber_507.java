package tag.bit.simple_math_problem;

/**
 * @Projectname: leetcode
 * @Filename: CheckPerfectNumber_507_TODO
 * @Author: LWQ
 * @Data: 2023/12/24 13:11
 * @Description: easy
 */

/**
 * 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 *
 * 给定一个 整数 n， 如果是完美数，返回 true；否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num = 28
 * 输出：true
 * 解释：28 = 1 + 2 + 4 + 7 + 14
 * 1, 2, 4, 7, 和 14 是 28 的所有正因子。
 * 示例 2：
 *
 * 输入：num = 7
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= num <= 108
 */
public class CheckPerfectNumber_507 {

    /**
     * 通过：
     * 时间详情：1954ms，击败 27.07%使用 Java 的用户
     * 内存详情：39.16MB，击败 20.46%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2024/1/13 12:11
     * @Param [num]
     * @return boolean
     * @Description: 循环遍历
     */
    public boolean checkPerfectNumber(int num) {

        int result = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                result += i;
            }

            if (result > num) {
                return false;
            }
        }
        return result == num;
    }

    public static void main(String[] args) {
        CheckPerfectNumber_507 target = new CheckPerfectNumber_507();
        int num = 28;
        boolean result = target.checkPerfectNumber2(num);
        System.out.println(result);
    }

    /**
     * @Author LWQ
     * @Date 2024/1/13 12:29
     * @Param [num]
     * @return boolean
     * @Description: 枚举
     */
    public boolean checkPerfectNumber2(int num) {
        if (num == 1) {
            return false;
        }

        int sum = 1;
        for (int d = 2; d * d <= num; ++d) {
            if (num % d == 0) {
                sum += d;
                if (d * d < num) {
                    sum += num / d;
                }
            }
        }
        return sum == num;
    }

    /**
     * @Author LWQ
     * @Date 2024/1/13 12:30
     * @Param [num]
     * @return boolean
     * @Description: 官方打表
     */
    public boolean checkPerfectNumber3(int num) {
        return num == 6 || num == 28 || num == 496 || num == 8128 || num == 33550336;
    }
}
