package tag.string.numbers_strings_convert;

/**
 * @Projectname: leetcode
 * @Filename: IntToRoman_12
 * @Author: LWQ
 * @Data: 2023/12/4 23:05
 * @Description: medium
 */

import java.util.*;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 *
 *
 *
 * 示例 1:
 *
 * 输入: num = 3
 * 输出: "III"
 * 示例 2:
 *
 * 输入: num = 4
 * 输出: "IV"
 * 示例 3:
 *
 * 输入: num = 9
 * 输出: "IX"
 * 示例 4:
 *
 * 输入: num = 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 *
 * 输入: num = 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 *
 * 提示：
 *
 * 1 <= num <= 3999
 */
public class IntToRoman_12 {

    /**
     * 通过：
     * 时间详情：8ms，击败 9.54%使用 Java 的用户
     * 内存详情：42.48MB，击败 18.21%使用 Java 的用户
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        // TreeMap 有序性
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        StringBuilder stringBuilder = new StringBuilder();

        while (!map.isEmpty() && num > 0) {
            Map.Entry<Integer, String> next = map.pollLastEntry();
            Integer key = next.getKey();
            String value = next.getValue();
            if (num/key > 0) {
                int count = num/key;
                for (int i = 0; i < count; i++) {
                    stringBuilder.append(value);
                }
                num %= key;
            }
        }

        return stringBuilder.toString();
    }

    /**
     * 通过：
     * 时间详情：3ms，击败 98.25%使用 Java 的用户
     * 内存详情：41.74MB，击败 92.54%使用 Java 的用户
     *
     * @param num
     * @return
     * @desection：避免 多次访问 map，导致性能下降
     */
    public String intToRoman2(int num) {
        int[] chr_num = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] cha_roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 13; i++) {
            int div = chr_num[i];
            if (num/div > 0) {
                int count = num/div;
                for (int j = 0; j < count; j++) {
                    stringBuilder.append(cha_roman[i]);
                }
                num %= div;
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        IntToRoman_12 target = new IntToRoman_12();
        int num = 3;
        String result = target.intToRoman(num);
        System.out.println(result);
    }
}
