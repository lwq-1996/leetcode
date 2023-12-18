package tag.string.operation_highprecision;

/**
 * @Projectname: leetcode
 * @Filename: AddBinary_67_TODO
 * @Author: LWQ
 * @Data: 2023/12/16 10:30
 * @Description: easy
 */

/**
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 *
 *
 *
 * 示例 1：
 *
 * 输入:a = "11", b = "1"
 * 输出："100"
 * 示例 2：
 *
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 *
 *
 * 提示：
 *
 * 1 <= a.length, b.length <= 104
 * a 和 b 仅由字符 '0' 或 '1' 组成
 * 字符串如果不是 "0" ，就不含前导零
 */
public class AddBinary_67 {

    /**
     * 通过：
     * 时间详情：1ms，击败 99.87%使用 Java 的用户
     * 内存详情：40.17MB,击败 63.77%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/12/17 14:22
     * @Param [a, b]
     * @return java.lang.String
     * @Description: 遍历，逐个相加
     * StringBuilder.insert() 性能较差，随着 StringBuilder 长度的增加呈阶数增长，所以使用StringBuilder.reverse()
     */
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        int l1 = a.length() - 1;
        int l2 = b.length() - 1;
        while (l1 >= 0 || l2 >= 0) {
            int m = 0, n = 0;
            if (l1 >= 0) {
                m = a.charAt(l1--) - '0';
            }
            if (l2 >= 0) {
                n = b.charAt(l2--) - '0';
            }
            result.append((m+n+count) % 2);
            count = (m+n+count) / 2;
        }
        // 最高位需要 进1
        if (count > 0) {
            result.append("1");
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary_67 target = new AddBinary_67();
        String a = "11", b = "1";
        String result = target.addBinary(a, b);
        System.out.println(result);
    }
}
