package tag.string.statistics;

/**
 * @Projectname: leetcode
 * @Filename: OriginalDigits_423
 * @Author: LWQ
 * @Data: 2023/11/25 13:10
 * @Description: medium
 */

import java.util.*;
import java.util.stream.Stream;

/**
 * 给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "owoztneoer"
 * 输出："012"
 * 示例 2：
 *
 * 输入：s = "fviefuro"
 * 输出："45"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 105
 * s[i] 为 ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"] 这些字符之一
 * s 保证是一个符合题目要求的字符串
 */
public class OriginalDigits_423 {

    /**
     * 通过：
     * 时间详情：32ms，击败 9.23%使用 Java 的用户
     * 内存详情：43.45MB，击败 5.06%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/11/29 12:59
     * @Param [s]
     * @return java.lang.String
     * @Description: 按特殊顺序寻找单词
     *      0-zero，1-one，2-two，3-three，4-four，
     *      5-five，6-six，7-seven，8-eight，9-nine。
     *    独有字母：zero-z，two-w，four-u，six-x，eight-g。
     *    筛除独有字母单词后，剩余：1-one，3-three，5-five，7-seven，9-nine。再在这六个数字中寻找独有字母的单词
     *                          one-o，three-r，five-f，seven-s，
     *                          nine是最后余下的，因为s 保证是一个符合题目要求的字符串，所以余下的都是nine
     */
    public String originalDigits(String s) {
        String[][] var0 = {{"zero","0"},{"two","2"},{"four","4"},{"six","6"},{"eight","8"},{"one","1"},{"three","3"},{"five","5"},{"seven","7"},{"nine","9"}};
        char[] var1 = {'z','w','u','x','g','o','r','f','s','i'};
        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (char var2 : charArray) {
            map.put(var2, map.getOrDefault(var2, 0)+1);
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < var1.length; i++) {
            int count = map.getOrDefault(var1[i], 0);
            deal(map, list, var0[i], count);
        }
        list.sort((a,b) -> Integer.valueOf(a) - Integer.valueOf(b));

        StringBuilder result = new StringBuilder();
        for(String str : list) {
            result.append(str);
        }

        return result.toString();
    }

    public void deal(Map<Character, Integer> map, List<String> list, String[] str, int count) {
        if (count == 0) {
            return;
        }

        char[] charArray = str[0].toCharArray();
        for (int i = 0; i < count; i++) {
            for (char var0 : charArray) {
                map.put(var0, map.get(var0)-1);
            }
            list.add(str[1]);
        }
    }

    public static void main(String[] args) {
        OriginalDigits_423 target = new OriginalDigits_423();
        String s = "owoztneoer";
        String result = target.originalDigits(s);
        System.out.println(result);
    }

    /**
     * @Author LWQ
     * @Date 2023/11/29 23:08
     * @Param [s]
     * @return java.lang.String
     * @Description: 
     *      z,w,u,x,g都只在一个数字中，即 0,2,4,6,8中出现。因此我们可以使用一个哈希表统计每个字母出现的次数，那么 z,w,u,x,g 出现的次数，即分别为 0,2,4,6,8 出现的次数。
     *
     * 随后我们可以注意那些只在两个数字中出现的字符：
     *
     * h 只在 3,8 中出现。由于我们已经知道了 8 出现的次数，因此可以计算出 3 出现的次数。
     *
     * f 只在 4,5 中出现。由于我们已经知道了 4 出现的次数，因此可以计算出 5 出现的次数。
     *
     * s 只在 6,7 中出现。由于我们已经知道了 6 出现的次数，因此可以计算出 7 出现的次数。
     *
     * 此时，我们还剩下 1 和 9 的出现次数没有求出：
     *
     * o 只在 0,1,2,4 中出现，由于我们已经知道了 0,2,4 出现的次数，因此可以计算出 1 出现的次数。
     * 最后的 9 就可以通过 n,i,e 中的任一字符计算得到了。这里推荐使用 i 进行计算，因为 n 在 9 中出现了 2 次，e 在 3 中出现了 2 次，容易在计算中遗漏。
     *
     * 当我们统计完每个数字出现的次数后，我们按照升序将它们进行拼接即可。
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/reconstruct-original-digits-from-english/solutions/1117147/cong-ying-wen-zhong-zhong-jian-shu-zi-by-9g1r/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public String originalDigits2(String s) {
        Map<Character, Integer> c = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            c.put(ch, c.getOrDefault(ch, 0) + 1);
        }

        int[] cnt = new int[10];
        cnt[0] = c.getOrDefault('z', 0);
        cnt[2] = c.getOrDefault('w', 0);
        cnt[4] = c.getOrDefault('u', 0);
        cnt[6] = c.getOrDefault('x', 0);
        cnt[8] = c.getOrDefault('g', 0);

        cnt[3] = c.getOrDefault('h', 0) - cnt[8];
        cnt[5] = c.getOrDefault('f', 0) - cnt[4];
        cnt[7] = c.getOrDefault('s', 0) - cnt[6];

        cnt[1] = c.getOrDefault('o', 0) - cnt[0] - cnt[2] - cnt[4];

        cnt[9] = c.getOrDefault('i', 0) - cnt[5] - cnt[6] - cnt[8];

        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < cnt[i]; ++j) {
                ans.append((char) (i + '0'));
            }
        }
        return ans.toString();
    }
}
