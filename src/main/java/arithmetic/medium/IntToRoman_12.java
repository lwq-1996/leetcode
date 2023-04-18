package arithmetic.medium;

import java.util.*;

/**
 * 罗马数字包含以下七种字符：I，V，X，L，C，D和M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 *
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给你一个整数，将其转为罗马数字。
 *
 * 
 *
 * 示例1:
 *
 * 输入:num = 3
 * 输出: "III"
 * 示例2:
 *
 * 输入:num = 4
 * 输出: "IV"
 * 示例3:
 *
 * 输入:num = 9
 * 输出: "IX"
 * 示例4:
 *
 * 输入:num = 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例5:
 *
 * 输入:num = 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * 
 *
 * 提示：
 *
 * 1 <= num <= 3999
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntToRoman_12 {

    /**
     * 特殊案例：40 : XL
     *         41 : XLI
     *         58 : LVIII
     *         1994 : MCMXCIV
     */

    /**
     * 执行用时：10 ms, 在所有 Java 提交中击败了7.51%的用户
     * 内存消耗：41.6 MB, 在所有 Java 提交中击败了18.11%的用户
     * 通过测试用例：3999 / 3999
     * @param num
     * @return
     */
    public String intToRomanv(int num) {
        Map<String, Map<Integer, Integer>> map = new LinkedHashMap<>();
        map.put("M", new HashMap<Integer, Integer>() {{put(1000, 400);}});
        map.put("D", new HashMap<Integer, Integer>() {{put(500, 400);}});
        map.put("C", new HashMap<Integer, Integer>() {{put(100, 40);}});
        map.put("L", new HashMap<Integer, Integer>() {{put(50, 40);}});
        map.put("X", new HashMap<Integer, Integer>() {{put(10, 4);}});
        map.put("V", new HashMap<Integer, Integer>() {{put(5, 4);}});
        map.put("I", new HashMap<Integer, Integer>() {{put(1, 0);}});

        Map<String, Integer> compareMap = new LinkedHashMap<>();
        compareMap.put("CM", 900);
        compareMap.put("CD", 400);
        compareMap.put("XC", 90);
        compareMap.put("XL", 40);
        compareMap.put("IX", 9);
        compareMap.put("IV", 4);

        StringBuilder stringBuilder = new StringBuilder();
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            // 罗马数字
            String roman = iterator.next();
            Map<Integer, Integer> integerIntegerMap = map.get(roman);
            Integer threshold = (Integer) integerIntegerMap.keySet().toArray()[0];
            Integer special = integerIntegerMap.get(threshold);

            int count = num/threshold;
            int remainder = num%threshold;

            if (count > 0) {
                for (int i = 0; i < count; i++) {
                    stringBuilder.append(roman);
                }
                num = remainder;
            }

            if ((num >= threshold*0.9 || threshold == 5 || threshold == 50 || threshold == 500) && remainder >= special) {
                Iterator<String> iterator1 = compareMap.keySet().iterator();
                while (iterator1.hasNext()) {
                    String next = iterator1.next();
                    Integer integer = compareMap.get(next);
                    if (remainder >= integer) {
                        stringBuilder.append(next);
                        num = remainder - integer;
                        break;
                    }
                }
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        IntToRoman_12 intToRoman_12 = new IntToRoman_12();
        int num = 1994;
        String result = intToRoman_12.intToRomanv(num);
        System.out.println(result);
    }
}
