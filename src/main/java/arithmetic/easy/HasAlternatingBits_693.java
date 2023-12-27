package arithmetic.easy;

/**
 * @Projectname: leetcode
 * @Filename: HasAlternatingBits_693_TODO
 * @Author: LWQ
 * @Data: 2023/12/24 12:42
 * @Description: easy
 */

/**
 * 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 5
 * 输出：true
 * 解释：5 的二进制表示是：101
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：false
 * 解释：7 的二进制表示是：111.
 * 示例 3：
 *
 * 输入：n = 11
 * 输出：false
 * 解释：11 的二进制表示是：1011.
 *
 *
 * 提示：
 *
 * 1 <= n <= 231 - 1
 */
public class HasAlternatingBits_693 {

    /**
     * 通过：
     * 时间详情：0ms，击败 100.00%使用 Java 的用户
     * 内存详情：39.16MB，击败 5.83%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/12/27 20:47
     * @Param [n]
     * @return boolean
     * @Description: 右移做异或运算，得到低位全是1，加1后为2的次幂
     */
    public boolean hasAlternatingBits(int n) {
        int m = (n ^ n >> 1) + 1;
        return (m & (m - 1)) == 0;
    }

    /**
     * @Author LWQ
     * @Date 2023/12/27 20:52
     * @Param [n]
     * @return boolean
     * @Description: 相较于plan1，少做一次减法运算
     */
    public boolean hasAlternatingBits2(int n) {
        int a = n ^ n >> 1;
        return (a & (a + 1)) == 0;
    }

    public static void main(String[] args) {
        HasAlternatingBits_693 target = new HasAlternatingBits_693();
        int n = 10;
        boolean result = target.hasAlternatingBits(n);
        System.out.println(result);
    }
}
