package arithmetic.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Projectname: leetcode
 * @Filename: IsIsomorphic_205
 * @Author: LWQ
 * @Data:2022/11/20 19:51
 * @Description: leetcode_practice
 * 
 * 
 * 给定两个字符串s和t，判断它们是否是同构的。
 *
 * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
 *
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 *
 * 示例 1:
 *
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 示例 3：
 *
 * 输入：s = "paper", t = "title"
 * 输出：true
 *
 * 提示：
 *
 * 1 <= s.length <= 5 * 104
 * t.length == s.length
 * s和t由任意有效的 ASCII 字符组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class IsIsomorphic_205 {

    /**
     * 执行用时：22 ms, 在所有 Java 提交中击败了33.27%的用户
     * 内存消耗：41.6 MB, 在所有 Java 提交中击败了18.04%的用户
     * 通过测试用例：44 / 44
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> maps = new HashMap<>((int)(s.length()/0.75 + 1));
        Map<Character, Character> mapt = new HashMap<>((int)(s.length()/0.75 + 1));

        for (int i = 0; i < s.length(); i++) {
            if (maps.get(s.charAt(i)) == null) {
                maps.put(s.charAt(i), t.charAt(i));
            }
            if (mapt.get(t.charAt(i)) == null) {
                mapt.put(t.charAt(i), s.charAt(i));
            }
            if (!maps.get(s.charAt(i)).equals(t.charAt(i)) || !mapt.get(t.charAt(i)).equals(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsIsomorphic_205 isIsomorphic_205 = new IsIsomorphic_205();
        String s = "badc";
        String t = "baba";

        boolean isomorphic = isIsomorphic_205.isIsomorphic(s, t);
        System.out.println(isomorphic);
    }

    /**
     * 通过map的 k-v 解决
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic2(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                if(map.containsValue(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }else{
                if(map.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }
        }

        return true;
    }
}
