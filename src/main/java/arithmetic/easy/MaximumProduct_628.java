package arithmetic.easy;

/**
 * @Projectname: leetcode
 * @Filename: MaximumProduct_628
 * @Author: LWQ
 * @Data: 2023/8/16 22:36
 * @Description: easy
 */

import java.util.Arrays;

/**
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：6
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：24
 * 示例 3：
 *
 * 输入：nums = [-1,-2,-3]
 * 输出：-6
 *
 *
 * 提示：
 *
 * 3 <= nums.length <= 104
 * -1000 <= nums[i] <= 1000
 */
public class MaximumProduct_628 {

    /**
     * 通过
     * 时间详情: 14ms, 击败 8.21%使用 Java 的用户
     * 内存详情: 42.12mb, 击败 89.29%使用 Java 的用户
     *
     * @param nums
     * @return
     * @Description: 排序需要 O(NlogN)的时间复杂度
     */
    public int maximumProduct(int[] nums) {
        int length = nums.length;
        if (length == 3) {
            return nums[0] * nums[1] * nums[2];
        }

        Arrays.sort(nums);

        int var0 = nums[0] * nums[1] * nums[length-1];
        int var1 = nums[length-1] * nums[length-2] * nums[length-3];

        return var0 > var1 ? var0 : var1;
    }

    /**
     *
     * @param nums
     * @return
     */
    public int maximumProduct02(int[] nums) {
        int length = nums.length;
        if (length == 3) {
            return nums[0] * nums[1] * nums[2];
        }

        Arrays.sort(nums);

        return Math.max(nums[length-1] * nums[length-2] * nums[length-3], nums[0] * nums[1] * nums[length-1]);
    }

    /**
     * 通过
     * 时间详情: 2ms, 击败 98.79%使用 Java 的用户
     * 内存详情: 42.08mb, 击败 92.79%使用 Java 的用户
     *
     * @param nums
     * @return
     * @Description 不排序，找出数组中最大的三个数、最小的两个数
     */
    public int maximumProduct03(int[] nums) {
        int length = nums.length;
        if (length == 3) {
            return nums[0] * nums[1] * nums[2];
        }

        // max1最大，min1最小
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        /**
         *  “=” 处理数组中含有相同元素的场景
         */
        for (int i = 0; i < length; i++) {
            if (nums[i] >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }
            if (nums[i] <= min1) {
                min2 = min1;
                min1 = nums[i];
            }

            if (nums[i] >= max2 && nums[i] < max1) {
                max3 = max2;
                max2 = nums[i];
            }
            if (nums[i] <= min2 && nums[i] > min1) {
                min2 = nums[i];
            }

            if (nums[i] > max3 && nums[i] < max2) {
                max3 = nums[i];
            }
        }

        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

    public static void main(String[] args) {
        MaximumProduct_628 target = new MaximumProduct_628();
        int[] nums = {1,2,3,2};
        int result = target.maximumProduct03(nums);
        System.out.println(result);
    }
}
