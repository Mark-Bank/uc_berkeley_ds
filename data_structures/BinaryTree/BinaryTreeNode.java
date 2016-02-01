/* per lecture 25
 */

public class BinaryTreeNode {
  Entry item;
  BinaryTreeNode parent;
  BinaryTreeNode left;
  BinaryTreeNode right;

  public void inOrder() {

    if (left != null) {
      left.inOrder();
    }

    this.visit();

    if (right != null) {
      right.inOrder();
    }
  }

}
