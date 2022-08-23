package arithmetic.easy;

import comm.TreeNode;

/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 
 *
 * 示例 1：
 *
 *
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 * 示例 3：
 *
 *
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 * 
 *
 * 提示：
 *
 * 两棵树上的节点数目都在范围 [0, 100] 内
 * -104 <= Node.val <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/same-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsSameTree_100 {

    /**
     * 需要同时处理左右节点，递归结束条件为走到最后一个节点
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }

    public static void main(String[] args) {
        IsSameTree_100 isSameTree_100 = new IsSameTree_100();
        TreeNode p = new TreeNode(1);
        TreeNode treeNodep0 = new TreeNode(2);
        TreeNode treeNodep1 = new TreeNode(3);
        p.left = treeNodep0;
        p.right = treeNodep1;
        TreeNode q = new TreeNode(1);
        TreeNode treeNodeq0 = new TreeNode(2);
        TreeNode treeNodeq1 = new TreeNode(3);
        TreeNode treeNodeq2 = new TreeNode(4);
        TreeNode treeNodeq3 = new TreeNode(5);
        q.left = treeNodeq0;
        q.right = treeNodeq1;
        treeNodep1.left = treeNodeq2;
        treeNodep1.right = treeNodeq3;

        boolean sameTree = isSameTree_100.isSameTree(p, q);
        System.out.println(sameTree);
    }
}
