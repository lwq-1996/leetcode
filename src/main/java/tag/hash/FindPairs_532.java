package tag.hash;

/**
 * @Projectname: leetcode
 * @Filename: FindPairs_532
 * @Author: LWQ
 * @Data: 2024/8/14 22:46
 * @Description: medium
 */

import java.util.*;

/**
 * 给你一个整数数组 nums 和一个整数 k，请你在数组中找出 不同的 k-diff 数对，并返回不同的 k-diff 数对 的数目。
 *
 * k-diff 数对定义为一个整数对 (nums[i], nums[j]) ，并满足下述全部条件：
 *
 * 0 <= i, j < nums.length
 * i != j
 * |nums[i] - nums[j]| == k
 * 注意，|val| 表示 val 的绝对值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3, 1, 4, 1, 5], k = 2
 * 输出：2
 * 解释：数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个 1 ，但我们只应返回不同的数对的数量。
 * 示例 2：
 *
 * 输入：nums = [1, 2, 3, 4, 5], k = 1
 * 输出：4
 * 解释：数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5) 。
 * 示例 3：
 *
 * 输入：nums = [1, 3, 1, 5, 4], k = 0
 * 输出：1
 * 解释：数组中只有一个 0-diff 数对，(1, 1) 。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -107 <= nums[i] <= 107
 * 0 <= k <= 107
 */
public class FindPairs_532 {

    public int findPairs(int[] nums, int k) {
        Set<Integer> visited = new HashSet<Integer>();
        Set<Integer> res = new HashSet<Integer>();
        for (int num : nums) {
            // 左移k位
            if (visited.contains(num - k)) {
                res.add(num);
            }
            // 右移k位
            if (visited.contains(num + k)) {
                res.add(num);
            }
            visited.add(num);
        }
        return res.size();
    }

    public int findPairs2(int[] nums, int k) {
        Set<Integer> vis = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int num : nums) {
            if (vis.contains(num - k)) {
                res.add(num);// 数对为：[num-k,num] 以第二个数唯一标记一个数对
//                res.add(num - k);// 数对为：[num-k,num] 以第一个数唯一标记一个数对
            }
            if (vis.contains(num + k)) {
                res.add(num + k);// 数对为：[num,num+k]  以第二个数唯一标记一个数对
//                res.add(num);// 数对为：[num,num+k]  以第一个数唯一标记一个数对
            }
            vis.add(num);
        }
        return res.size();
    }

    public static void main(String[] args) {
        FindPairs_532 target = new FindPairs_532();
        int[] nums = {1,2,4,4,3,3,0,9,2,3};
        int k = 3;
        int result = target.findPairs(nums, k);
        System.out.println(result);
    }
}
