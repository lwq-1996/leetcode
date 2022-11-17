package arithmetic.easy;

import java.util.Arrays;

/**
 * @Projectname: leetcode
 * @Filename: MajorityElement_169
 * @Author: LWQ
 * @Data:2022/11/15 19:38
 * @Description: leetcode_practice
 * 
 * 
 * 给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 
 *
 * 示例1：
 *
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例2：
 *
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 * 
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 * 
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MajorityElement_169 {

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了60.21%的用户
     * 内存消耗：45.1 MB, 在所有 Java 提交中击败了47.86%的用户
     * 通过测试用例：43 / 43
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        MajorityElement_169 majorityElement_169 = new MajorityElement_169();
        int[] nums = {3,2,3};
        int majorityElement = majorityElement_169.majorityElement(nums);
        System.out.println(majorityElement);
    }

    /**
     * 统计
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int count = 1;
        int maj = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maj == nums[i])
                count++;
            else {
                count--;
                if (count == 0) {
                    maj = nums[i + 1];
                }
            }
        }
        return maj;
    }
}
