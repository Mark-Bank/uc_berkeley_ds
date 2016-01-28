/* per lecture 9
 */

class IntBox{

  // as param x is passed by value (copied), its change only
  // occurs in its local, stack frame value
  // & ultimately, x's value is unaffected
  static void doNothing(int x) {
    x = 2;
  }

  public int i;

  // here the param ib is a reference. Therefore, while the 
  // parameter itself is copied, this only copies the reference.
  // the object the reference POINTS TO is not copied. So
  // the referenced object can be modified and the changes
  // will persist
  static void set3(IntBox ib) {
    ib.i = 3;
  }

  // here the copied param ib, which refers to an external object,
  // is changed to refer to a new, locally spawned IntBox object.
  // therefore, the change to the param's field are temporary; they
  // die when the method concludes
  static void badSet4(IntBox ib) {
    ib = new IntBox(4);
    ib.i = 4;
  }
}


/*

// invocation of doNothing()
// a maintains its value
int a = 1;
IntBox.doNothing(a);


// invocation of set3()
// b's i field DOES CHANGE
IntBox b = new IntBox();
set3(b);


// invocation of badSet4()
// b's i field DOES NOT CHANGE
IntBox b = new IntBox();
badSet4(b);

*/
