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
public class CheckPerfectNumber_507_TODO {

    public boolean checkPerfectNumber(int num) {
        return Boolean.FALSE;
    }

    public static void main(String[] args) {
        CheckPerfectNumber_507_TODO target = new CheckPerfectNumber_507_TODO();
        int num = 28;
        boolean result = target.checkPerfectNumber(num);
        System.out.println(result);
    }
}
