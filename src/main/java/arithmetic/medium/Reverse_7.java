package arithmetic.medium;

/**
 * @Projectname: leetcode
 * @Filename: Reverse_7
 * @Author: LWQ
 * @Data:2022/9/4 16:01
 * @Description: leetcode_practice
 */

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Reverse_7 {

    /**
     * 执行结果： 通过
     * 执行用时：2 ms, 在所有 Java 提交中击败了 15.41%的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了 63.71%的用户
     * 通过测试用例：1032 / 1032
     */
    public int reverse(int x) {
        String s = String.valueOf(x);
        String star = "";
        if (s.startsWith("-")) {
            s = s.substring(1);
            star = "-";
        }
        StringBuilder builder = new StringBuilder(s);
        StringBuilder reverse = builder.reverse();
        Integer integer;
        try {
            integer = Integer.valueOf(star + reverse.toString());
        } catch (Exception e) {
            return 0;
        }
        return integer;
    }

    public static void main(String[] args) {
        int x = -123;
        Reverse_7 reverse_7 = new Reverse_7();
        int reverse = reverse_7.reverse2(x);
        System.out.println(reverse);
    }

    public int reverse2(int x) {
        long n = 0;
        while (x != 0) {
            n = n*10 + x%10;
            x/=10;
        }
        return (int)n == n ? (int)n : 0;
    }
}
