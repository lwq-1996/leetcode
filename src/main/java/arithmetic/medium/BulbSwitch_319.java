package arithmetic.medium;

/**
 * @Projectname: leetcode
 * @Filename: BulbSwitch_319_TODO
 * @Author: LWQ
 * @Data: 2023/12/24 12:52
 * @Description: medium
 */

/**
 * 初始时有 n 个灯泡处于关闭状态。第一轮，你将会打开所有灯泡。接下来的第二轮，你将会每两个灯泡关闭第二个。
 *
 * 第三轮，你每三个灯泡就切换第三个灯泡的开关（即，打开变关闭，关闭变打开）。第 i 轮，你每 i 个灯泡就切换第 i 个灯泡的开关。直到第 n 轮，你只需要切换最后一个灯泡的开关。
 *
 * 找出并返回 n 轮后有多少个亮着的灯泡。
 *
 *
 *
 * 示例 1：
 *
 *  /Users/luwanqiang/project/leetcode/src/main/java/comm/img/319_ex1.jpg
 *
 * 输入：n = 3
 * 输出：1
 * 解释：
 * 初始时, 灯泡状态 [关闭, 关闭, 关闭].
 * 第一轮后, 灯泡状态 [开启, 开启, 开启].
 * 第二轮后, 灯泡状态 [开启, 关闭, 开启].
 * 第三轮后, 灯泡状态 [开启, 关闭, 关闭].
 *
 * 你应该返回 1，因为只有一个灯泡还亮着。
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：1
 *
 *
 * 提示：
 *
 * 0 <= n <= 109
 */
public class BulbSwitch_319 {

    /**
     * 超时
     * @param n
     * @return
     * @desception：数据记录每个灯泡状态
     * n过大时占用空间较大
     */
    public int bulbSwitch(int n) {
        if (n < 2) {
            return n;
        }
        int[] window = new int[n];
        for (int i = 2; i <= n; i++) {
            // 第一位在第一轮后永远不会改变
            for (int j = i; j <= n; j++) {
                if (j % i == 0) {
                    window[j-1] ^= 1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            count += window[i];
        }
        // 0为亮灯
        return n-count;
    }

    public static void main(String[] args) {
        BulbSwitch_319 target = new BulbSwitch_319();
        int n = 7;
        int result = target.bulbSwitch(n);
        System.out.println(result);
    }

    /**
     * @param n
     * @return
     * @desception：数学
     */
    public int bulbSwitch2(int n) {
        return (int) Math.sqrt(n + 0.5);
    }
}
