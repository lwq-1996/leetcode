package tag.array.change_and_move;

/**
 * @Projectname: leetcode
 * @Filename: MinMoves_453
 * @Author: LWQ
 * @Data: 2023/8/18 21:33
 * @Description: medium
 */

import java.util.*;

/**
 * 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：3
 * 解释：
 * 只需要3次操作（注意每次操作会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * 示例 2：
 *
 * 输入：nums = [1,1,1]
 * 输出：0
 *
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 答案保证符合 32-bit 整数
 */
public class MinMoves_453 {

    /**
     *  超时！！！
     * @param nums
     * @return
     * @Description: 每次操作的其他值加1，转变为最大值减1，最后首位一致即全部数据一致
     *  Map<值,出现次数>
     */
    public int minMoves(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 极限案例  [1,1,1000000000]
        if (map.size() == 2 && map.lastEntry().getValue() == 1) {
            return map.lastKey() - map.firstKey();
        }

        int lastKey;
        int lastValue;
        int count = 0;
        while (map.size() > 1) {
            count++;
            Map.Entry<Integer, Integer> lastEntry = map.lastEntry();
            lastKey = lastEntry.getKey();
            lastValue = lastEntry.getValue();
            if (lastValue < 2) {
                // 最大数只有一个，弹出
                map.pollLastEntry();
            } else {
                // 最大数不止一个，出现次数减1
                map.put(lastKey, lastValue - 1);
            }
            // 最大数减1，
            map.put(lastKey - 1, map.getOrDefault(lastKey - 1, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        MinMoves_453 target = new MinMoves_453();
        int[] nums = {1,2,1000000000};
        int result = target.minMoves2(nums);
        System.out.println(result);
    }

    /**
     * 要计算让数组中所有元素相等的操作数，只需要计算将数组中所有元素都减少到数组中元素最小值所需的操作数
     * @param nums
     * @return
     */
    public int minMoves2(int[] nums) {
        int minNum = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for (int num : nums) {
            res += num - minNum;
        }
        return res;
    }
}
