package tag.bit.bit_operation;

/**
 * @Projectname: leetcode
 * @Filename: Reverse_7
 * @Author: LWQ
 * @Data: 2023/12/24 12:03
 * @Description: medium
 */

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 *
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 *
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 *
 * 输入：x = 0
 * 输出：0
 *
 *
 * 提示：
 *
 * -231 <= x <= 231 - 1
 */
public class Reverse_7 {

    /**
     * 通过：
     * 时间详情：0ms，击败 100.00%使用 Java 的用户
     * 内存详情：39.68MB，击败 5.75%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/12/24 13:55
     * @Param [x]
     * @return int
     * @Description: 数学计算，每次计算前检查是否超出32位数范围
     */
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        int result = 0;
        int flag = x>0 ? 1 : -1;
        while (x != 0) {
            int remainder = (x % 10) * flag;
            x /= 10;
            if ((Integer.MIN_VALUE+remainder)/10 > result*flag || (Integer.MAX_VALUE-remainder)/10 < result*flag) {
                return 0;
            }
            result = result*10 + remainder;
        }
        return result * flag;
    }

    public static void main(String[] args) {
        Reverse_7 target = new Reverse_7();
        int x = -123;
        int result = target.reverse2(x);
        System.out.println(result);
    }

    /**
     * @Author LWQ
     * @Date 2023/12/24 13:59
     * @Param [x]
     * @return int
     * @Description: 数学
     *  -123 % 10 = -3
     */
    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }
}
