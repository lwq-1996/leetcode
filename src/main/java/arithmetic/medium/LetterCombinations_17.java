package arithmetic.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Projectname: leetcode
 * @Filename: LetterCombinations_17
 * @Author: LWQ
 * @Data:2023/1/5 10:09
 * @Description: leetcode_practice
 * 
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * 
 *
 * 提示：
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LetterCombinations_17 {

    /**
     * 执行用时：5 ms, 在所有 Java 提交中击败了17.23%的用户
     * 内存消耗：40.1 MB, 在所有 Java 提交中击败了53.40%的用户
     * 通过测试用例：25 / 25
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        List<String> resultString = backTracking(mapping, digits, 0, result);

        return resultString;
    }

    public List<String> backTracking(String[] mapping, String digits, int current, List<String> result) {
        if (current == digits.length()) {
            return result;
        }

        List<String> finResult = new ArrayList<>();
        // 处理数据
        String currentCharacter = mapping[digits.charAt(current) - '0'];

        for (int i = 0; i < currentCharacter.length(); i++) {
            if (result.isEmpty()) {
                finResult.add(currentCharacter.charAt(i) + "");
                continue;
            }
            for (String resultCharacter : result) {
                finResult.add(resultCharacter + currentCharacter.charAt(i));
            }
        }

        // 回溯
        List<String> resultString = backTracking(mapping, digits, current + 1, finResult);
        return resultString;
    }

    public static void main(String[] args) {
        LetterCombinations_17 letterCombinations_17 = new LetterCombinations_17();
        String digits = "23";
        List<String> result = letterCombinations_17.letterCombinations2(digits);
        for (String s : result) {
            System.out.print(s + "、");
        }
    }


    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：40 MB, 在所有 Java 提交中击败了70.32%的用户
     * 通过测试用例：25 / 25
     */
    //设置全局列表存储最后的结果
    List<String> list = new ArrayList<>();

    public List<String> letterCombinations2(String digits) {
        if (digits == null || digits.length() == 0) {
            return list;
        }
        //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //迭代处理
        backTracking(digits, numString, 0);
        return list;

    }

    //每次迭代获取一个字符串，所以会设计大量的字符串拼接，所以这里选择更为高效的 StringBuild
    StringBuilder temp = new StringBuilder();

    //比如digits如果为"23",num 为0，则str表示2对应的 abc
    public void backTracking(String digits, String[] numString, int num) {
        //遍历全部一次记录一次得到的字符串
        if (num == digits.length()) {
            list.add(temp.toString());
            return;
        }
        //str 表示当前num对应的字符串
        String str = numString[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            //c
            backTracking(digits, numString, num + 1);
            //剔除末尾的继续尝试
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
