package offer;

/**
 * <a href=https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof>剑指 Offer 26. 树的子结构</a>
 *
 * @Author phoebe
 * @date 2023/3/12
 */
public class Offer_26_IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 空树不是任何树的子结构
        if (A == null || B == null) {
            return false;
        }
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean dfs(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        return A.val == B.val && dfs(A.left, B.left) && dfs(A.right, B.right);
    }
}
