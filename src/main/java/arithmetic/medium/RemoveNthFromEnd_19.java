package arithmetic.medium;

import comm.ListNode;

/**
 * 给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * 
 *
 * 提示：
 *
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * 
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveNthFromEnd_19 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.8 MB, 在所有 Java 提交中击败了15.77%的用户
     * 通过测试用例：208 / 208
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode root = head;
        ListNode stepNode = head;
        ListNode current = head;
        int step = 0;

        while (current != null) {
            ListNode tempList = current.next;
            // 拿删除节点的前一个节点，便于移除
            if (++step > n + 1) {
                ListNode tempNode = stepNode.next;
                stepNode = tempNode;
            }

            current = tempList;
        }

        /**
         * 由于获取的是当前需要删除节点的前一个节点，stepNode == root 存在两种场景
         *  1. root.length = n
         *  2. root.length = n + 1
         *  即删除的是 第一个节点 或 第二个节点
         */
        if (stepNode == root && step < n + 1) {
            return root.next;
        }

        stepNode.next = stepNode.next.next;

        return root;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd_19 removeNthFromEnd_19 = new RemoveNthFromEnd_19();
        int n = 5;
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode listNode = removeNthFromEnd_19.removeNthFromEnd(head, n);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
