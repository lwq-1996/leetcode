package arithmetic.easy;

/**
 * @Projectname: leetcode
 * @Filename: IsPowerOfThree_326_TODO
 * @Author: LWQ
 * @Data: 2023/12/24 12:15
 * @Description: easy
 */

/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 27
 * 输出：true
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：false
 * 示例 3：
 *
 * 输入：n = 9
 * 输出：true
 * 示例 4：
 *
 * 输入：n = 45
 * 输出：false
 *
 *
 * 提示：
 *
 * -231 <= n <= 231 - 1
 *
 *
 * 进阶：你能不使用循环或者递归来完成本题吗？
 */
public class IsPowerOfThree_326 {

    /**
     * 通过：
     * 时间详情：9ms，击败 41.34%使用 Java 的用户
     * 内存详情：43.05MB，击败 5.22%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/12/24 16:04
     * @Param [n]
     * @return boolean
     * @Description:
     */
    public boolean isPowerOfThree(int n) {
        while (n > 0 && n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }

    public static void main(String[] args) {
        IsPowerOfThree_326 target = new IsPowerOfThree_326();
        int n = 27;
        boolean result = target.isPowerOfThree(n);
        System.out.println(result);
    }

    /**
     * @Author LWQ
     * @Date 2023/12/24 16:00
     * @Param [n]
     * @return boolean
     * @Description: 试除法，不断除以3
     */
    public boolean isPowerOfThree2(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    /**
     * @Author LWQ
     * @Date 2023/12/24 16:01
     * @Param [n]
     * @return boolean
     * @Description: 判断是否为最大 3 的幂的约数
     */
    public boolean isPowerOfThree3(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
