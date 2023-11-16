package tag.array.rotate;

/**
 * @Projectname: leetcode
 * @Filename: Rotate_189
 * @Author: LWQ
 * @Data: 2023/11/8 13:15
 * @Description: medium
 */

import java.util.*;

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *
 *
 * 进阶：
 *
 * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 */
public class Rotate_189 {

    /**
     * 超时：
     * @param nums
     * @param k
     * @desception：暴力循环
     */
    public void rotate(int[] nums, int k) {
        int lastIndex = nums.length - 1;
        if (lastIndex < 0) {
            return;
        }
        int current;
        for (int i = 0; i < k; i++) {
            current = nums[lastIndex];
            for (int j = lastIndex; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = current;
        }
    }

    /**
     * 通过：
     * 时间详情：0ms，击败 100.00%使用 Java 的用户
     * 内存详情：52.75MB，击败 67.28%使用 Java 的用户
     * @param nums
     * @param k
     * @desception：先整体翻转，再找出分界点，左右分别翻转
     */
    public void rotate2(int[] nums, int k) {
        int length = nums.length;
        if (length < 1) {
            return;
        }

        k %= length;
        revert(nums, 0, length - 1);
        revert(nums, 0, k - 1);
        revert(nums, k, length - 1);
    }

    public void revert(int[]nums, int start, int end) {
        int tmp;
        while (start < end) {
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Rotate_189 target = new Rotate_189();
        int[] nums = {1,2,3,4,5,6,7};
        nums = new int[]{-1, 2, 3};
        int k = 7;
        target.rotate2(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 额外数组
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }

    /**
     * 环状替换
     * @param nums
     * @param k
     */
    public void rotate4(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    /**
     * 数组翻转
     * @param nums
     * @param k
     * @desception：
     *  该方法基于如下的事实：当我们将数组的元素向右移动 kkk 次后，尾部 k mod n 个元素会移动至数组头部，其余元素向后移动 k mod n 个位置。
     *
     *  该方法为数组的翻转：我们可以先将所有元素翻转，这样尾部的 k mod n 个元素就被移至数组头部，然后我们再翻转 [0,k mod n−1] 区间的元素和 [k mod n,n−1] 区间的元素即能得到最后的答案。
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/rotate-array/solutions/551039/xuan-zhuan-shu-zu-by-leetcode-solution-nipk/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public void rotate5(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
