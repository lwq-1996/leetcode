package arithmetic.easy;

/**
 * @Projectname: leetcode
 * @Filename: IsPowerOfTwo_231
 * @Author: LWQ
 * @Data:2022/11/21 22:28
 * @Description: leetcode_practice
 * 
 * 
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 x 使得n == 2x ，则认为 n 是 2 的幂次方。
 *
 *
 * 示例 1：
 *
 * 输入：n = 1
 * 输出：true
 * 解释：20 = 1
 * 示例 2：
 *
 * 输入：n = 16
 * 输出：true
 * 解释：24 = 16
 * 示例 3：
 *
 * 输入：n = 3
 * 输出：false
 * 示例 4：
 *
 * 输入：n = 4
 * 输出：true
 * 示例 5：
 *
 * 输入：n = 5
 * 输出：false
 * 
 * 提示：
 *
 * -231 <= n <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/power-of-two
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class IsPowerOfTwo_231 {

    public static void main(String[] args) {
        IsPowerOfTwo_231 isPowerOfTwo_231 = new IsPowerOfTwo_231();
        int n = 8;
        boolean powerOfTwo = isPowerOfTwo_231.isPowerOfTwo(n);
        System.out.println(powerOfTwo);
    }

    /**
     * 解法1：&运算，同1则1。 return (n > 0) && (n & -n) == n;
     *  解释：2的幂次方在二进制下，只有1位是1，其余全是0。
     *      例如:8---00001000。负数的在计算机中二进制表示为补码(原码->正常二进制表示，
     *      原码按位取反(0-1,1-0)，最后再+1。然后两者进行与操作，得到的肯定是原码中最后一个二进制的1。
     *      例如8&(-8)->00001000 & 11111000 得 00001000，即8。
     * 解法2：移位运算：把二进制数进行左右移位。左移1位，扩大2倍；右移1位，缩小2倍。 return (n>0) && (1<<30) % n == 0;
     *  解释：1<<30得到最大的2的整数次幂，对n取模如果等于0，说明n只有因子2。
     */
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && (n & -n) == n;
    }
}
