/* per lecture 9
 */

public static final int FAILURE = -1;

private static int bsearch(int[] i, int left, int right, int findMe) {

  if (left > right) {
    return FAILURE;
  }

  int mid = (left + right) / 2;

  if (findMe == i[mid]) {
    return mid;
  } else if (findMe < i[mid]) {
    return bsearch(i, left, mid - 1, findMe);
  } else {
    return bsearch(i, mid + 1, right, findMe);
  }
}

public static int bsearch(int[] i, int findMe) {
  bsearch(i, 0, i.length - 1, findMe);
}
