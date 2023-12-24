package tag.bit.bit_operation;

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
public class HammingDistance_461_TODO {

    public int hammingDistance(int x, int y) {
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        HammingDistance_461_TODO target = new HammingDistance_461_TODO();
        int x = 1, y = 4;
        int result = target.hammingDistance(x, y);
        System.out.println(result);
    }
}
