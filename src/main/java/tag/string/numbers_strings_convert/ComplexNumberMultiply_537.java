package tag.string.numbers_strings_convert;

/**
 * @Projectname: leetcode
 * @Filename: ComplexNumberMultiply_537
 * @Author: LWQ
 * @Data: 2023/12/4 22:49
 * @Description: medium
 */

/**
 * 复数 可以用字符串表示，遵循 "实部+虚部i" 的形式，并满足下述条件：
 *
 * 实部 是一个整数，取值范围是 [-100, 100]
 * 虚部 也是一个整数，取值范围是 [-100, 100]
 * i2 == -1
 * 给你两个字符串表示的复数 num1 和 num2 ，请你遵循复数表示形式，返回表示它们乘积的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num1 = "1+1i", num2 = "1+1i"
 * 输出："0+2i"
 * 解释：(1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
 * 示例 2：
 *
 * 输入：num1 = "1+-1i", num2 = "1+-1i"
 * 输出："0+-2i"
 * 解释：(1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。
 *
 *
 * 提示：
 *
 * num1 和 num2 都是有效的复数表示。
 */
public class ComplexNumberMultiply_537 {

    /**
     * 通过：
     * 时间详情：1ms，击败 92.00%使用 Java 的用户
     * 内存详情：39.73MB，击败 41.20%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/12/7 12:37
     * @Param [num1, num2]
     * @return java.lang.String
     * @Description: 数学 - 乘法分配率
     */
    public String complexNumberMultiply(String num1, String num2) {
        String[] split_1 = num1.split("\\+");
        String[] split_2 = num2.split("\\+");
        int real_1 = Integer.valueOf(split_1[0]), vir_1 = Integer.valueOf(split_1[1].substring(0, split_1[1].length()-1));
        int real_2 = Integer.valueOf(split_2[0]), vir_2 = Integer.valueOf(split_2[1].substring(0, split_2[1].length()-1));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(real_1*real_2 - vir_1*vir_2).append("+").append(real_1*vir_2 + real_2*vir_1).append("i");

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ComplexNumberMultiply_537 target = new ComplexNumberMultiply_537();
        String num1 = "1+1i", num2 = "1+1i";
        num1 = "1+-1i"; num2="0+0i";
        String result = target.complexNumberMultiply2(num1, num2);
        System.out.println(result);
    }

    /**
     * @Author LWQ
     * @Date 2023/12/7 12:39
     * @Param [num1, num2]
     * @return java.lang.String
     * @Description: 正则优化
     */
    public String complexNumberMultiply2(String num1, String num2) {
        String[] complex1 = num1.split("\\+|i");
        String[] complex2 = num2.split("\\+|i");
        int real1 = Integer.parseInt(complex1[0]);
        int imag1 = Integer.parseInt(complex1[1]);
        int real2 = Integer.parseInt(complex2[0]);
        int imag2 = Integer.parseInt(complex2[1]);
        return String.format("%d+%di", real1 * real2 - imag1 * imag2, real1 * imag2 + imag1 * real2);
    }
}
