package arithmetic.easy;


import comm.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序遍历 。
 *
 * 
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 * 
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * 
 *
 * 进阶:递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InorderTraversal_94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        return null;
    }

    public static void main(String[] args) {
        InorderTraversal_94 inorderTraversal_94 = new InorderTraversal_94();
        TreeNode root = new TreeNode(1);
        TreeNode treeNode0 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(3);
        root.left = null;
        root.right = treeNode0;
        treeNode0.left = treeNode1;

        List<Integer> integers = inorderTraversal_94.inorderTraversal(root);
        System.out.println(integers);
    }
}
