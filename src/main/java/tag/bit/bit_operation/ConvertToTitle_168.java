package tag.bit.bit_operation;

/**
 * @Projectname: leetcode
 * @Filename: ConvertToTitle_168_TODO
 * @Author: LWQ
 * @Data: 2023/12/24 12:59
 * @Description: easy
 */

/**
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 *
 * 例如：
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *
 *
 * 示例 1：
 *
 * 输入：columnNumber = 1
 * 输出："A"
 * 示例 2：
 *
 * 输入：columnNumber = 28
 * 输出："AB"
 * 示例 3：
 *
 * 输入：columnNumber = 701
 * 输出："ZY"
 * 示例 4：
 *
 * 输入：columnNumber = 2147483647
 * 输出："FXSHRXW"
 *
 *
 * 提示：
 *
 * 1 <= columnNumber <= 231 - 1
 */
public class ConvertToTitle_168 {

    /**
     * 通过：
     * 执行用时分布：0ms，击败100.00%使用 Java 的用户
     * 消耗内存分布：39.70MB，击败6.95%使用 Java 的用户
     *
     * @param columnNumber
     * @return
     */
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            // 余数为0时为Z
            int remainder = columnNumber % 26;
            int digit = remainder == 0 ? 25 : remainder -1;
            sb.append((char) ('A' + digit));
            columnNumber /= 26;
            // 达能前Z时多减1
            if (remainder == 0) {
                columnNumber -= 1;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        ConvertToTitle_168 target = new ConvertToTitle_168();
        int columnNumber = 701;
        String result = target.convertToTitle(columnNumber);
        System.out.println(result);
    }

    /**
     * @param columnNumber
     * @return
     * @desception：数学
     * 在这个问题中，我们将十进制数转换为26进制数，但是这里的26进制数是由字符'A'到'Z'表示的，
     * 而不是由数字0到25表示的。所以，我们需要将输入的数减一，以便将0到25映射到'A'到'Z'。
     */
    public String convertToTitle2(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while (columnNumber != 0) {
            columnNumber--;
            sb.append((char)(columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
