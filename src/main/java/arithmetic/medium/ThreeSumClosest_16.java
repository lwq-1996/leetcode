package arithmetic.medium;

import java.util.Arrays;

/**
 * @Projectname: leetcode
 * @Filename: ThreeSumClosest_16
 * @Author: LWQ
 * @Data:2022/11/21 22:45
 * @Description: leetcode_practice
 * 
 * 
 * 给你一个长度为 n 的整数数组nums和 一个目标值target。请你从 nums 中选出三个整数，使它们的和与target最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 示例 2：
 *
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 * 
 * 提示：
 *
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class ThreeSumClosest_16 {

    /**
     * 执行用时：14 ms, 在所有 Java 提交中击败了61.33%的用户
     * 内存消耗：40.9 MB, 在所有 Java 提交中击败了83.68%的用户
     * 通过测试用例：98 / 98
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }

        Arrays.sort(nums);

        int start = 0;
        int last = nums.length - 1;
        Integer result = null;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            start = i + 1;
            last = nums.length - 1;

            /*// 排序过
            if (nums[i] >= target) {
                if (i >= 2) {
                    return nums[i] + nums[i - 1] + nums[i - 2];
                } else if (i == 1) {
                    return nums[i] + nums[i + 1] + nums[i - 1];
                } else if (i == 0) {
                    return nums[i] + nums[i + 1] + nums[i + 2];
                }
            }*/

            while (start < last) {
                int current = nums[i] + nums[start] + nums[last];
                if (result == null || Math.abs(current - target) < (Math.abs(result - target))) {
                    result = current;
                }

                if (current < target) {
                    start ++;
                } else if (current > target) {
                    last --;
                } else if (current == target) {
                    return current;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSumClosest_16 threeSumClosest_16 = new ThreeSumClosest_16();
        int[] nums = {-100,-98,-2,-1};
        int target = -101;
        int sumClosest = threeSumClosest_16.threeSumClosest(nums, target);
        System.out.println(sumClosest);
    }
}
