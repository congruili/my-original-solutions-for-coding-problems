// http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=206451&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D2%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D1%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

import java.util.*;

public class MinString {

    public static void main(String[] args) {
        TreeNode root = new TreeNode('a');
        TreeNode l1 = new TreeNode('b');
        TreeNode r1 = new TreeNode('c');
        TreeNode l2 = new TreeNode('d');
        TreeNode r2 = new TreeNode('e');
        TreeNode l3 = new TreeNode('f');
        TreeNode r3 = new TreeNode('g');


        root.left = l1;
        root.right = r1;
        l1.left = l2;
        l1.right = r2;
        r1.left = l3;
        r1.right = r3;


        System.out.println(minString(root));

    }

    public static String minString(TreeNode root) {
        if (root == null) return "";
        List <String> rst = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        helper(sb, root, rst);

        Collections.sort(rst);
        return rst.get(0);
    }


    public static void helper(StringBuilder sb, TreeNode root, List<String> rst) {
        sb.append(root.val);

        if (root.left == null && root.right == null) {
            rst.add(sb.reverse().toString());
            return;
        }

        if (root.left != null) helper(sb, root.left, rst);
        if (root.right != null) helper(sb, root.right, rst);


        sb.deleteCharAt(sb.length() - 1);
    }
}
