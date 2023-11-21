package arithmetic.easy;

/**
 * @Projectname: leetcode
 * @Filename: NumArray_303
 * @Author: LWQ
 * @Data: 2023/11/8 22:27
 * @Description: easy
 */

/**
 * 给定一个整数数组  nums，处理以下类型的多个查询:
 *
 * 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
 * 实现 NumArray 类：
 *
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )
 *
 *
 * 示例 1：
 *
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 *
 * 解释：
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 * 0 <= i <= j < nums.length
 * 最多调用 104 次 sumRange 方法
 */
public class NumArray_303 {
    int[] arr;
    int[] sums;

    /**
     * 通过：
     * 时间详情：50ms，击败 20.53%使用 Java 的用户
     * 内存详情：46.65MB，击败 75.99%使用 Java 的用户
     * @param nums
     * @desception：暴力循环
     */
    /*public NumArray_303(int[] nums) {
        arr = nums;
    }

    public int sumRange(int left, int right) {
        // 题目用例，不考虑 left > right 的情况
        int result = 0;
        for (int i = left; i <= right; i++) {
            result += arr[i];
        }
        return result;
    }*/

    /**
     * 通过：
     * 时间详情：7ms，击败 100.00%使用 Java 的用户
     * 内存详情：46.88MB，击败 27.73%使用 Java 的用户
     * @param nums
     * @desception：前缀和
     */
    public NumArray_303(int[] nums) {
        int length = nums.length;
        sums = new int[length + 1];
        for (int i = 0; i < length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        // right+1：初始化时sums[0]默认0，不存储前缀和，从sums[1]开始存储
        // left：不加1是因为要统计 nums[left] 本身
        return sums[right + 1] - sums[left];
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(left,right);
     */

    /**
     * nums[0] 为实例化的数组，nums[1]~nums[...]为left和right
     * @param args
     */
    public static void main(String[] args) {
        int[][] nums = {{-2,0,3,-5,2,-1}, {0,2}, {2,5}, {0,5}};
        NumArray_303 numArray303 = new NumArray_303(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int result = numArray303.sumRange(nums[i][0], nums[i][1]);
            System.out.println(result);
        }
    }
}
