package arithmetic.easy;

/**
 * @Projectname: leetcode
 * @Filename: CanConstruct_383
 * @Author: LWQ
 * @Data: 2023/11/25 13:00
 * @Description: easy
 */

/**
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 *
 * 如果可以，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 *
 *
 * 示例 1：
 *
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 *
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 *
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 *
 *
 * 提示：
 *
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote 和 magazine 由小写英文字母组成
 */
public class CanConstruct_383 {

    /**
     * 通过：
     * 时间详情：1ms，击败 99.87%使用 Java 的用户
     * 内存详情：42.85MB，击败 35.95%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/11/28 12:41
     * @Param [ransomNote, magazine]
     * @return boolean
     * @Description: 计数
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        char[] ranArr = ransomNote.toCharArray();
        char[] magArr = magazine.toCharArray();
        for (char mag : magArr) {
            arr[mag - 'a']++;
        }
        for (char ran : ranArr) {
            arr[ran - 'a']--;
        }
        for (int count : arr) {
            if (count < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CanConstruct_383 target = new CanConstruct_383();
        String ransomNote = "a";
        String magazine = "b";
        boolean result = target.canConstruct(ransomNote, magazine);
        System.out.println(result);
    }
}
