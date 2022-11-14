package arithmetic.easy;

import java.util.Arrays;

/**
 * @Projectname: leetcode
 * @Filename: MoveZeroes_283
 * @Author: LWQ
 * @Data:2022/11/12 16:57
 * @Description: leetcode_practice
 * 
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 
 *
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MoveZeroes_283 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：42.4 MB, 在所有 Java 提交中击败了97.68%的用户
     * 通过测试用例：74 / 74
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums.length < 2) {
            return;
        }

        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[current];
                nums[current++] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        int[] nums2 = {1,0};
        MoveZeroes_283 moveZeroes_283 = new MoveZeroes_283();
        moveZeroes_283.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 思路同上一致，只是将交换移出来，对边界外的进行单独处理
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
