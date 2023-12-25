package tag.bit.bit_operation;

/**
 * @Projectname: leetcode
 * @Filename: ConvertToBase7_504_TODO
 * @Author: LWQ
 * @Data: 2023/12/24 12:17
 * @Description: easy
 */

/**
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 *
 *
 *
 * 示例 1:
 *
 * 输入: num = 100
 * 输出: "202"
 * 示例 2:
 *
 * 输入: num = -7
 * 输出: "-10"
 *
 *
 * 提示：
 *
 * -107 <= num <= 107
 */
public class ConvertToBase7_504 {

    /**
     * 通过：
     * 时间详情：238ms，击败 6.85%使用 Java 的用户
     * 内存详情：39.90MB，击败 5.23%使用 Java 的用户
     *
     * @param num
     * @return
     * @desception：递归，每次减7
     */
    public String convertToBase7(int num) {
        int flag = 1;
        if (num < 0) {
            flag = -1;
            num = -num;
        }

        int data = 0;
        while (num > 0) {
            if (num >= 7) {
                data = deep(data/10 + 1);
            } else {
                data += num;
            }
            num -= 7;
        }

        return Integer.toString(data * flag);
    }

    public int deep(int data) {
        if (data % 10 >= 7) {
            data = deep(data/10 + 1);
        }
        data *= 10;
        return data;
    }

    public static void main(String[] args) {
        ConvertToBase7_504 target = new ConvertToBase7_504();
        int num = 100;
        String result = target.convertToBase7(num);
        System.out.println(result);
    }

    /**
     * @param num
     * @return
     * @desceptionn：倒推 + 迭代
     * 通用的进制转换方式进行模拟
     */
    public String convertToBase72(int num) {
        if (num == 0) {
            return "0";
        }
        boolean negative = num < 0;
        num = Math.abs(num);
        StringBuffer digits = new StringBuffer();
        while (num > 0) {
            digits.append(num % 7);
            num /= 7;
        }
        if (negative) {
            digits.append('-');
        }
        return digits.reverse().toString();
    }
}
