package tag.string.subsequence;

/**
 * @Projectname: leetcode
 * @Filename: FindLongestWord_524_TODO
 * @Author: LWQ
 * @Data: 2023/12/16 10:19
 * @Description: medium
 */

import java.util.Arrays;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 *
 * 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 * 示例 2：
 *
 * 输入：s = "abpcplea", dictionary = ["a","b","c"]
 * 输出："a"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 1000
 * s 和 dictionary[i] 仅由小写英文字母组成
 */
public class FindLongestWord_524_TODO {

    public String findLongestWord(String s, List<String> dictionary) {
        return "";
    }

    public static void main(String[] args) {
        FindLongestWord_524_TODO target = new FindLongestWord_524_TODO();
        String s = "abpcplea";
        List<String> dictionary = Arrays.asList("ale","apple","monkey","plea");
        String result = target.findLongestWord(s, dictionary);
        System.out.println(result);
    }
}
