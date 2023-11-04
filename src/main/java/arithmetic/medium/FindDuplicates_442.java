package arithmetic.medium;

/**
 * @Projectname: leetcode
 * @Filename: FindDuplicates_442
 * @Author: LWQ
 * @Data: 2023/8/16 22:54
 * @Description: medium
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，
 * 且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
 *
 * 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[2,3]
 * 示例 2：
 *
 * 输入：nums = [1,1,2]
 * 输出：[1]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[]
 *
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 * nums 中的每个元素出现 一次 或 两次
 */
public class FindDuplicates_442 {

    /**
     * 通过
     * 时间详情: 3ms, 击败 99.58%使用 Java 的用户
     * 内存详情: 50.57MB, 击败 79.27%使用 Java 的用户
     *
     * @param nums
     * @return
     * @Decription: 同448，由于数值范围在 1～n 之间，可以与数组索引对应
     *     所以在当前数值-1的索引位上进行加权，由于只会重复出现两次，所以重复
     *     数值会在-1的索引位上加n两次，最后遍历比较，若当前索引位的值大于2n，
     *     则当前索引位+1，为重复出现的数字
     *      在当前索引上加权时 {2,2}场景会出错
     *      所以在 -1 的索引位上进行加权
     */
    public List<Integer> findDuplicates(int[] nums) {
        int length = nums.length;
        List<Integer> result = new ArrayList<>();
        for (int var0 : nums) {
            int var1 = (var0 - 1) % length;
            nums[var1] += length;
        }

        for (int i = 0; i < length; i++) {
            if (nums[i] > 2*length) {
                result.add(i + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindDuplicates_442 target = new FindDuplicates_442();
        int[] nums = {4,3,2,7,8,2,3,1,8};
        int[] nums2 = {2,2};
        List<Integer> result = target.findDuplicates(nums2);
        System.out.println(result);
    }
}
