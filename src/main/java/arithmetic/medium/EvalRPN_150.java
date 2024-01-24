package arithmetic.medium;

/**
 * @Projectname: leetcode
 * @Filename: EvalRPN_150_TODO
 * @Author: LWQ
 * @Data: 2024/1/13 14:52
 * @Description: medium
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 *
 * 请你计算该表达式。返回一个表示表达式值的整数。
 *
 * 注意：
 *
 * 有效的算符为 '+'、'-'、'*' 和 '/' 。
 * 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
 * 两个整数之间的除法总是 向零截断 。
 * 表达式中不含除零运算。
 * 输入是一个根据逆波兰表示法表示的算术表达式。
 * 答案及所有中间计算结果可以用 32 位 整数表示。
 *
 *
 * 示例 1：
 *
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * 示例 2：
 *
 * 输入：tokens = ["4","13","5","/","+"]
 * 输出：6
 * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 * 示例 3：
 *
 * 输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * 输出：22
 * 解释：该算式转化为常见的中缀算术表达式为：
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 *
 * 提示：
 *
 * 1 <= tokens.length <= 104
 * tokens[i] 是一个算符（"+"、"-"、"*" 或 "/"），或是在范围 [-200, 200] 内的一个整数
 *
 *
 * 逆波兰表达式：
 *
 * 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
 *
 * 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
 * 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
 * 逆波兰表达式主要有以下两个优点：
 *
 * 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
 * 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中
 */
public class EvalRPN_150 {

    /**
     * 通过：
     * 时间详情：4ms，击败 95.88%使用 Java 的用户
     * 内存详情：43.70MB，击败 5.08%使用 Java 的用户
     *
     * @param tokens
     * @return
     * @desception：模拟
     *  使用额外空间 -栈
     */
    public int evalRPN(String[] tokens) {
        int len = tokens.length;
//        Stack<Integer> stack = new Stack<>();
        Deque<Integer> deque = new ArrayDeque();
        for (int i = 0; i < len; i++) {
            switch (tokens[i]) {
                case "+":
                    deque.add(deque.pollLast() + deque.pollLast());
                    break;
                case "-":
                    deque.add(-deque.pollLast() + deque.pollLast());
                    break;
                case "*":
                    deque.add(deque.pollLast() * deque.pollLast());
                    break;
                case "/":
                    deque.add((int)((1/(double)deque.pollLast()) * deque.pollLast()));
                    break;
                default:
                    deque.add(Integer.valueOf(tokens[i]));
            }
        }
        return deque.pop();
    }

    public static void main(String[] args) {
        EvalRPN_150 target = new EvalRPN_150();
        String[] tokens = new String[]{"4","13","5","/","+"};
        int result = target.evalRPN(tokens);
        System.out.println(result);
    }

    /**
     * @param tokens
     * @return
     * @desception：数组模拟栈
     */
    public int evalRPN2(String[] tokens) {
        int n = tokens.length;
        int[] stack = new int[(n + 1) / 2];
        int index = -1;
        for (int i = 0; i < n; i++) {
            String token = tokens[i];
            switch (token) {
                case "+":
                    index--;
                    stack[index] += stack[index + 1];
                    break;
                case "-":
                    index--;
                    stack[index] -= stack[index + 1];
                    break;
                case "*":
                    index--;
                    stack[index] *= stack[index + 1];
                    break;
                case "/":
                    index--;
                    stack[index] /= stack[index + 1];
                    break;
                default:
                    index++;
                    stack[index] = Integer.parseInt(token);
            }
        }
        return stack[index];
    }
}
