package tag.array.statistics;

/**
 * @Projectname: leetcode
 * @Filename: FindDisappearedNumbers_448
 * @Author: LWQ
 * @Data: 2023/8/16 22:51
 * @Description: easy
 */

import java.util.*;

/**
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内
 * 但没有出现在 nums 中的数字，并以数组的形式返回结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * 示例 2：
 *
 * 输入：nums = [1,1]
 * 输出：[2]
 *
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 * 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。
 */
public class FindDisappearedNumbers_448 {

    /**
     * 通过
     * 时间详情: 17ms, 击败 23.64%使用 Java 的用户
     * 内存详情: 51.97MB, 击败 18.54%使用 Java 的用户
     *
     * @param nums
     * @return
     * @Description:
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int i = 1; i <= length; i++) {
            if (set.contains(i)) {
                continue;
            }
            result.add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        FindDisappearedNumbers_448 target = new FindDisappearedNumbers_448();
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> result = target.findDisappearedNumbers02(nums);
        System.out.println(result);
    }

    /**
     * 通过
     * 时间详情: 3ms, 击败 98.75%使用 Java 的用户
     * 内存详情: 50.68MB, 击败 72.04%使用 Java 的用户
     *
     * @param nums
     * @return
     * @Description: 数组原地修改，把数组下标当作比较纬度
     */
    public List<Integer> findDisappearedNumbers02(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }
}
