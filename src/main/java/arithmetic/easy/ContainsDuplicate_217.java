package arithmetic.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @Projectname: leetcode
 * @Filename: ContainsDuplicate_217
 * @Author: LWQ
 * @Data:2022/11/21 19:23
 * @Description: leetcode_practice
 * 
 * 
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1]
 * 输出：true
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 示例3：
 *
 * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
 * 输出：true
 * 
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/contains-duplicate
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class ContainsDuplicate_217 {

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了99.29%的用户
     * 内存消耗：52.3 MB, 在所有 Java 提交中击败了72.79%的用户
     * 通过测试用例：70 / 70
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>((int)(nums.length/0.75+1));
        for (int i = 0; i < nums.length; i++) {
            boolean addflag = set.add(nums[i]);
            if (!addflag) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate_217 containsDuplicate_217 = new ContainsDuplicate_217();
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        boolean result = containsDuplicate_217.containsDuplicate(nums);
        System.out.println(result);
    }
}
