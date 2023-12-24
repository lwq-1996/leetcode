package tag.bit.bit_operation;

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
public class BulbSwitch_319_TODO {

    public int bulbSwitch(int n) {
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        BulbSwitch_319_TODO target = new BulbSwitch_319_TODO();
        int n = 3;
        int result = target.bulbSwitch(n);
        System.out.println(result);
    }
}
