package arithmetic.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Projectname: leetcode
 * @Filename: GetRow_119
 * @Author: LWQ
 * @Data:2023/5/25 14:16
 * @Description: leetcode_practice
 * 
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 *
 *
 * 
 *
 * 示例 1:
 *
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 * 示例 2:
 *
 * 输入: rowIndex = 0
 * 输出: [1]
 * 示例 3:
 *
 * 输入: rowIndex = 1
 * 输出: [1,1]
 * 
 *
 * 提示:
 *
 * 0 <= rowIndex <= 33
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/pascals-triangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class GetRow_119 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了78.27%的用户
     * 内存消耗：39.1 MB, 在所有 Java 提交中击败了77.16%的用户
     * 通过测试用例：34 / 34
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        List<Integer> upcurrent = new ArrayList<>(rowIndex + 1);

        for (int i = 0; i <= rowIndex; i++) {
            if (i == 0) {
                result.add(new Integer(1));
                upcurrent.clear();
                upcurrent.addAll(result);
                continue;
            }

            result.clear();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    result.add(new Integer(1));
                    continue;
                }
                result.add(upcurrent.get(j) + upcurrent.get( j - 1));
            }
            upcurrent.clear();
            upcurrent.addAll(result);
        }
        return result;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了78.27%的用户
     * 内存消耗：39.2 MB, 在所有 Java 提交中击败了63.63%的用户
     * 通过测试用例：34 / 34
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow2(int rowIndex) {
        Integer[] result = new Integer[rowIndex + 1];
        int current = 0;
        int left = 0;
        for (int i = 0; i <= rowIndex; i++) {
            if (i == 0) {
                result[0] = 1;
                current = 1;
                continue;
            }

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    continue;
                }
                left = result[j];
                result[j] = (current + result[j]);
                current = left;
            }
            result[i] = 1;
        }
        return Arrays.asList(result);
    }

    public static void main(String[] args) {
        GetRow_119 getRow_119 = new GetRow_119();
        int rowIndex = 4;
        List<Integer> row = getRow_119.getRow2(rowIndex);
        System.out.println(row);
    }
}
