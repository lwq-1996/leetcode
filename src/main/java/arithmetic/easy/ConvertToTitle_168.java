package arithmetic.easy;

/**
 * @Projectname: leetcode
 * @Filename: ConvertToTitle_168
 * @Author: LWQ
 * @Data:2022/11/15 10:22
 * @Description: leetcode_practice
 * 
 * 
 * 给你一个整数columnNumber ，返回它在 Excel 表中相对应的列名称。
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
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/excel-sheet-column-title
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class ConvertToTitle_168 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了53.66%的用户
     * 通过测试用例：18 / 18
     * @param columnNumber
     * @return
     */
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        int current = 0;
        int temp = 0;
        while (columnNumber > 26) {
            temp = columnNumber % 26;
            columnNumber = columnNumber / 26;
            if (temp == 0) {
                // 当余数为0时，未最后一位'z'，同时除26后会多1，需要减掉
                current = temp + 90;
                columnNumber--;
            } else {
                current = temp + 64;
            }
            result.append((char)current);
        }

        result.append((char)(columnNumber + 64));

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        ConvertToTitle_168 convertToTitle_168 = new ConvertToTitle_168();
        int columnNumber = 35179;
        String toTitle = convertToTitle_168.convertToTitle(columnNumber);
        System.out.println(toTitle);
    }
}
