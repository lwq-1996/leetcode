package arithmetic.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Projectname: leetcode
 * @Filename: ThreeSum_15
 * @Author: LWQ
 * @Data:2022/10/22 14:05
 * @Description: leetcode_practice
 *
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 *
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 *
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class ThreeSum_15 {

    /**
     * 执行用时：19 ms, 在所有 Java 提交中击败了91.52%的用户
     * 内存消耗：45.5 MB, 在所有 Java 提交中击败了56.12%的用户
     * 通过测试用例：311 / 311
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);
        int star = 0;
        int end = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            star = i + 1;
            end = nums.length - 1;
            // 排序过，起始位置大于0，则后面不会有小于0的数，也就不会有值能相加等于0；末尾位置反之亦然
            if (nums[i] > 0) {
                return result;
            }
            while (star < end) {
                // end小于0，不会有三数之和等于0的情况
                if (nums[end] < 0) {
                    break;
                }

                if ((nums[i] + nums[star] + nums[end]) == 0) {
                    List<Integer> pram = new ArrayList<>();
                    pram.add(nums[i]);
                    pram.add(nums[star]);
                    pram.add(nums[end]);
                    result.add(pram);
                    while (star < end && nums[star] == nums[star + 1]) {
                        ++star;
                    }
                    while (star < end && nums[end] == nums[end - 1]) {
                        --end;
                    }
                    --end;
                }else if ((nums[i] + nums[star] + nums[end]) < 0) {
                    ++star;
                } else {
                    --end;
                }
            }
        }

        return result;
    }

    /**
     * 超时
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);
        int star = 0;
        int end = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 排序过，起始位置大于0，则后面不会有小于0的数，也就不会有值能相加等于0；末尾位置反之亦然
            if (nums[i] > 0 || nums[end] < 0) {
                return result;
            }
            star = i + 1;
            while (star < end) {
                // 🔚end小于0，不会有三数之和等于0的情况
                if (nums[end] < 0) {
                    break;
                }

                while (star < end) {
                    if ((nums[i] + nums[star] + nums[end]) == 0) {
                        List<Integer> pram = new ArrayList<>();
                        pram.add(nums[i]);
                        pram.add(nums[star]);
                        pram.add(nums[end]);
                        result.add(pram);
                    }

                    while (star < end) {
                        if (nums[end] == nums[--end]) {
                            continue;
                        }
                        break;
                    }
                }
                end = nums.length - 1;
                while (star < end) {
                    if (nums[star] == nums[++star]) {
                        continue;
                    }
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSum_15 threeSum_15 = new ThreeSum_15();
        int[] nums = {-1,0,1,2,-1,-4};
        int[] nums2 = {0, 0, 0, 0};
        int[] nums3 = {-1, 0, 1, 0};
        int[] nums4 = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        List<List<Integer>> lists = threeSum_15.threeSum2(nums);
        Iterator<List<Integer>> iterator = lists.iterator();
        while (iterator.hasNext()) {
            List<Integer> integers = iterator.next();
            System.out.println(integers);
        }
    }
}
