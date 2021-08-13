import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathSumII113 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        checkPath(root, new ArrayList<>(), 0, targetSum);
        return result;
    }
    public void checkPath(TreeNode path, List<Integer> listPath, int sum, int targetSum) {
        if(path == null) return;
        listPath.add(path.val);
        if(path.left == null && path.right == null && sum + path.val == targetSum) {
            result.add(listPath);
            return;
        }
        checkPath(path.left, new ArrayList<>(listPath), sum + path.val, targetSum);
        checkPath(path.right, new ArrayList<>(listPath), sum + path.val, targetSum);
    }

    public static void main(String[] args) {
        PathSumII113 obj = new PathSumII113();
        TreeNode treeNode = new TreeNode(5, new TreeNode(4,new TreeNode(11,new TreeNode(7), new TreeNode(2)),null), new TreeNode(8,new TreeNode(13),new TreeNode(4,new TreeNode(5),new TreeNode(1))));
//        TreeNode treeNode = new TreeNode(-2, null, new TreeNode(-3));
        List<List<Integer>> r = obj.pathSum( treeNode, 22);
        System.out.println(r);
    }

}
