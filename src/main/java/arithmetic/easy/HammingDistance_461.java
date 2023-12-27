package arithmetic.easy;

/**
 * @Projectname: leetcode
 * @Filename: HammingDistance_461_TODO
 * @Author: LWQ
 * @Data: 2023/12/24 12:38
 * @Description: easy
 */

/**
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 *
 *
 *
 * 示例 1：
 *
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 * 示例 2：
 *
 * 输入：x = 3, y = 1
 * 输出：1
 *
 *
 * 提示：
 *
 * 0 <= x, y <= 231 - 1
 */
public class HammingDistance_461 {

    /**
     * 通过：
     * 时间详情：0ms，击败 100.00%使用 Java 的用户
     * 内存详情：39.29MB，击败 5.02%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/12/27 12:56
     * @Param [x, y]
     * @return int
     * @Description: 找出不同位，再统计
     */
    public int hammingDistance(int x, int y) {
        int xoy = x ^ y;
        int result = 0;
        while (xoy != 0) {
            xoy &= (xoy-1);
            result++;
        }

        return result;
    }

    /**
     * @Author LWQ
     * @Date 2023/12/27 12:58
     * @Param [x, y]
     * @return int
     * @Description: API
     */
    public int hammingDistance2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args) {
        HammingDistance_461 target = new HammingDistance_461();
        int x = 1, y = 4;
        int result = target.hammingDistance(x, y);
        System.out.println(result);
    }
}
