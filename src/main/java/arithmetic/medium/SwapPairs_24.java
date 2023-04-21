package arithmetic.medium;

import comm.ListNode;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：[1]
 * 
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SwapPairs_24 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.4 MB, 在所有 Java 提交中击败了11.38%的用户
     * 通过测试用例：55 / 55
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode root = null;
        ListNode tempNode;
        ListNode current = head;
        ListNode lastNode = null;
        ListNode currentNode = null;
        int step = 0;

        // 没有节点 或 只有一个节点
        if (head == null || head.next == null) {
            return head;
        }

        while (current != null) {
            tempNode = current.next;

            /**
             *  记录当前的单个节点 currentNode
             *  每次将两个节点交换后再拼接至root最后一个节点lastNode后，并维护当前的root最后一个节点 lastNode
             */
            if ((++step & 2) == 2) {
                // 交换
                current.next = currentNode;
                currentNode = current;
                if (lastNode == null) {
                    root = currentNode;
                    lastNode = currentNode.next;
                } else {
                    lastNode.next = currentNode;
                    lastNode = currentNode.next;
                }
                step = 0;
            } else {
                // 放置在最后一位
                currentNode = current;
                currentNode.next = null;
            }

            current = tempNode;
        }

        // 最后一个未拼接的单个节点
        if ((step & 1) == 1) {
            lastNode.next = currentNode;
        }

        return root;
    }

    public static void main(String[] args) {
        SwapPairs_24 swapPairs_24 = new SwapPairs_24();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode listNode = swapPairs_24.swapPairs(head);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
