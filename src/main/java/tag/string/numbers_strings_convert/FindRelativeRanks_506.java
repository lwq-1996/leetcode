package tag.string.numbers_strings_convert;

/**
 * @Projectname: leetcode
 * @Filename: FindRelativeRanks_506
 * @Author: LWQ
 * @Data: 2023/12/4 22:42
 * @Description: easy
 */

import java.util.*;

/**
 * 给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
 *
 * 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：
 *
 * 名次第 1 的运动员获金牌 "Gold Medal" 。
 * 名次第 2 的运动员获银牌 "Silver Medal" 。
 * 名次第 3 的运动员获铜牌 "Bronze Medal" 。
 * 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
 * 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
 *
 *
 *
 * 示例 1：
 *
 * 输入：score = [5,4,3,2,1]
 * 输出：["Gold Medal","Silver Medal","Bronze Medal","4","5"]
 * 解释：名次为 [1st, 2nd, 3rd, 4th, 5th] 。
 * 示例 2：
 *
 * 输入：score = [10,3,8,9,4]
 * 输出：["Gold Medal","5","Bronze Medal","Silver Medal","4"]
 * 解释：名次为 [1st, 5th, 3rd, 2nd, 4th] 。
 *
 *
 * 提示：
 *
 * n == score.length
 * 1 <= n <= 104
 * 0 <= score[i] <= 106
 * score 中的所有值 互不相同
 */
public class FindRelativeRanks_506 {

    /**
     * 通过：
     * 时间详情：6ms，击败 88.39%使用 Java 的用户
     * 内存详情：43.94MB，击败 6.63%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/12/5 23:21
     * @Param [score]
     * @return java.lang.String[]
     * @Description: 有序集合，poll出最后一个entry
     */
    public String[] findRelativeRanks(int[] score) {
        int length = score.length;
        String[] ranking = {"Gold Medal", "Silver Medal","Bronze Medal"};
        // 有序集合
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < length; i++) {
            map.put(score[i], i);
        }

        String[] result = new String[length];
        for (int i = 0; i < length; i++) {
            Map.Entry<Integer, Integer> entry = map.pollLastEntry();
            if (i < 3) {
                result[entry.getValue()] = ranking[i];
                continue;
            }
            // 名次从 1 开始
            result[entry.getValue()] = Integer.toString(i+1);
        }

        return result;
    }

    public static void main(String[] args) {
        FindRelativeRanks_506 target = new FindRelativeRanks_506();
        int[] score = {5,4,3,2,1};
        String[] result = target.findRelativeRanks(score);
        System.out.println(Arrays.toString(result));
    }

    /**
     * @Author LWQ
     * @Date 2023/12/5 23:31
     * @Param [score]
     * @return java.lang.String[]
     * @Description: 排序
     */
    public String[] findRelativeRanks2(int[] score) {
        int n = score.length;
        String[] desc = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; ++i) {
            arr[i][0] = score[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        String[] ans = new String[n];
        for (int i = 0; i < n; ++i) {
            if (i >= 3) {
                ans[arr[i][1]] = Integer.toString(i + 1);
            } else {
                ans[arr[i][1]] = desc[i];
            }
        }
        return ans;
    }
}
