package arithmetic.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Projectname: leetcode
 * @Filename: ContainsNearbyDuplicate_219
 * @Author: LWQ
 * @Data:2022/11/21 19:27
 * @Description: leetcode_practice
 * 
 * 
 * 给你一个整数数组nums 和一个整数k ，判断数组中是否存在两个 不同的索引i和j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 *
 *
 * 示例1：
 *
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * 示例 2：
 *
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 * 示例 3：
 *
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 * 
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 0 <= k <= 105
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class ContainsNearbyDuplicate_219 {

    /**
     * 执行用时：11 ms, 在所有 Java 提交中击败了99.98%的用户
     * 内存消耗：51.3 MB, 在所有 Java 提交中击败了34.22%的用户
     * 通过测试用例：54 / 54
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>((int)(nums.length/0.75+1));
        for (int i = 0; i < nums.length; i++) {
            // 若 key 已存在，则返回旧的 value
            Integer oldIndex = map.put(nums[i], i);
            if (oldIndex == null) {
                continue;
            }

            if (Math.abs(i - oldIndex) <= k) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsNearbyDuplicate_219 containsNearbyDuplicate_219 = new ContainsNearbyDuplicate_219();
        int[] nums = {1,2,3,1,1,1,2,2,2};
        int k = 3;
        boolean result = containsNearbyDuplicate_219.containsNearbyDuplicate(nums, k);
        System.out.println(result);
    }
}
