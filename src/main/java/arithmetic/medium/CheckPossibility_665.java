package arithmetic.medium;

/**
 * @Projectname: leetcode
 * @Filename: CheckPossibility_665
 * @Author: LWQ
 * @Data: 2023/8/18 21:36
 * @Description: medium
 */

/**
 * 给你一个长度为 n 的整数数组 nums ，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个 4 变成 1 来使得它成为一个非递减数列。
 * 示例 2:
 *
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 *
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 104
 * -105 <= nums[i] <= 105
 */
public class CheckPossibility_665 {

    /**
     * 通过
     * 时间详情: 0ms, 击败 100.00%使用 Java 的用户
     * 内存详情: 41.68MB, 击败 90.59%使用 Java 的用户
     *
     * @param nums
     * @return
     * @Description: 非递减数列不等于递增数列，相邻位置数值允许相同
     *  当发现当前位置 i 比前者 i-1小时，若i<i-2 && i+1<i-1时，数列没有满足条件的调整
     */
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                count+=1;
                if (i>1 && nums[i] < nums[i-2]) {
                    if (i<nums.length-1 && nums[i+1]<nums[i-1]) {
                        return false;
                    }
                }
            }
        }
        return count > 1 ? false : true;
    }

    public static void main(String[] args) {
        CheckPossibility_665 target = new CheckPossibility_665();
        int[] nums = {4,2,3};
//        nums = new int[]{5,7,1,8};
        nums = new int[]{-1,4,2,3};
        boolean result = target.checkPossibility(nums);
        System.out.println(result);
    }
}
