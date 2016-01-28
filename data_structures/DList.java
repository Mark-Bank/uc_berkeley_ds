/* per lecture 8
 */

public class DListNode {
  Object item;
  DListNode next;
  DListNode prev;

  public DListNode(Object item, DListNode next) {
    this.item = item;
    this.next = next;
  }

  public DListNode(Object item) {
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

public class DList {
  private DListNode head;
  private DListNode tail;
  private int size;

  // a fantastic way to represent an empty SList, eh?
  public DList() {
    head = null;
    size = 0;
  }

  public void insertFront(Object item) {
    head = new SListNode(item, head);
    size++;
  }

  public void deleteFront() {
    if (head != null) {
      head = head.next;
      size--;
    }
  }
}
