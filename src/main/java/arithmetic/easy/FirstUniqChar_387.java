package arithmetic.easy;

/**
 * @Projectname: leetcode
 * @Filename: FirstUniqChar_387
 * @Author: LWQ
 * @Data: 2023/11/25 12:55
 * @Description: easy
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: 0
 * 示例 2:
 *
 * 输入: s = "loveleetcode"
 * 输出: 2
 * 示例 3:
 *
 * 输入: s = "aabb"
 * 输出: -1
 *
 *
 * 提示:
 *
 * 1 <= s.length <= 105
 * s 只包含小写字母
 */
public class FirstUniqChar_387 {

    /**
     * 通过：
     * 时间详情：25ms，击败 44.00%使用 Java 的用户
     * 内存详情：43.44MB，击败 5.04%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/11/27 23:14
     * @Param [s]
     * @return int
     * @Description: 使用额外空间map
     */
    public int firstUniqChar(String s) {
        int length = s.length();
        Map<Character, Integer> map = new HashMap<>((int)(length/0.75+1));

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (map.get(c) == null) {
                map.put(c, i);
            } else {
                map.put(c, Integer.MAX_VALUE);
            }
        }

        int result = -1;
        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next().getValue();
            if (value == Integer.MAX_VALUE) {
                continue;
            }
            result = result < 0 ? value : (result < value ? result : value);
        }

        return result;
    }

    public static void main(String[] args) {
        FirstUniqChar_387 target = new FirstUniqChar_387();
        String s = "leetcode";
        int result = target.firstUniqChar2(s);
        System.out.println(result);
    }

    /**
     * @Author LWQ
     * @Date 2023/11/27 23:31
     * @Param [s]
     * @return int
     * @Description: 数组计数，统计字符出现的次数，最后返回数组中第一个出现1的
     *      使用数组会比map快
     */
    public int firstUniqChar2(String s) {
        char[] chs = s.toCharArray();
        int len = chs.length;
        int[] map = new int[26];

        for (int i = 0; i < len; i++) {
            int index = chs[i] - 'a';
            map[index]++;
        }

        for (int i = 0; i < len; i++) {
            int index = chs[i] - 'a';
            if (map[index] == 1) {
                return i;
            }
        }

        return -1;
    }
}
