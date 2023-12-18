package arithmetic.easy;

/**
 * @Projectname: leetcode
 * @Filename: AddStrings_415_TODO
 * @Author: LWQ
 * @Data: 2023/12/16 10:31
 * @Description: easy
 */

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 *
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 示例 2：
 *
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * 示例 3：
 *
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 *
 *
 *
 *
 * 提示：
 *
 * 1 <= num1.length, num2.length <= 104
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 */
public class AddStrings_415 {

    /**
     * 通过：
     * 时间详情：1ms，击败 100.00%使用 Java 的用户
     * 内存详情：40.73MB，击败 36.14%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/12/17 14:48
     * @Param [num1, num2]
     * @return java.lang.String
     * @Description: 遍历，逐个相加（同66、67）
     */
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int sum = 0;
        int l1 = num1.length();
        int l2 = num2.length();
        for (int i = l1-1, j = l2-1; i>=0 || j>=0; i--,j--) {
            sum += i>=0 ? num1.charAt(i) - '0' : 0;
            sum += j>=0 ? num2.charAt(j) - '0' : 0;
            result.append(sum % 10);
            sum /= 10;
        }
        // 最高位 进1
        if (sum > 0) {
            result.append("1");
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        AddStrings_415 target = new AddStrings_415();
        String num1 = "11", num2 = "123";
        String result = target.addStrings(num1, num2);
        System.out.println(result);
    }
}
