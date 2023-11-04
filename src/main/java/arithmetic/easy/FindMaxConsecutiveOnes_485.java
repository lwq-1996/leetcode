package arithmetic.easy;

/**
 * @Projectname: leetcode
 * @Filename: FindMaxConsecutiveOnes_485
 * @Author: LWQ
 * @Data: 2023/8/16 22:26
 * @Description: easy
 */

/**
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 * 示例 2:
 *
 * 输入：nums = [1,0,1,1,0,1]
 * 输出：2
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1.
 */

public class FindMaxConsecutiveOnes_485 {

    /**
     * 通过
     * 时间详情: 2ms, 击败 42.48%使用 Java 的用户
     * 内存详情: 42.14mb, 击败 86.19%使用 Java 的用户
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                result = result < count ? count : result;
            } else {
                count = 0;
            }
        }
        return result;
    }

    /**
     * 通过
     * 时间详情: 1ms,击败 100.00%使用 Java 的用户
     * 内存详情: 42.49mb, 击败 17.78%使用 Java 的用户
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes02(int[] nums) {
        int result = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                result = result < count ? count : result;
                count = 0;
                if (result >= nums.length/2) {
                    return result;
                }
            }
        }
        return result < count ? count : result;
    }

    public static void main(String[] args) {
        FindMaxConsecutiveOnes_485 target = new FindMaxConsecutiveOnes_485();
        int[] nums = {1,1,1,0,1,1,1};
        int result = target.findMaxConsecutiveOnes02(nums);
        System.out.println(result);
    }
}
