package arithmetic.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Projectname: leetcode
 * @Filename: SummaryRanges_228
 * @Author: LWQ
 * @Data:2022/11/21 20:43
 * @Description: leetcode_practice
 * 
 * 
 * 给定一个 无重复元素 的有序 整数数组 nums 。
 *
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 *
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *
 * 示例 1：
 *
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 示例 2：
 *
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 *
 * 提示：
 *
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * nums 中的所有值都 互不相同
 * nums 按升序排列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/summary-ranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class SummaryRanges_228 {

    /**
     * 执行用时：9 ms, 在所有 Java 提交中击败了13.70%的用户
     * 内存消耗：40.2 MB, 在所有 Java 提交中击败了5.09%的用户
     * 通过测试用例：29 / 29
     *
     * 使用StringBuild能缩减大量时间
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> summaryRanges = new ArrayList<>();
        if (nums.length == 0) {
            return summaryRanges;
        }
        if (nums.length == 1) {
            summaryRanges.add(String.valueOf(nums[0]));
            return summaryRanges;
        }

        String range = "->";
        int star = nums[0];
        int last;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] == 1 && i < nums.length-1) {
                continue;
            }

            last = i == nums.length-1 && nums[i] - nums[i-1] == 1 ? nums[i] : nums[i-1];
            if (star == last) {
                summaryRanges.add(String.valueOf(star));
            } else {
                summaryRanges.add(star + range + last);
            }
            star = nums[i];

            if (i == nums.length-1 && nums[i] - nums[i-1] != 1) {
                summaryRanges.add(String.valueOf(star));
            }
        }

        return summaryRanges;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.6 MB, 在所有 Java 提交中击败了61.45%的用户
     * 通过测试用例：29 / 29
     * @param nums
     * @return
     */
    public List<String> summaryRanges2(int[] nums) {
        List<String> summaryRanges = new ArrayList<>();
        if (nums.length == 0) {
            return summaryRanges;
        }
        if (nums.length == 1) {
            summaryRanges.add(String.valueOf(nums[0]));
            return summaryRanges;
        }

        StringBuilder stringBuilder = new StringBuilder();
        String range = "->";
        int star = nums[0];
        int last = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] == 1) {
                continue;
            }

            last = nums[i-1];
            if (star == last) {
                summaryRanges.add(stringBuilder.append(star).toString());
            } else {
                summaryRanges.add(stringBuilder.append(star).append(range).append(last).toString());
            }
            stringBuilder = new StringBuilder();
            star = nums[i];
        }

        stringBuilder = new StringBuilder();
        if (star == nums[nums.length-1]) {
            summaryRanges.add(stringBuilder.append(star).toString());
        } else if (last != nums[nums.length-1]) {
            summaryRanges.add(stringBuilder.append(star).append(range).append(nums[nums.length-1]).toString());
        }

        return summaryRanges;
    }

    public static void main(String[] args) {
        SummaryRanges_228 summaryRanges_228 = new SummaryRanges_228();
        int[] nums = {0,1,2,4,5,7};
        int[] nums2 = {0,2,3,4,6,8,9};
        List<String> summaryRanges = summaryRanges_228.summaryRanges2(nums2);
        System.out.println(summaryRanges);
    }
}
