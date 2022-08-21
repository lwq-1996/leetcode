package arithmetic.easy;

import comm.ListNode;

/**
 * 给定一个已排序的链表的头head，删除所有重复的元素，使每个元素只出现一次。返回 已排序的链表。
 *
 * 
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 示例 2：
 *
 *
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *
 * 提示：
 *
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeleteDuplicates_83 {

    /**
     * 执行结果： 通过
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：41 MB, 在所有 Java 提交中击败了58.38%的用户
     * 通过测试用例：166 / 166
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode root = new ListNode(0);
        ListNode current = root;
        int val = head.val;
        while (head != null) {
            if (head.next == null || val != head.next.val) {
                current.next = head;
                current = head;
                if (head.next != null){
                    val = head.next.val;
                }
            }
            head = head.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        DeleteDuplicates_83 deleteDuplicates_83 = new DeleteDuplicates_83();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        ListNode listNode = deleteDuplicates_83.deleteDuplicates(head);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 递归写法
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        head.next = deleteDuplicates2(head.next);
        if(head.val == head.next.val) head = head.next;
        return head;
    }
}
