/* per lecture 7, 8, 10
 */

public class SListNode {
  Object item;
  SListNode next;

  public SListNode(Object item, SListNode next) {
    this.item = item;
    this.next = next;
  }

  public SListNode(Object item) {
    this(item, null); // constructor call
  }

  public void insertAfter(Object item) {
    next = new SListNode(item, next); // note the differences in next
                                      // given its place on both sides of asgn. op.
                                      // (old val used in constructor, new val
                                      //  pulled from constructor's resultant obj.)
  }

  public SListNode nth(int position) {
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

  public void deleteFront() {
    if (head != null) {
      head = head.next;
      size--;
    }
  }

  public boolean equals(SList other) {
    if (size != other.size) {
      return false;
    }

    SListNode n1 = head;
    SListNode n2 = other.head;

    while (n1 != null) {
      if (! n1.item.equals(n2.item)) {
        return false;
      }

      n1 = n1.next;
      n2 = n2.next;
    }

    return true;
  }
}
