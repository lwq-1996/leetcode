package tag.array.twodimensional_and_roll;

/**
 * @Projectname: leetcode
 * @Filename: Generate_118
 * @Author: LWQ
 * @Data: 2023/8/18 21:40
 * @Description: easy
 */

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 *
 *
 *
 *
 * 示例 1:
 *
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例 2:
 *
 * 输入: numRows = 1
 * 输出: [[1]]
 *
 *
 * 提示:
 *
 * 1 <= numRows <= 30
 */
public class Generate_118 {

    /**
     * 通过
     * 时间详情：1ms，击败 96.26%使用 Java 的用户
     * 内存详情：38.84MB，击败 74.69%使用 Java 的用户
     * @param numRows
     * @return
     * @description: 首位一定是1
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> param = new ArrayList<>();
        param.add(1);
        result.add(param);
        if (numRows == 1) {
            return result;
        }

        List<Integer> before = param;
        for (int i = 1; i < numRows; i++) {
            List<Integer> current = new ArrayList<>();
            current.add(1);
            for (int j = 1; j < before.size(); j++) {
                current.add(before.get(j-1) + before.get(j));
            }
            current.add(1);
            result.add(current);
            before = current;
        }
        return result;
    }

    public static void main(String[] args) {
        Generate_118 target = new Generate_118();
        List<List<Integer>> result = target.generate(6);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
