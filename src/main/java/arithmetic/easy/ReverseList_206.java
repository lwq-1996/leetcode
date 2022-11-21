package arithmetic.easy;

import comm.ListNode;

import java.util.Stack;

/**
 * @Projectname: leetcode
 * @Filename: ReverseList_206
 * @Author: LWQ
 * @Data:2022/11/20 22:51
 * @Description: leetcode_practice
 *
 *
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 *
 *
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *
 * 提示：
 *
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 *
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class ReverseList_206 {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode root = null;
        ListNode current = head;

        while (current != null) {
            ListNode tempList = current.next;
            current.next = root;
            root = current;
            current = tempList;
        }

        return root;
    }

    public static void main(String[] args) {
        ReverseList_206 reverseList_206 = new ReverseList_206();
        int[] nodes = {1,2,3,4,5};
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

        ListNode listNode = reverseList_206.reverseList(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 迭代方法
     * 1 -> 2 -> 3 -> 4 -> null
     * null <- 1 <- 2 <- 3 <- 4
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        ListNode prev = null; //前指针节点
        ListNode curr = head; //当前指针节点
        //每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
        while (curr != null) {
            ListNode nextTemp = curr.next; //临时节点，暂存当前节点的下一节点，用于后移
            curr.next = prev; //将当前节点指向它前面的节点
            prev = curr; //前指针后移
            curr = nextTemp; //当前指针后移
        }
        return prev;
    }

    //迭代法
    public ListNode reverseList3(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //尾递归
    public ListNode reverseList4(ListNode head) {
        return reverse(null,head);
    }

    private static ListNode reverse(ListNode pre,ListNode cur){
        if(cur==null) return pre;
        ListNode next = cur.next;
        cur.next = pre;
        return reverse(cur,next);
    }
}
