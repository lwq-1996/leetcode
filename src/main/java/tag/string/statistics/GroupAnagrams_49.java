package tag.string.statistics;

/**
 * @Projectname: leetcode
 * @Filename: GroupAnagrams_49
 * @Author: LWQ
 * @Data: 2023/11/25 13:05
 * @Description: medium
 */

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 *
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 *
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *
 *
 * 提示：
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 */
public class GroupAnagrams_49 {

    /**
     * 超时：
     *
     * @Author LWQ
     * @Date 2023/11/28 13:16
     * @Param [strs]
     * @return java.util.List<java.util.List<java.lang.String>>
     * @Description: 排序
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        int length = strs.length;
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            // 统计过不重复统计
            if (strs[i] == null) {
                continue;
            }
            List<String> col = new ArrayList<>();
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String string = String.valueOf(charArray);
            col.add(strs[i]);
            strs[i] = null;
            for (int j = i+1; j < length; j++) {
                // 统计过不重复统计
                if (strs[j] == null) {
                    continue;
                }
                char[] charArray1 = strs[j].toCharArray();
                Arrays.sort(charArray1);
                String string1 = String.valueOf(charArray1);
                if (string.equals(string1)) {
                    col.add(strs[j]);
                    // 统计后标记
                    strs[j] = null;
                }
            }

            // 当前字符统计结束，加入结果集
            result.add(col);
        }
        return result;
    }

    /**
     * 通过：
     * 时间详情：6ms，击败 80.89%使用 Java 的用户
     * 内存详情：46.10MB，击败 14.89%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/11/28 13:32
     * @Param [strs]
     * @return java.util.List<java.util.List<java.lang.String>>
     * @Description: 排序，使用额外空间map存储结果
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String var0 = String.valueOf(charArray);
            List<String> list = map.get(var0);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(str);
            map.put(var0, list);
        }

        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            result.add(map.get(iterator.next()));
        }
        return result;
    }

    /**
     * 通过：
     * 时间详情：12ms，击败 17.38%使用 Java 的用户
     * 内存详情：46.32MB，击败 9.35%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/11/28 13:33
     * @Param [strs]
     * @return java.util.List<java.util.List<java.lang.String>>
     * @Description: 计数，将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
     */
    public List<List<String>> groupAnagrams3(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            char[] count = new char[26];
            for (char var0 : charArray) {
                count[var0 - 'a']++;
            }

            for (int i = 0; i < count.length; i++) {
                char var1 = count[i];
                if (var1 != 0) {
                    stringBuilder.append(var1 + 'a');
                    stringBuilder.append(i);
                }
            }
            List<String> list = map.getOrDefault(stringBuilder.toString(), new ArrayList<>());
            list.add(str);
            map.put(stringBuilder.toString(), list);
            stringBuilder.setLength(0);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams_49 target = new GroupAnagrams_49();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = target.groupAnagrams3(strs);
        for (List<String> var0 : result) {
            System.out.println(var0);
        }
    }
}
