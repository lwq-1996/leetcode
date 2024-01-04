package arithmetic.easy;

/**
 * @Projectname: leetcode
 * @Filename: ToHex_405_TODO
 * @Author: LWQ
 * @Data: 2023/12/24 12:56
 * @Description: easy
 */

/**
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 *
 * 注意:
 *
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 * 示例 1：
 *
 * 输入:
 * 26
 *
 * 输出:
 * "1a"
 * 示例 2：
 *
 * 输入:
 * -1
 *
 * 输出:
 * "ffffffff"
 */
public class ToHex_405 {

    /**
     * 通过：
     * 执行用时分布：0ms，击败100.00%使用 Java 的用户
     * 消耗内存分布：39.73MB，击败13.12%使用 Java 的用户
     *
     * @param num
     * @return
     * @desception：位运算
     * 一位16进制数对应4位二进制数，则将二进制数按4位一组转换为16进制即可
     */
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 7; i >= 0; i--) {
            int val = num >>> (i*4) & 0xf;
            // 首位0跳过
            if (sb.length() > 0 || val > 0) {
                char digit = val < 10 ? (char) ('0' + val) : (char) ('a' + val - 10);
                sb.append(digit);
            }

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ToHex_405 target = new ToHex_405();
        int num = 26;
        String result = target.toHex(num);
        System.out.println(result);
    }
}
