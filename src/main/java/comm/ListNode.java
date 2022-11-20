package comm;

/**
 *      ListNode root = new ListNode(0);
 *      ListNode current = root;
 *
 *      while(){
 *          // 此处将 root节点的 next设置为 temp
 *          current.next = temp;
 *          // 此处将 current节点设置到 root节点的 next，即两行代码运行后，将 root的 next设置为 temp，current指向 root.next!
 *          current = temp;
 *      }
 *
 *      参数初始化：
 *          int[] nodes = {1,2,6,3,4,5,6};
 *         ListNode head = null;
 *         ListNode current = head;
 *         for (int i = 0; i < nodes.length; i++) {
 *             if (i == 0) {
 *                 head = new ListNode(nodes[i]);
 *                 current = head;
 *                 continue;
 *             }
 *             current.next = new ListNode(nodes[i]);
 *             current = current.next;
 *         }
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
