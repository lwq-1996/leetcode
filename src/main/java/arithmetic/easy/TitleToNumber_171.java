package arithmetic.easy;

/**
 * @Projectname: leetcode
 * @Filename: TitleToNumber_171
 * @Author: LWQ
 * @Data:2022/11/15 19:43
 * @Description: leetcode_practice
 * 
 * 
 * 给你一个字符串columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号。
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
 * 示例2:
 *
 * 输入: columnTitle = "AB"
 * 输出: 28
 * 示例3:
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
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/excel-sheet-column-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class TitleToNumber_171 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：41 MB, 在所有 Java 提交中击败了10.58%的用户
     * 通过测试用例：1002 / 1002
     * @param columnTitle
     * @return
     */
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            result = result * 26 + columnTitle.charAt(i) - 64;
        }

        return result;
    }

    public static void main(String[] args) {
        TitleToNumber_171 titleToNumber_171 = new TitleToNumber_171();
        String columnTitle = "AB";
        int titleToNumber = titleToNumber_171.titleToNumber(columnTitle);
        System.out.println(titleToNumber);
    }
}
