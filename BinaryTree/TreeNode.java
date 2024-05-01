
public class TreeNode {
    // each node will have a question a left node and a right node,
    // if it is a final question then the left and right will be null
    String question;
    // yes to the left
    TreeNode left;
    // no to the right
    TreeNode right;
    public TreeNode(String q){
        question = q;
        right = null;
        left = null;
    }
}
