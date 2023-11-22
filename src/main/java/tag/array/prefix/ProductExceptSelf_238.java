package tag.array.prefix;

/**
 * @Projectname: leetcode
 * @Filename: ProductExceptSelf_238
 * @Author: LWQ
 * @Data: 2023/11/8 22:45
 * @Description: medium
 */

import java.util.Arrays;

/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 *
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 *
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 示例 2:
 *
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
 *
 *
 * 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。）
 */
public class ProductExceptSelf_238 {

    /**
     * 通过：
     * 时间详情：1ms，击败 100.00%使用 Java 的用户
     * 内存详情：50.92MB，击败 10.80%使用 Java 的用户
     * @param nums
     * @return
     * @desception：使用后缀和
     *      正序遍历数组，并记录当前元素的前缀和，当前位置的值为 前缀和 * 后缀和
     */
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];

        // 后缀和
        int sufSums = 1;
        for (int i = length-1; i >= 0 ; i--) {
            sufSums *= nums[i];
            result[i] = sufSums;
        }

        // 前缀和
        int preSums = 1;
        for (int i = 0; i < length-1; i++) {
            result[i] = preSums * result[i+1];
            preSums *= nums[i];
        }
        // 最后一位
        result[length - 1] = preSums;
        return result;
    }

    public static void main(String[] args) {
        ProductExceptSelf_238 target = new ProductExceptSelf_238();
        int[] nums = {1,2,3,4};
        int[] result = target.productExceptSelf2(nums);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 双向遍历
     * @param nums
     * @return
     */
    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[]{1,1,1,1};

        int prefix=1,suffix=1;
        for(int i=0;i<n;i++){
            ans[i]*=prefix;
            ans[n-i-1]*=suffix;
            prefix*=nums[i];
            suffix*=nums[n-i-1];
        }
        return ans;
    }
}
