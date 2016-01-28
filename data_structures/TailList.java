/* per lecture 11
 */


public class TailList extends SList {
  // head and size inherited from SList

  private SListNode tail;

  // overriden method
  public void insertEnd(Object obj) {
    // insert solution to "lab 3" .....
  }

  // plenty of methods are simply inherited from SList and used as is
  

  public TailList() {
    // SList() sets size = 0, head = null
    //   (zero-param constructor of superclass called by default)
    //   ** if no zero-param constructor for superclass is defined, java complains
    
    tail = null;
  }

  public TailList(int x) {

    // superclass constructor explicit invocation
    // ** MUST BE 1st statement in constructor
    //    because of inherent dependency on initialized superclass instance
    
    super(x);

    // if superclass constructor invokes methods overwritten by subclass,
    //   (presumably) the subclass methods will be invoked

    tail = null;
  }

  // overrided method invocation example
  public void insertFront(Object obj) {

    // invocation needn't be 1st statement, unlike super's constructor
    super.insertFront(obj);

    if (size == 1) {
      tail = head;
    }
  }

}
