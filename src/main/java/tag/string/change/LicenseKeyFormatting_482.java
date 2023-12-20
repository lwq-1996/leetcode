package tag.string.change;

/**
 * @Projectname: leetcode
 * @Filename: LicenseKeyFormatting_482_TODO
 * @Author: LWQ
 * @Data: 2023/12/16 10:38
 * @Description: easy
 */

/**
 * 给定一个许可密钥字符串 s，仅由字母、数字字符和破折号组成。字符串由 n 个破折号分成 n + 1 组。你也会得到一个整数 k 。
 *
 * 我们想要重新格式化字符串 s，使每一组包含 k 个字符，除了第一组，它可以比 k 短，但仍然必须包含至少一个字符。此外，两组之间必须插入破折号，并且应该将所有小写字母转换为大写字母。
 *
 * 返回 重新格式化的许可密钥 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：S = "5F3Z-2e-9-w", k = 4
 * 输出："5F3Z-2E9W"
 * 解释：字符串 S 被分成了两个部分，每部分 4 个字符；
 *      注意，两个额外的破折号需要删掉。
 * 示例 2：
 *
 * 输入：S = "2-5g-3-J", k = 2
 * 输出："2-5G-3J"
 * 解释：字符串 S 被分成了 3 个部分，按照前面的规则描述，第一部分的字符可以少于给定的数量，其余部分皆为 2 个字符。
 *
 *
 * 提示:
 *
 * 1 <= s.length <= 105
 * s 只包含字母、数字和破折号 '-'.
 * 1 <= k <= 104
 */
public class LicenseKeyFormatting_482 {

    /**
     * 通过：
     * 时间详情：36ms，击败 22.72%使用 Java 的用户
     * 内存详情：42.32MB，击败 82.92%使用 Java 的用户
     *
     * @Author LWQ
     * @Date 2023/12/17 16:36
     * @Param [s, k]
     * @return java.lang.String
     * @Description: API战士
     */
    public String licenseKeyFormatting(String s, int k) {
        String replace = s.replace("-", "").toUpperCase();
        int len = replace.length();
        StringBuilder result = new StringBuilder(replace);
        for (int i = len-k; i > 0; i-=k) {
            result.insert(i, "-");
        }
        return result.toString();
    }

    public String licenseKeyFormatting2(String s, int k) {
        char[] charArray = s.toCharArray();
        StringBuilder result = new StringBuilder();
        int count = k;
        for (int i = charArray.length-1; i >= 0; i--) {
            char c = charArray[i];
            if (c == '-') {
                continue;
            }

            if (Character.isLowerCase(c)) {
                c = Character.toUpperCase(c);
            }
            result.append(c);

            count--;
            if (count == 0) {
                result.append("-");
                count = k;
            }
        }

        // 头部的 "-"
        if (result.lastIndexOf("-") == result.length()-1) {
            result.delete(result.length()-1, result.length());
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        LicenseKeyFormatting_482 target = new LicenseKeyFormatting_482();
        String s = "5F3Z-2e-9-w";
        int k = 4;
        String result = target.licenseKeyFormatting2(s, k);
        System.out.println(result);
    }
}
