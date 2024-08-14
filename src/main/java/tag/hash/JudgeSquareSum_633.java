package tag.hash;

/**
 * @Projectname: leetcode
 * @Filename: JudgeSquareSum_633
 * @Author: LWQ
 * @Data: 2024/6/29 13:25
 * @Description: medium
 */

import static java.lang.Double.NaN;

/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * 示例 2：
 *
 * 输入：c = 3
 * 输出：false
 *
 *
 * 提示：
 *
 * 0 <= c <= 231 - 1
 */
public class JudgeSquareSum_633 {

    /**
     * @Author LWQ
     * @Date 2024/6/29 13:46
     * @Param [c]
     * @return boolean
     * @Description: 2147482647 运行超时
     */
    public boolean judgeSquareSum(int c) {
        for (int i = 0; i < c/2 + 1; i++) {
            double sqrt = Math.sqrt(c - Math.pow(i, 2));
            // 取平方根存在无解情况
            if (!Double.isNaN(sqrt) && Double.compare(sqrt, Math.floor(sqrt)) == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * @Author LWQ
     * @Date 2024/6/29 14:09
     * @Param [c]
     * @return boolean
     * @Description:
     * 执行用时分布：5ms，击败36.77%
     * 消耗内存分布：39.51MB，击败32.50%
     */
    public boolean judgeSquareSum2(int c) {
        for (long i = 0; i * i <= c; i++) {
            double sqrt = Math.sqrt(c - i * i);
            // 取平方根存在无解情况
            if (sqrt == (int) sqrt) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JudgeSquareSum_633 target = new JudgeSquareSum_633();
        int c = 2;
        boolean result = target.judgeSquareSum2(c);
        System.out.println(result);
    }

    /**
     * @Author LWQ
     * @Date 2024/6/29 14:12
     * @Param [c]
     * @return boolean
     * @Description: 双指针
     * 不失一般性，可以假设 a≤b。初始时 a=0，b= Math.sqrt(c)
     * 进行如下操作：
     * 如果 a^2 + b^2 = c，我们找到了题目要求的一个解，返回 true；
     * 如果 a^2 + b^2 < c，此时需要将 a 的值加 1，继续查找；
     * 如果 a^2 + b^2 > c，此时需要将 b 的值减 1，继续查找。
     * 当 a=b 时，结束查找，此时如果仍然没有找到整数 a 和 b 满足 a^2 + b^2 = c，则说明不存在题目要求的解，返回 false。
     *
     */
    public boolean judgeSquareSum3(int c) {
        long left = 0;
        long right = (long) Math.sqrt(c);
        while (left <= right) {
            long sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}
