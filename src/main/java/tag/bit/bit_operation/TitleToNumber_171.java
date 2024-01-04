package tag.bit.bit_operation;

/**
 * @Projectname: leetcode
 * @Filename: TitleToNumber_171_TODO
 * @Author: LWQ
 * @Data: 2023/12/24 12:57
 * @Description: easy
 */

/**
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
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
 * 示例 1:
 *
 * 输入: columnTitle = "A"
 * 输出: 1
 * 示例 2:
 *
 * 输入: columnTitle = "AB"
 * 输出: 28
 * 示例 3:
 *
 * 输入: columnTitle = "ZY"
 * 输出: 701
 *
 *
 * 提示：
 *
 * 1 <= columnTitle.length <= 7
 * columnTitle 仅由大写英文组成
 * columnTitle 在范围 ["A", "FXSHRXW"] 内
 */
public class TitleToNumber_171 {

    /**
     * 通过：
     * 执行用时分布：1ms，击败52.71%使用 Java 的用户
     * 消耗内存分布：41.29MB，击败5.72%使用 Java 的用户
     *
     * @param columnTitle
     * @return
     * @desception：遍历模拟
     */
    public int titleToNumber(String columnTitle) {
        int result = 0;
        char[] chars = columnTitle.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            result += (chars[i] - 'A' + 1) * Math.pow(26, (len - i - 1));
        }
        return result;
    }

    public static void main(String[] args) {
        TitleToNumber_171 target = new TitleToNumber_171();
        String columTitle = "AB";
        int result = target.titleToNumber(columTitle);
        System.out.println(result);
    }

    /**
     * @param columnTitle
     * @return
     * @desception：维护每次需要计算的当前位数，省去了每次计算幂
     */
    public int titleToNumber2(String columnTitle) {
        int number = 0;
        int multiple = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int k = columnTitle.charAt(i) - 'A' + 1;
            number += k * multiple;
            multiple *= 26;
        }
        return number;
    }
}
