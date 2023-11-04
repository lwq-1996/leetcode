package arithmetic.easy;

/**
 * @Projectname: leetcode
 * @Filename: ThirdMax_414
 * @Author: LWQ
 * @Data: 2023/8/16 22:33
 * @Description: easy
 */

import java.util.TreeSet;

/**
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 * 示例 2：
 *
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 * 示例 3：
 *
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 *
 * 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？
 */
public class ThirdMax_414 {

    /**
     * 通过
     * 时间详情: -ms, 击败 100.00%使用 Java 的用户
     * 内存详情: 40.76mb, 击败 78.42%使用 Java 的用户
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }

        // 使用 Long.MIN_VALUE，数组中可存在 Integer.MIN_VALUE 项
        long max1 = Long.MIN_VALUE, max2 = Long.MIN_VALUE, max3 = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }else if (nums[i] > max2 && nums[i] < max1) {
                max3 = max2;
                max2 = nums[i];
            }else if (nums[i] > max3 && nums[i] < max2) {
                max3 = nums[i];
            }
        }

        return (int)(max3 == Long.MIN_VALUE ? max1 : max3);
    }


    /**
     * 通过
     * 时间详情: 3ms, 击败 47.42%使用 Java 的用户
     * 内存详情: 41.17mb, 击败 35.35%使用 Java 的用户
     *
     * @param nums
     * @return
     * @Description: 使用有序不重复集合treeSet，维护数组中前三大的数
     */
    public int thirdMax02(int[] nums) {
        // 有序集合 数字升序
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            treeSet.add(nums[i]);
            if (treeSet.size() > 3) {
                treeSet.pollFirst();
            }
        }

        return treeSet.size() == 3 ? treeSet.first() : treeSet.last();
    }

    public static void main(String[] args) {
        ThirdMax_414 target = new ThirdMax_414();
        int[] nums = {1,2,3};
        int result = target.thirdMax02(nums);
        System.out.println(result);
    }
}
