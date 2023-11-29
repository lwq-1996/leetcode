package arithmetic.medium;

/**
 * @Projectname: leetcode
 * @Filename: FrequencySort_451
 * @Author: LWQ
 * @Data: 2023/11/25 13:08
 * @Description: medium
 */

import java.util.*;

/**
 * 给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
 *
 * 返回 已排序的字符串 。如果有多个答案，返回其中任何一个。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "tree"
 * 输出: "eert"
 * 解释: 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 *
 * 输入: s = "cccaaa"
 * 输出: "cccaaa"
 * 解释: 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 *
 * 输入: s = "Aabb"
 * 输出: "bbAa"
 * 解释: 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 *
 *
 * 提示:
 *
 * 1 <= s.length <= 5 * 105
 * s 由大小写英文字母和数字组成
 */
public class FrequencySort_451 {

    /**
     * 通过：
     * 时间详情：14ms，击败 67.86%使用 Java 的用户
     * 内存详情：43.43MB，击败 47.54%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/11/29 12:39
     * @Param [s]
     * @return java.lang.String
     * @Description: 计数后排序
     */
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (char var0 : charArray) {
            map.put(var0, map.getOrDefault(var0, 0) + 1);
        }

        List<Character> list = new ArrayList<>(map.keySet());
        // 排序
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        StringBuilder result = new StringBuilder();
        for (Character var1 : list) {
            int var2 = map.get(var1);
            for (int i = 0; i < var2; i++) {
                result.append(var1);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        FrequencySort_451 target = new FrequencySort_451();
        String s = "tree";
        String result = target.frequencySort(s);
        System.out.println(result);
    }

    /**
     * @Author LWQ
     * @Date 2023/11/29 12:40
     * @Param [s]
     * @return java.lang.String
     * @Description: 桶排序
     * 由于每个字符在字符串中出现的频率存在上限，因此可以使用桶排序的思想，根据出现次数生成排序后的字符串。具体做法如下：
     *
     * 遍历字符串，统计每个字符出现的频率，同时记录最高频率 maxFreq
     *
     * 创建桶，存储从 1 到 maxFreq 的每个出现频率的字符；
     *
     * 按照出现频率从大到小的顺序遍历桶，对于每个出现频率，获得对应的字符，然后将每个字符按照出现频率拼接到排序后的字符串。
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/sort-characters-by-frequency/solutions/855833/gen-ju-zi-fu-chu-xian-pin-lu-pai-xu-by-l-zmvy/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public String frequencySort2(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int maxFreq = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int frequency = map.getOrDefault(c, 0) + 1;
            map.put(c, frequency);
            maxFreq = Math.max(maxFreq, frequency);
        }
        StringBuffer[] buckets = new StringBuffer[maxFreq + 1];
        for (int i = 0; i <= maxFreq; i++) {
            buckets[i] = new StringBuffer();
        }

        // 二次容器存储，此时存储的数据为按出现次数存储
        // 相当于二次统计
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int frequency = entry.getValue();
            buckets[frequency].append(c);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = maxFreq; i > 0; i--) {
            StringBuffer bucket = buckets[i];
            int size = bucket.length();
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < i; k++) {
                    sb.append(bucket.charAt(j));
                }
            }
        }
        return sb.toString();
    }

    /**
     * @Author LWQ
     * @Date 2023/11/29 12:46
     * @Param [s]
     * @return java.lang.String
     * @Description: 优先队列
     * 具体做法如下：
     *
     * 先使用「哈希表」对词频进行统计；
     * 遍历统计好词频的哈希表，将每个键值对以 {字符,词频} 的形式存储到「优先队列（堆）」中。并规定「优先队列（堆）」排序逻辑为：
     * 如果 词频 不同，则按照 词频 倒序；
     * 如果 词频 相同，则根据 字符字典序 升序（由于本题采用 Special Judge 机制，这个排序策略随意调整也可以。但通常为了确保排序逻辑满足「全序关系」，这个地方可以写正写反，但理论上不能不写，否则不能确保每次排序结果相同）；
     * 从「优先队列（堆）」依次弹出，构造答案。
     *
     * 作者：宫水三叶
     * 链接：https://leetcode.cn/problems/sort-characters-by-frequency/solutions/855902/gong-shui-san-xie-shu-ju-jie-gou-yun-yon-gst9/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public String frequencySort3(String s) {
        char[] cs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : cs) map.put(c, map.getOrDefault(c, 0) + 1);
        // 自定义排列 comparator 的优先队列
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->{
            return a[1] != b[1] ? b[1] - a[1] : a[0] - b[0];
        });
        for (char c : map.keySet()) q.add(new int[]{c, map.get(c)});
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int c = poll[0], k = poll[1];
            while (k-- > 0) sb.append((char)(c));
        }
        return sb.toString();
    }
}
