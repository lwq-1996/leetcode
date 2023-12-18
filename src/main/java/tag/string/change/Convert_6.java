package tag.string.change;

/**
 * @Projectname: leetcode
 * @Filename: Convert_6_TODO
 * @Author: LWQ
 * @Data: 2023/12/16 10:40
 * @Description: medium
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 *
 * 示例 1：
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 *
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 */
public class Convert_6 {

    /**
     * 通过：
     * 时间详情：8ms，击败 45.90%使用 Java 的用户
     * 内存详情：43.52MB，击败 21.89%使用 Java 的用户
     *
     * @param s
     * @param numRows
     * @return
     * @desception：使用额外空间记录中间结果
     */
    public String convert(String s, int numRows) {
        Map<Integer, StringBuilder> map = new HashMap<>((int) (numRows/0.75 + 1));
        int len = s.length();
        // true-从上往下 false-从下网上
        // 兼容第一次，从false开始
        boolean up = false;
        int cur = 1;
        for (int i = 0; i < len; i++) {
            map.put(cur, map.getOrDefault(cur, new StringBuilder()).append(s.charAt(i)));
            if (cur == 1 || cur == numRows) {
                up = !up;
            }
            int z = up ? cur++ : cur--;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= map.size(); i++) {
            result.append(map.get(i));
        }
        return result.toString();
    }

    /**
     *
     * @param s
     * @param numRows
     * @return
     * @desceptionn：找规律，找出每个数的位置
     */
    public String convert2(String s, int numRows) {
        StringBuilder result = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 1; i <= numRows; i++) {
            for (int j = 1; j <= chars.length; j++) {
                if ((j-i) % (2*numRows-2) == 0) {
                    // 从1开始遍历的
                    result.append(chars[j-1]);
                }
                // 中间
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Convert_6 target = new Convert_6();
        String s = "PAYPALISHIRING";
//        s = "A";
        int numRows = 3;
        String result = target.convert2(s, numRows);
        System.out.println(result);
    }

    /**
     * @param s
     * @param numRows
     * @return
     * @desception：空间压缩
     */
    public String convert3(String s, int numRows) {
        int n = s.length(), r = numRows;
        if (r == 1 || r >= n) {
            return s;
        }
        StringBuffer[] mat = new StringBuffer[r];
        for (int i = 0; i < r; ++i) {
            mat[i] = new StringBuffer();
        }
        for (int i = 0, x = 0, t = r * 2 - 2; i < n; ++i) {
            mat[x].append(s.charAt(i));
            if (i % t < r - 1) {
                ++x;
            } else {
                --x;
            }
        }
        StringBuffer ans = new StringBuffer();
        for (StringBuffer row : mat) {
            ans.append(row);
        }
        return ans.toString();
    }

    public String convert4(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) flag = - flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }
}
