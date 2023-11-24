package arithmetic.easy;

/**
 * @Projectname: leetcode
 * @Filename: CountSegments_434
 * @Author: LWQ
 * @Data: 2023/11/22 13:28
 * @Description: easy
 */

/**
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 示例:
 *
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 */
public class CountSegments_434 {

    /**
     * 时间详情：0ms，击败 100.00%使用 Java 的用户
     * 内存详情：39.72MB，击败 5.24%使用 Java 的用户
     * @param s
     * @return
     */
    public int countSegments(String s) {
        String[] split = s.split(" ");
        int result = 0;
        for (int i = 0; i < split.length; i++) {
            if (split[i].length() > 0) {result++;}
        }
        return result;
    }

    public static void main(String[] args) {
        CountSegments_434 target = new CountSegments_434();
        String s = "Hello, my name is John";
        s=", , , ,        a, eaefa";
        s="";
        int result = target.countSegments(s);
        System.out.println(result);
    }

    public int countSegments2(String s) {
        int segmentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }

        return segmentCount;
    }
}
