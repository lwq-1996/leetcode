package arithmetic.easy;

/**
 * @Projectname: leetcode
 * @Filename: FindComplement_476_TODO
 * @Author: LWQ
 * @Data: 2023/12/24 12:36
 * @Description: easy
 */

/**
 * 对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。
 *
 * 例如，整数 5 的二进制表示是 "101" ，取反后得到 "010" ，再转回十进制表示得到补数 2 。
 * 给你一个整数 num ，输出它的补数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num = 5
 * 输出：2
 * 解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 * 示例 2：
 *
 * 输入：num = 1
 * 输出：0
 * 解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 *
 *
 * 提示：
 *
 * 1 <= num < 231
 *
 *
 * 注意：本题与 1009 https://leetcode-cn.com/problems/complement-of-base-10-integer/ 相同
 */
public class FindComplement_476 {

    /**
     * 通过：
     * 时间详情：0ms，击败 100.00%使用 Java 的用户
     * 内存详情：39.51MB，击败 5.10%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/12/27 12:38
     * @Param [num]
     * @return int
     * @Description: 找出最高位，减1后左移一位，再加1，即得到最高位与num一致且低位全1的掩码，最后与num做异或运算取反即可
     */
    public int findComplement(int num) {
        return ((Integer.highestOneBit(num) - 1 << 1) + 1) ^ num;
    }

    public static void main(String[] args) {
        FindComplement_476 target = new FindComplement_476();
        int num = 5;
        int result = target.findComplement(num);
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(result);
    }

    /**
     * @Author LWQ
     * @Date 2023/12/27 12:43
     * @Param [num]
     * @return int
     * @Description: 模拟
     */
    public int findComplement2(int num) {
        int x = 0;
        for (int i = num; i != 0; i -= i & -i) x = i;
        return ~num & (x - 1);
    }

    /**
     * @Author LWQ
     * @Date 2023/12/27 12:44
     * @Param [num]
     * @return int
     * @Description: 位运算
     */
    public int findComplement3(int num) {
        int highbit = 0;
        for (int i = 1; i <= 30; ++i) {
            if (num >= 1 << i) {
                highbit = i;
            } else {
                break;
            }
        }
        int mask = highbit == 30 ? 0x7fffffff : (1 << (highbit + 1)) - 1;
        return num ^ mask;
    }

    public int findComplement4(int num) {
        int t = num;
        t |= t >> 1;
        t |= t >> 2;
        t |= t >> 4;
        t |= t >> 8;
        t |= t >> 16;
        return ~num & t;
    }
}
