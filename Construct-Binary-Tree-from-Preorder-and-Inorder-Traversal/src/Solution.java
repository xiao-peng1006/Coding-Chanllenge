import java.util.HashMap;
import java.util.Map;

public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int[] preorder;
    int[] inorder;
    int pre_index;

    // 使用value作为key, index作为value
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        this.pre_index = 0;
        int index = 0;
        for (int val:inorder) {
            map.put(val, index++);
        }
        return helper(0, inorder.length);

    }

    public TreeNode helper(int left, int right) {
        if (left == right) {
            return null;
        }
        int root_val = preorder[pre_index];
        TreeNode root = new TreeNode(root_val);

        // 通过root_val从map中查找index, 然后左右子树分别recursion
        int index = map.get(root_val);
        pre_index++;
        root.left = helper(left, index);
        root.right = helper(index + 1, right);
        return root;
    }

    public static void main(String[] args) {

    }
}
