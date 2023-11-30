package arithmetic.easy;

/**
 * @Projectname: leetcode
 * @Filename: JudgeCircle_657
 * @Author: LWQ
 * @Data: 2023/11/25 13:11
 * @Description: easy
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。
 *
 * 移动顺序由字符串 moves 表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）。
 *
 * 如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
 *
 * 注意：机器人“面朝”的方向无关紧要。 “R” 将始终使机器人向右移动一次，“L” 将始终向左移动等。此外，假设每次移动机器人的移动幅度相同。
 *
 *
 *
 * 示例 1:
 *
 * 输入: moves = "UD"
 * 输出: true
 * 解释：机器人向上移动一次，然后向下移动一次。所有动作都具有相同的幅度，因此它最终回到它开始的原点。因此，我们返回 true。
 * 示例 2:
 *
 * 输入: moves = "LL"
 * 输出: false
 * 解释：机器人向左移动两次。它最终位于原点的左侧，距原点有两次 “移动” 的距离。我们返回 false，因为它在移动结束时没有返回原点。
 *
 *
 * 提示:
 *
 * 1 <= moves.length <= 2 * 104
 * moves 只包含字符 'U', 'D', 'L' 和 'R'
 */
public class JudgeCircle_657 {

    /**
     * 通过：
     * 时间详情：15ms，击败 5.64%使用 Java 的用户
     * 内存详情：43.39MB，击败 5.05%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/11/30 12:37
     * @Param [moves]
     * @return boolean
     * @Description: 比较上下、左右步数
     */
    public boolean judgeCircle(String moves) {
        char[] charArray = moves.toCharArray();
        Map<Character, Integer> map = new HashMap<>(6);
        // 防止空指针
        map.put('U',0);
        map.put('D',0);
        map.put('L',0);
        map.put('R',0);
        for (char chr : charArray) {
            map.put(chr, map.getOrDefault(chr, 0)+1);
        }

        if (map.get('U').equals(map.get('D')) && map.get('L').equals(map.get('R'))) {
            return true;
        }
        return false;
    }

    /**
     * 通过：
     * 时间详情：4ms，击败 95.04%使用 Java 的用户
     * 内存详情：42.41MB，击败 48.01%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/11/30 12:42
     * @Param [moves]
     * @return boolean
     * @Description: 
     */
    public boolean judgeCircle2(String moves) {
        char[] charArray = moves.toCharArray();
        int col=0, row=0;
        for (char chr : charArray) {
            if (chr == 'U') {
                col++;
            } else if (chr == 'D') {
                col--;
            } else if (chr == 'L') {
                row++;
            } else if (chr == 'R') {
                row--;
            }
        }

        return col == 0 && row == 0;
    }

    public static void main(String[] args) {
        JudgeCircle_657 target = new JudgeCircle_657();
        String moves = "UD";
        boolean result = target.judgeCircle(moves);
        System.out.println(result);
    }
}
