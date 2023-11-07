package tag.array.twodimensional_and_roll;

/**
 * @Projectname: leetcode
 * @Filename: GetRow_119
 * @Author: LWQ
 * @Data: 2023/8/18 21:43
 * @Description: easy
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
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
 */
public class GetRow_119 {

    /**
     * 通过
     * 时间详情：1ms，击败 82.95%使用 Java 的用户
     * 内存详情：38.16MB，击败 55.12%使用 Java 的用户
     * @param rowIndex
     * @return
     * @description：rowIndex从0开始
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> init = new ArrayList<>();
        init.add(1);
        if (rowIndex == 0) {
            return init;
        }

        List<Integer> result = init;
        for (int i = 0; i < rowIndex; i++) {
            List<Integer> last = new ArrayList<>();
            last.add(1);
            for (int j = 1; j < result.size(); j++) {
                last.add(result.get(j-1) + result.get(j));
            }
            last.add(1);
            result = last;
        }

        return result;
    }

    public static void main(String[] args) {
        GetRow_119 target = new GetRow_119();
        int rowIndex = 1;
        List<Integer> result = target.getRow(rowIndex);
        System.out.println(result);
    }
}
