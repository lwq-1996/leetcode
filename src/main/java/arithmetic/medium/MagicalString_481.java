package arithmetic.medium;

/**
 * @Projectname: leetcode
 * @Filename: MagicalString_481
 * @Author: LWQ
 * @Data: 2023/12/4 23:10
 * @Description: medium
 */

/**
 * 神奇字符串 s 仅由 '1' 和 '2' 组成，并需要遵守下面的规则：
 *
 * 神奇字符串 s 的神奇之处在于，串联字符串中 '1' 和 '2' 的连续出现次数可以生成该字符串。
 * s 的前几个元素是 s = "1221121221221121122……" 。如果将 s 中连续的若干 1 和 2 进行分组，可以得到 "1 22 11 2 1 22 1 22 11 2 11 22 ......" 。每组中 1 或者 2 的出现次数分别是 "1 2 2 1 1 2 1 2 2 1 2 2 ......" 。上面的出现次数正是 s 自身。
 *
 * 给你一个整数 n ，返回在神奇字符串 s 的前 n 个数字中 1 的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 6
 * 输出：3
 * 解释：神奇字符串 s 的前 6 个元素是 “122112”，它包含三个 1，因此返回 3 。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= n <= 105
 */
public class MagicalString_481 {

    /**
     * 通过：
     * 时间详情：2ms，击败 100.00%使用 Java 的用户
     * 内存详情：39.54MB，击败 45.45%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/12/16 10:12
     * @Param [n]
     * @return int
     * @Description: 双指针
     * 使用char[]记录神奇数
     * 因为神奇数只有1、2，所有可使用 3 - char[write - 1] 来决定下一位数
     */
    public int magicalString(int n) {
        if (n < 4) {
            return 1;
        }
        char[] chars = new char[n];
        chars[0] = '1';
        chars[1] = '2';
        chars[2] = '2';
        // read 当前读取的位置，write 需要进行写入的位置
        // 初始化 "122"
        int result = 1, read = 2, write = 3;
        while (write < n) {
            int size = chars[read] - '0';
            // 神奇数中只有 1、2
            int num = 3 + '0' - chars[write - 1];
            while (size > 0 && write < n) {
                chars[write] = (char) (num + '0');
                if (num == 1) {
                    result++;
                }
                write++;
                size--;
            }
            read++;
        }
        return result;
    }

    public static void main(String[] args) {
        MagicalString_481 target = new MagicalString_481();
        int n = 6;
        int result = target.magicalString(n);
        System.out.println(result);
    }

    /**
     * @Author LWQ
     * @Date 2023/12/16 10:01
     * @Param [n]
     * @return int
     * @Description: 双指针
     * 初始化神奇数："122"
     * i -> readIndex，需要构造的下一个组
     * j -> writeIndex，写入的神奇数的当前位置
     */
    public int magicalString2(int n) {
        if (n < 4) {
            return 1;
        }
        char[] s = new char[n];
        s[0] = '1';
        s[1] = '2';
        s[2] = '2';
        int res = 1;
        int i = 2;
        int j = 3;
        while (j < n) {
            int size = s[i] - '0';
            int num = 3 - (s[j - 1] - '0');
            while (size > 0 && j < n) {
                s[j] = (char) ('0' + num);
                if (num == 1) {
                    ++res;
                }
                ++j;
                --size;
            }
            ++i;
        }
        return res;
    }
}
