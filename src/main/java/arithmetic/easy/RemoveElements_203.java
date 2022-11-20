package arithmetic.easy;

import comm.ListNode;

/**
 * @Projectname: leetcode
 * @Filename: RemoveElements_203
 * @Author: LWQ
 * @Data:2022/11/20 15:52
 * @Description: leetcode_practice
 * 
 * 
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * 
 *
 * 示例 1：
 *
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 *
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 * 
 * 提示：
 *
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-linked-list-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class RemoveElements_203 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了53.47%的用户
     * 内存消耗：42 MB, 在所有 Java 提交中击败了90.22%的用户
     * 通过测试用例：66 / 66
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode root = new ListNode();
        ListNode current = root;

        while (head != null) {
            if (head.val == val) {
                head = head.next;
                // 此处current.next = head，处理尾节点与数值匹配的情况
                current.next = head;
                continue;
            }

            current.next = head;
            current = current.next;
            head = head.next;
        }

        return root.next;
    }

    public static void main(String[] args) {
        RemoveElements_203 removeElements_203 = new RemoveElements_203();
        int[] nodes = {1,2,6,3,7,4,5,6,7,7};
        int[] nodes2 = {7,7,7,7};
        ListNode head = null;
        ListNode current = head;
        for (int i = 0; i < nodes.length; i++) {
            if (i == 0) {
                head = new ListNode(nodes[i]);
                current = head;
                continue;
            }
            current.next = new ListNode(nodes[i]);
            current = current.next;
        }

        ListNode listNode = removeElements_203.removeElements(head, 7);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}
