package tag.hash;

/**
 * @Projectname: leetcode
 * @Filename: FractionToDecimal_166
 * @Author: LWQ
 * @Data: 2024/8/18 10:04
 * @Description: medium
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
 *
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 *
 * 如果存在多个答案，只需返回 任意一个 。
 *
 * 对于所有给定的输入，保证 答案字符串的长度小于 104 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：numerator = 1, denominator = 2
 * 输出："0.5"
 * 示例 2：
 *
 * 输入：numerator = 2, denominator = 1
 * 输出："2"
 * 示例 3：
 *
 * 输入：numerator = 4, denominator = 333
 * 输出："0.(012)"
 *
 *
 * 提示：
 *
 * -231 <= numerator, denominator <= 231 - 1
 * denominator != 0
 */
public class FractionToDecimal_166 {

    /**
     * 执行用时分布: 1ms,击败99.28%
     * 消耗内存分布: 40.19MB,击败27.10%
     * @Description: 模拟竖版除法
     */
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        if (denominator == 1) {
            return String.valueOf(numerator);
        }
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // 结果位数记位
        int cur = 0;
        // 结果
        StringBuilder sb = new StringBuilder();

        // 是否已经拼接过小数点 '.'
        boolean flag = false;
        // 每次计算后的余数
        long remainder = -1;
        // 出现过的被除数 与 结果中的索引 映射
        Map<Long, Integer> map = new HashMap<>();

        // 初始补充的小数点前需要加0， '0.'
        if (num < den) {
            sb.append("0.");
            num *= 10;
            cur = 2;
            flag = true;
        }

        while (remainder != 0){
            if (flag) {
                map.put(num, cur);
            }
            // 被除数不够，补0
            if (num < den) {
                sb.append("0");
                cur++;
                num *= 10;
                continue;
            }
            long tmp = num/den;
            sb.append(tmp);
            // 结果添加几位
            while (tmp > 0) {
                tmp = tmp / 10;
                cur++;
            }
            remainder = num % den;
            // 被除数第一次不够补小数点
            if (!flag && remainder != 0 && remainder < den) {
                sb.append(".");
                flag = true;
                cur++;
            }
            // 当前被除数，余数*10
            num = remainder * 10;

            // 进入循环
            if (map.get(num) != null) {
                break;
            }
        }

        if (remainder != 0) {
            sb.insert(map.get(num), "(").append(")");
        }

        if ((numerator >>> 31 ^ denominator >>> 31) == 1) {
            sb.insert(0, "-");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        FractionToDecimal_166 target = new FractionToDecimal_166();
        int numerator = 2147483647;
        int denominator = 37;
        String result = target.fractionToDecimal(numerator, denominator);
        System.out.println(result);
    }
}
