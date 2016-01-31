/* per lecture 22
 * a naive hashTable to demonstrate a good hash for Strings
 */

import java.util.List;
import java.util.LinkedList;


public class HashStrings {
  private static final int BUCKET_NUM  = 5;
  private static final int LARGE_PRIME = 16908799;

  public static int main(String[] args) {

    List<Entry>[] hashTable = new LinkedList<Entry>[5];

    for (List<Entry> chain : hashTable) {
      chain = new LinkedList<Entry>();
    }

    for (String s : args) {
      int hashCode = hashCode(s);
      hashCode = compressionFunction(hashCode);

      Entry e = Entry(s, s + " hashed to " + hashCode);

      List<Entry> bucket = hashTable[hashCode];
      bucket.add(e);
    }

    for (List<Entry> chain : hashTable) {
      System.out.println("new chain:");

      for (Entry e : chain) {
        System.out.println("  key " + e.getVal());
      }

    }

  }

  // as mentioned in the first ~10 minutes
  private static int hashCode(String key) {
    int hashVal = 0;

    for (char c : key) {
      hashVal = (127 * hashVal + c) % LARGE_PRIME;
    }

    return hashVal;
  }

  private static int compressionFunction(int hashCode) {
    return hashCode % BUCKET_NUM;
  }


  private class Entry {
    private String key;
    private String val;

    Entry(String key, String val) {
      this.key = key;
      this.val = val;
    }

    public String getKey() { return key; }

    public String getVal() { return val; }

  }


}
