import java.util.*;

public class TreeSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(2);

        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;

        System.out.println(getTreeSum(root));



    }

    public static int getTreeSum(TreeNode root) {
        if (root == null) return 0;

        List<Integer> list = new ArrayList<Integer>();
        helper(root, 0, list);

        int rst = 0;
        for (int num: list) rst += num;
        return rst;
    }

    public static void helper(TreeNode root, int curt, List<Integer> list) {
        curt += root.val;
        if (root.left == null && root.right == null) {
            list.add(curt);
            return;
        }

        if (root.left != null) helper(root.left, curt * 10, list);
        if (root.right != null) helper(root.right, curt * 10, list);
    }

}
