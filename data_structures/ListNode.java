/* per lecture 7
 */

public class ListNode {
  int item;
  ListNode next;

  public ListNode(int item, ListNode next) {
    this.item = item;
    this.next = next;
  }

  public ListNode(int item) {
    this(item, null); // constructor call
  }

  public void insertAfter(int item) {
    next = new ListNode(item, next); // note the differences in next
                                     // given its place on both sides of asgn. op.
                                     // (old val used in constructor, new val
                                     //  pulled from constructor's resultant obj.)
  }

  public ListNode nth(int position) {
    if (position == 1) {
      return this;
    } else if ((position < 1) || (next == null)) {
      return null;
    } else {
      return next.nth(position - 1);
    }
}
