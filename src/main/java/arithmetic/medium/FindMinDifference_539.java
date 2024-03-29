package arithmetic.medium;

/**
 * @Projectname: leetcode
 * @Filename: FindMinDifference_539
 * @Author: LWQ
 * @Data: 2023/12/4 22:44
 * @Description: medium
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 *
 *
 *
 * 示例 1：
 *
 * 输入：timePoints = ["23:59","00:00"]
 * 输出：1
 * 示例 2：
 *
 * 输入：timePoints = ["00:00","23:59","00:00"]
 * 输出：0
 *
 *
 * 提示：
 *
 * 2 <= timePoints.length <= 2 * 104
 * timePoints[i] 格式为 "HH:MM"
 */
public class FindMinDifference_539 {

    /**
     * 通过：
     * 时间详情：5ms，击败 69.41%使用 Java 的用户
     * 内存详情：42.95MB，击败 48.38%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/12/6 12:44
     * @Param [timePoints]
     * @return int
     * @Description: 统计每个时间的分钟数，排序后计算最小差值
     *  特殊处理差值大于12h，及跨天的场景
     */
    public int findMinDifference(List<String> timePoints) {
        int size = timePoints.size();
        int[] count = new int[size];
        for (int i = 0; i < size; i++) {
            String current = timePoints.get(i);
            String hour = current.substring(0, 2);
            String minute = current.substring(3);
            if ("00".equals(hour)) {
                hour = "24";
            }

            count[i] = Integer.valueOf(hour) * 60 + Integer.valueOf(minute);
        }

        Arrays.sort(count);
        // 首位的差值
        int result = count[size-1] - count[0] > 12*60 ? 24*60 - (count[size-1] - count[0]) : count[size-1] - count[0];
        for (int i = 1; i < size; i++) {
            int dif = count[i] - count[i-1];
            // 最大差值为12h，超出时需要交换计算的减数与被减数
            if (dif > 12*60) {
                dif = 24*60 - dif;
            }
            result = Math.min(dif, result);
        }
        
        return result;
    }

    /**
     * 通过：
     * 时间详情：3ms，击败 82.86%使用 Java 的用户
     * 内存详情：42.79MB，击败 66.38%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/12/6 12:52
     * @Param [timePoints]
     * @return int
     * @Description: 省略字符串转数字的过程
     */
    public int findMinDifference4(List<String> timePoints) {
        int size = timePoints.size();
        int[] count = new int[size];
        for (int i = 0; i < size; i++) {
            count[i] = getMinutes(timePoints.get(i));
        }

        Arrays.sort(count);
        // 首位的差值
        int result = count[size-1] - count[0] > 12*60 ? 24*60 - (count[size-1] - count[0]) : count[size-1] - count[0];
        for (int i = 1; i < size; i++) {
            int dif = count[i] - count[i-1];
            // 最大差值为12h，超出时需要交换计算的减数与被减数
            if (dif > 12*60) {
                dif = 24*60 - dif;
            }
            result = Math.min(dif, result);
        }

        return result;
    }

    public static void main(String[] args) {
        FindMinDifference_539 target = new FindMinDifference_539();
        List<String> timePoints = Arrays.asList("23:59","00:00");
//        timePoints = Arrays.asList("12:12","00:13");
//        timePoints = Arrays.asList("01:39","10:26","21:43");
        int result = target.findMinDifference(timePoints);
        System.out.println(result);
    }

    /**
     * @Author LWQ
     * @Date 2023/12/6 12:48
     * @Param [timePoints]
     * @return int
     * @Description: 排序
     */
    public int findMinDifference2(List<String> timePoints) {
        Collections.sort(timePoints);
        int ans = Integer.MAX_VALUE;
        int t0Minutes = getMinutes(timePoints.get(0));
        int preMinutes = t0Minutes;
        for (int i = 1; i < timePoints.size(); ++i) {
            int minutes = getMinutes(timePoints.get(i));
            ans = Math.min(ans, minutes - preMinutes); // 相邻时间的时间差
            preMinutes = minutes;
        }
        ans = Math.min(ans, t0Minutes + 1440 - preMinutes); // 首尾时间的时间差
        return ans;
    }

    /**
     * @Author LWQ
     * @Date 2023/12/6 12:49
     * @Param [timePoints]
     * @return int
     * @Description: 鸽巢原理
     * 根据题意，一共有 24×60=1440 种不同的时间。由鸽巢原理可知，如果 timePoints 的长度超过 1440，那么必然会有两个相同的时间，此时可以直接返回 0。
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/minimum-time-difference/solutions/1216027/zui-xiao-shi-jian-chai-by-leetcode-solut-xolj/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int findMinDifference3(List<String> timePoints) {
        int n = timePoints.size();
        if (n > 1440) {
            return 0;
        }
        Collections.sort(timePoints);
        int ans = Integer.MAX_VALUE;
        int t0Minutes = getMinutes(timePoints.get(0));
        int preMinutes = t0Minutes;
        for (int i = 1; i < n; ++i) {
            int minutes = getMinutes(timePoints.get(i));
            ans = Math.min(ans, minutes - preMinutes); // 相邻时间的时间差
            preMinutes = minutes;
        }
        ans = Math.min(ans, t0Minutes + 1440 - preMinutes); // 首尾时间的时间差
        return ans;
    }

    public int getMinutes(String t) {
        return ((t.charAt(0) - '0') * 10 + (t.charAt(1) - '0')) * 60 + (t.charAt(3) - '0') * 10 + (t.charAt(4) - '0');
    }

}
