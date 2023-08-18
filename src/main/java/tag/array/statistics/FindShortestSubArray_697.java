package tag.array.statistics;

/**
 * @Projectname: leetcode
 * @Filename: FindShortestSubArray_697
 * @Author: LWQ
 * @Data:2023/8/16 22:45
 * @Description: easy
 */

import java.util.*;

/**
 *给定一个非空且只包含非负数的整数数组 nums，数组的 度 的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2,3,1]
 * 输出：2
 * 解释：
 * 输入数组的度是 2 ，因为元素 1 和 2 的出现频数最大，均为 2 。
 * 连续子数组里面拥有相同度的有如下所示：
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组 [2, 2] 的长度为 2 ，所以返回 2 。
 * 示例 2：
 *
 * 输入：nums = [1,2,2,3,1,4,2]
 * 输出：6
 * 解释：
 * 数组的度是 3 ，因为元素 2 重复出现 3 次。
 * 所以 [2,2,3,1,4,2] 是最短子数组，因此返回 6 。
 *
 *
 * 提示：
 *
 * nums.length 在 1 到 50,000 范围内。
 * nums[i] 是一个在 0 到 49,999 范围内的整数。
 */
public class FindShortestSubArray_697 {

    /**
     * 通过
     * 时间详情: 14ms, 击败 54.34%使用 Java 的用户
     * 内存详情: 44.91MB, 击败 40.87%使用 Java 的用户
     *
     * @param nums
     * @return
     * @Description: map-value 使用3位长度数组记录，0-出现次数，1-最小索引，2-最大索引
     */
    public int findShortestSubArray(int[] nums) {
        int result = nums.length;
        //int[3], 0-出现次数，1-最小索引，2-最大索引
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                // 出现次数加1
                map.get(nums[i])[0]++;
                // 更新最大索引
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new int[]{1,i,i});
            }
        }

        int count = 0;
        Iterator<Map.Entry<Integer, int[]>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            int[] value = iterator.next().getValue();
            if (count < value[0]) {
                count = value[0];
                result = value[2] - value[1] + 1;
            } else if (count == value[0]) {
                count = value[0];
                result = result < (value[2] - value[1] + 1) ? result : (value[2] - value[1] + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindShortestSubArray_697 target = new FindShortestSubArray_697();
        int[] nums = {1,2,2,3,1,4,2};
        int result = target.findShortestSubArray(nums);
        System.out.println(result);
    }
}
