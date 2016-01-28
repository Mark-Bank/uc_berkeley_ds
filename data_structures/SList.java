/* per lecture 7
 */

public class SListNode {
  Object item;
  ListNode next;

  public ListNode(Object item, ListNode next) {
    this.item = item;
    this.next = next;
  }

  public ListNode(Object item) {
    this(item, null); // constructor call
  }

  public void insertAfter(Object item) {
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

public class SList {
  private SListNode head;
  private int size;

  // a fantastic way to represent an empty SList, eh?
  public SList() {
    head = null;
    size = 0;
  }

  public void insertFront(Object item) {
    head = new SListNode(item, head);
    size++;
  }
}
