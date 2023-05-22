package arithmetic.medium;

/**
 * @Projectname: leetcode
 * @Filename: NextPermutation_31
 * @Author: LWQ
 * @Data:2023/5/22 10:24
 * @Description: leetcode_practice
 */

import java.util.Arrays;

/**
 * 整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。
 *
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 *
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * 
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 *
 * 示例 2：
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 *
 * 示例 3：
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * 
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NextPermutation_31 {

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了3.63%的用户
     * 内存消耗：41.3 MB, 在所有 Java 提交中击败了95.04%的用户
     * 通过测试用例：265 / 265
     * @param nums
     */
    public void nextPermutation(int[] nums) {

        if (nums.length == 1) {
            return;
        }

        int left = 0;
        int right = 0;
        int current = 0;

        // 寻找num[i] < num[i+1], 只需要处理num[i]
        for (int i = nums.length - 2; i >= 0 ; i--) {
            if (nums[i] < nums[i+1]) {
                left = i;
                right = i + 1;
                current = nums[right] - nums[left];
                break;
            }
        }

        // 寻找比num[left]大的最小数，交换
        for (int i = left + 1; i < nums.length; i++) {
            if (nums[left] < nums[i] && Math.abs(nums[left] - nums[i]) < current) {
                right = i;
                current = nums[right] - nums[left];
            }
        }
        // 特殊场景，原数组没有下一个排列
        if (left == 0 && right == 0) {
            right = nums.length - 1;
        }

        // 交换
        nums[left] = nums[left] ^ nums[right];
        nums[right] = nums[left] ^ nums[right];
        nums[left] = nums[left] ^ nums[right];

        /// num[left+1]及往后的数 需要重排
        Arrays.sort(nums, left + 1, nums.length);
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了37.92%的用户
     * 内存消耗：41.4 MB, 在所有 Java 提交中击败了91.15%的用户
     * 通过测试用例：265 / 265
     * @param nums
     */
    public void nextPermutation2(int[] nums) {
        for (int i = nums.length; i >= 0 ; i--) {
            // 从后往前一定是有大小顺序，则此时找靠后的一位一定为比nums[i]大的最小数
            for (int j = nums.length - 1; j > i ; j--) {
                if (nums[i] < nums[j]) {
                    // 交换
                    nums[i] = nums[i] ^ nums[j];
                    nums[j] = nums[i] ^ nums[j];
                    nums[i] = nums[i] ^ nums[j];
                    // 反转（重排）
                    Arrays.sort(nums, i + 1, nums.length);
                    return;
                }
            }
        }

        // 当前数组没有下一个排列
        Arrays.sort(nums, 0, nums.length);
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了37.92%的用户
     * 内存消耗：41.1 MB, 在所有 Java 提交中击败了99.39%的用户
     * 通过测试用例：265 / 265
     * @param nums
     */
    public void nextPermutation3(int[] nums) {
        for (int i = nums.length - 2; i >= 0 ; i--) {
            // 寻找num[i] < nums[i+1]
            if (nums[i] < nums[i+1]) {
                // 从后往前一定是有大小顺序，则此时找靠后的一位一定为比nums[i]大的最小数
                for (int j = nums.length - 1; j > i ; j--) {
                    if (nums[i] < nums[j]) {
                        // 交换
                        nums[i] = nums[i] ^ nums[j];
                        nums[j] = nums[i] ^ nums[j];
                        nums[i] = nums[i] ^ nums[j];
                        // 反转（重排）
                        Arrays.sort(nums, i + 1, nums.length);
                        return;
                    }
                }
            }
        }

        // 当前数组没有下一个排列
        Arrays.sort(nums, 0, nums.length);
    }
    
    public static void main(String[] args) {
        NextPermutation_31 nextPermutation_31 = new NextPermutation_31();
        int[] nums = {4,3,2,1};
        nums = new int[]{1, 2, 5, 4, 3};
//        nums = new int[]{2,3,1};
        nextPermutation_31.nextPermutation3(nums);
        System.out.println(Arrays.toString(nums));
    }
}
