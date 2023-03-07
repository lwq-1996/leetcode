package arithmetic.easy;

/**
 * @Projectname: leetcode
 * @Filename: MissingNumber_268
 * @Author: LWQ
 * @Data:2023/3/7 22:11
 * @Description: leetcode_practice
 * 
 * 给定一个包含 [0, n]中n个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：2
 * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 3：
 *
 * 输入：nums = [9,6,4,2,3,5,7,0,1]
 * 输出：8
 * 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 4：
 *
 * 输入：nums = [0]
 * 输出：1
 * 解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。
 * 
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 104
 * 0 <= nums[i] <= n
 * nums 中的所有数字都 独一无二
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/missing-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MissingNumber_268 {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：42.2 MB, 在所有 Java 提交中击败了54.11%的用户
     * 通过测试用例：122 / 122
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        byte[] window = new byte[n+1];

        for (int i = 0; i < n; i++) {
            window[nums[i]] = 1;
        }

        for (int i = 0; i < n+1; i++) {
            if (window[i] == 0) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MissingNumber_268 missingNumber_268 = new MissingNumber_268();
        int[] nums = {8,6,4,2,3,5,7,0,1};
        int i = missingNumber_268.missingNumber2(nums);
        System.out.println(i);
    }

    /**
     * 位运算，异或
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        /**
         * i 为 0～8， res 初始为 9，二者合计 0～9
         * nums[] 为 0～9，中间缺省一位
         */
        int res = nums.length;
        for (int i = 0; i < nums.length; ++i){
            res ^= nums[i];
            res ^= i;
        }
        return res;
    }
}
