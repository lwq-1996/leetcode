package tag.array.change_and_move;

/**
 * @Projectname: leetcode
 * @Filename: MoveZeroes_283
 * @Author: LWQ
 * @Data: 2023/8/18 21:38
 * @Description: easy
 */

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
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
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 */
public class MoveZeroes_283 {

    /**
     * 通过
     * 时间详情: 30ms, 击败 10.11%使用 Java 的用户
     * 内存详情: 42.92MB, 击败 71.81%使用 Java 的用户
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int pre = 0, lat = 0;
        while (pre < length && lat < length) {
            if (nums[pre] == 0) {
                lat = pre;
                while (lat < length && nums[lat] == 0) {
                    lat++;
                }
                if (lat >= length) {
                    return;
                }
                nums[pre] = nums[pre] ^ nums[lat];
                nums[lat] = nums[pre] ^ nums[lat];
                nums[pre] = nums[pre] ^ nums[lat];
                pre++;
            } else {
                pre++;
            }
        }
    }

    /**
     * 通过
     * 时间详情: 1ms, 击败 100.00%使用 Java 的用户
     * 内存详情: 42.92MB, 击败 71.18%使用 Java 的用户
     *
     * @param nums
     * @Description: 自己与自己交换
     */
    public void moveZeroes02(int[] nums) {
        if (nums.length < 2) {
            return;
        }

        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            /**
             * i == current 时，自己与自己交换，
             * 连续的0，交换完第一个0后，current会停留在第二个0处
             * 非连续0，交换完后，current跟随着后移
             */
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[current];
                nums[current++] = temp;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes_283 target = new MoveZeroes_283();
        int[] nums = {4,2,4,0,0,3,0,5,1,0};
        target.moveZeroes02(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * @param nums
     * @Decription: 全部先放到左边，之后将边界右边的全部置为0即可
     */
    public void moveZeroes03(int[] nums) {
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
