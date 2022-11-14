package arithmetic.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Projectname: leetcode
 * @Filename: Generate_118
 * @Author: LWQ
 * @Data:2022/11/14 11:11
 * @Description: leetcode_practice
 *
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行
 *
 *
 * 示例 1:
 *
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例2:
 *
 * 输入: numRows = 1
 * 输出: [[1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Generate_118 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.1 MB, 在所有 Java 提交中击败了71.23%的用户
     * 通过测试用例：14 / 14
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> psrsm = new ArrayList<>(i);
            if (i == 0) {
                psrsm.add(new Integer(1));
                result.add(psrsm);
                continue;
            }

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    psrsm.add(new Integer(1));
                    continue;
                }
                psrsm.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
            }
            result.add(psrsm);
        }

        return result;
    }

    public static void main(String[] args) {
        Generate_118 generate_118 = new Generate_118();
        List<List<Integer>> generate = generate_118.generate(5);
        for (List<Integer> list : generate) {
            System.out.println(list);
        }
    }
}
