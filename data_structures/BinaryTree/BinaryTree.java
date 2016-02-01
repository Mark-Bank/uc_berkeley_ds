/* per lecture 25
 */

public class BinaryTree {
  BinaryTreeNode root;
  int size;

  public Object find(Object k) {

    BinaryTreeNode node = root;

    while (node != null) {
      int comp = ((Comparable) k).compareTo(node.entry.key());
      if (comp < 0) {
        node = node.left;
      } else if (comp > 0) {
        node = node.right;
      } else {
        return node.entry;
      }
    }
    return null;
}
