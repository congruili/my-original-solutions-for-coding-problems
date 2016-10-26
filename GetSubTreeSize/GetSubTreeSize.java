// http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=206950&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D2%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D1%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

public class GetSubTreeSize {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        TreeNode a = new TreeNode(12);
        TreeNode b = new TreeNode(20);
        TreeNode c = new TreeNode(10);
        TreeNode d = new TreeNode(13);
        TreeNode e = new TreeNode(18);
        TreeNode f = new TreeNode(31);

        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;

        Result rootR = getTree(root);

        System.out.println(getSize(19, 31, rootR));

    }

    public static int getSize(int A, int B, Result rootR) {
        if (rootR == null) return 0;
        if (A > rootR.end || B < rootR.start) return 0;
        if (A <= rootR.start && rootR.end <= B) return rootR.count;
        if (A > rootR.start) return getSize(A, B, rootR.right);
        return getSize(A, B, rootR.left);
    }

    public static Result getTree(TreeNode root) {
        if (root == null) return null;
        Result rootR = new Result(root.val, root.val);

        if (root.left != null) {
            rootR.left = getTree(root.left);
            rootR.count += rootR.left.count;
            rootR.start = rootR.left.start;
        }

        if (root.right != null) {
            rootR.right = getTree(root.right);
            rootR.count += rootR.right.count;
            rootR.end = rootR.right.end;
        }

        return rootR;
    }
}
