package arithmetic.easy;

/**
 * @Projectname: leetcode
 * @Filename: IsUgly_263
 * @Author: LWQ
 * @Data:2023/5/26 20:42
 * @Description: leetcode_practice
 * 丑数 就是只包含质因数2、3 和 5的正整数。
 *
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：n = 6
 * 输出：true
 * 解释：6 = 2 × 3
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：true
 * 解释：1 没有质因数，因此它的全部质因数是 {2, 3, 5} 的空集。习惯上将其视作第一个丑数。
 * 示例 3：
 *
 * 输入：n = 14
 * 输出：false
 * 解释：14 不是丑数，因为它包含了另外一个质因数7 。
 * 
 *
 * 提示：
 *
 * -231 <= n <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ugly-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class IsUgly_263 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了40.12%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了68.77%的用户
     * 通过测试用例：1013 / 1013
     * @param n
     * @return
     */
    public boolean isUgly(int n) {
        if (n < 0) {
            return false;
        }

        while (n % 5 == 0) {
            n /= 5;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while ((n & 1) == 0) {
            n >>= 1;
        }

        return n == 1;
    }

    public static void main(String[] args) {
        IsUgly_263 isUgly_263 = new IsUgly_263();
        int n = 6;
        boolean ugly = isUgly_263.isUgly(n);
        System.out.println(ugly);
    }
}
