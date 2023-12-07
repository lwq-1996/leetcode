package tag.string.numbers_strings_convert;

/**
 * @Projectname: leetcode
 * @Filename: FractionAddition_592
 * @Author: LWQ
 * @Data: 2023/12/4 22:51
 * @Description: medium
 */

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果。
 *
 * 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。
 *
 *
 *
 * 示例 1:
 *
 * 输入: expression = "-1/2+1/2"
 * 输出: "0/1"
 *  示例 2:
 *
 * 输入: expression = "-1/2+1/2+1/3"
 * 输出: "1/3"
 * 示例 3:
 *
 * 输入: expression = "1/3-1/2"
 * 输出: "-1/6"
 *
 *
 * 提示:
 *
 * 输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。
 * 输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。
 * 输入只包含合法的最简分数，每个分数的分子与分母的范围是  [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。
 * 输入的分数个数范围是 [1,10]。
 * 最终结果的分子与分母保证是 32 位整数范围内的有效整数。
 */
public class FractionAddition_592 {

    /**
     * LeetCode 不支持 Pattern
     *
     * @Author LWQ
     * @Date 2023/12/7 22:28
     * @Param [expression]
     * @return java.lang.String
     * @Description: 拆分，得到分子分母，寻找最大公约数
     *  寻找最大公约数：
     * 辗转相除法，也称欧几里得算法，是求最大公约数的经典方法，
     * 具体步骤如下：
     * 1. 将两个数中较大的数除以较小的数，得到商和余数；
     * 2. 将较小的数和余数再次做除法，得到商和余数；
     * 3. 重复上述过程，直到余数为0，此时较小的数就是最大公约数。
     */
    public String fractionAddition(String expression) {
        List<String> list = new ArrayList<>();
        String pattern = "-?\\d+/\\d+";
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(expression);
        while (matcher.find()) {
            String group = matcher.group();
            list.add(group);
        }

        // 分子，分母
        long numerator = 0, denominator = 1;
        int size = list.size();
        int[][] arr = new int[2][size];
        for (int i = 0; i < size; i++) {
            String cur = list.get(i);
            String[] split = cur.split("/");

            Integer integer = Integer.valueOf(split[1]);
            // 所有分母相乘
            denominator *= integer;
            // 带符号分子
            arr[0][i] = Integer.valueOf(split[0]);
            arr[1][i] = integer;
        }

        for (int i = 0; i < size; i++) {
            int n = arr[0][i];
            int d = arr[1][i];
            // 计算分子之和
            numerator += n*(denominator/d);
        }

        if (numerator == 0) {
            return "0/1";
        }

        // 获取最大公约数
        long g = gcd(Math.abs(numerator), denominator);
        return Long.toString(numerator / g) + "/" + Long.toString(denominator / g);
    }

    public long gcd(long a, long b) {
        long remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }


    public static void main(String[] args) {
        FractionAddition_592 target = new FractionAddition_592();
        target.gcd(3,7);
        String expression = "-1/2+1/2-1/3";
        String result = target.fractionAddition(expression);
        System.out.println(result);
    }

    /**
     * @Author LWQ
     * @Date 2023/12/7 22:38
     * @Param [expression]
     * @return java.lang.String
     * @Description: 模拟
     * 如果 x=0，说明结果为零，直接返回 "0/1"；否则计算分子分母的最大公约数，返回约简后分数的字符串表示。
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/fraction-addition-and-subtraction/solutions/1699131/fen-shu-jia-jian-yun-suan-by-leetcode-so-2mto/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public String fractionAddition2(String expression) {
        long x = 0, y = 1; // 分子，分母
        int index = 0, n = expression.length();
        while (index < n) {
            // 读取分子
            long x1 = 0, sign = 1;
            if (expression.charAt(index) == '-' || expression.charAt(index) == '+') {
                sign = expression.charAt(index) == '-' ? -1 : 1;
                index++;
            }
            while (index < n && Character.isDigit(expression.charAt(index))) {
                x1 = x1 * 10 + expression.charAt(index) - '0';
                index++;
            }
            x1 = sign * x1;
            index++;

            // 读取分母
            long y1 = 0;
            while (index < n && Character.isDigit(expression.charAt(index))) {
                y1 = y1 * 10 + expression.charAt(index) - '0';
                index++;
            }

            x = x * y1 + x1 * y;
            y *= y1;
        }
        if (x == 0) {
            return "0/1";
        }
        long g = gcd2(Math.abs(x), y); // 获取最大公约数
        return Long.toString(x / g) + "/" + Long.toString(y / g);
    }

    public long gcd2(long a, long b) {
        long remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }
}
