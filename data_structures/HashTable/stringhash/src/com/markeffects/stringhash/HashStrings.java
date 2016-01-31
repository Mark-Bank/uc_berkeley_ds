/* per lecture 22
 * a simple hashTable to demonstrate a good hash for Strings
 * that does not support duplicate key entries
 */

package com.markeffects.stringhash;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;


public class HashStrings {
  // number of data points / number of buckets
  private static final double LOAD_FACTOR = 0.8;
  // for hashing purposes
  private static final int LARGE_PRIME = 16908799;

  private static final String IN_FILE = "resources/message.txt";

  public static void main(String[] args) throws IOException {

    File inFile = new File(IN_FILE);
    String[] myArgs = deserializeString(inFile).split("\\s+");

    int BUCKET_NUM = (int) (myArgs.length / LOAD_FACTOR);


    List<List<Entry>> hashTable = new ArrayList<>(BUCKET_NUM);

    // bug: there are no elements in hashTable yet to iterate over
    //      additionally, wasn't making use of "type inference for generic instance creation"
    /*
    for (List<Entry> chain : hashTable) {
      chain = new LinkedList<Entry>();
    }
    */

    for (int i = 0; i < BUCKET_NUM; i++) {
      List<Entry> chain = new LinkedList<>();
      hashTable.add(chain);
    }

    for (String s : myArgs) {
      int hashCode = hashCode(s);
      hashCode = compressionFunction(hashCode, BUCKET_NUM);

      Entry e = new Entry(s, Integer.toString(hashCode));

      if (s.equals("and")) {
        boolean duplicateCandidate = true;
      }

      List<Entry> bucket = hashTable.get(hashCode);
      if (! (bucket.contains(e))) {
        bucket.add(e);
      }
    }

    printTable(hashTable);

    /*
    for (List<Entry> chain : hashTable) {
      System.out.println("chain of length " + chain.size());

      for (Entry e : chain) {
        System.out.print("  key " + "\"" + e.getKey() + "\"");
        System.out.println(" hashed to " + e.getVal());
      }

    }
    */
  }

  // as mentioned in the first ~10 minutes
  private static int hashCode(String key) {
    int hashVal = 0;

    for (char c : key.toCharArray()) {
      hashVal = (127 * hashVal + c) % LARGE_PRIME;
    }

    return hashVal;
  }

  // as mentioned in the first ~10 minutes
  private static int compressionFunction(int hashCode, int BUCKET_NUM) {
    return hashCode % BUCKET_NUM;
  }


  private static void printTable(List<List<Entry>> hashTable) {
    int minSize = Integer.MAX_VALUE;
    int maxSize = Integer.MIN_VALUE;
    /*
    int[] ints = {0, 1, 9, 10, 11};
    for(int num : ints) {
      System.out.println("num: " + num + " digits: " + ((int) Math.log10(num)));
    }
    */

    int maxBucketStrLength = (int) (Math.log10(hashTable.size())) + 1;
    //System.out.println("maxBucketStrLength = " + maxBucketStrLength);

    for(int i = 0; i < hashTable.size(); i++) {
      int bucketStrLength = (i == 0) ? 1 : (int) (Math.log10(i)) + 1;
      int paddingLength = maxBucketStrLength - bucketStrLength;

      List<Entry> bucket = hashTable.get(i);

      String padding = "";
      if (paddingLength != 0) {
        char[] padders = new char[paddingLength];
        Arrays.fill(padders, ' ');
        padding = new String(padders);
      }

      String bucketLabel = "bucket " + new String(padding) + i;

      int bucketSize = bucket.size();

      minSize = (bucketSize < minSize) ? bucketSize : minSize;
      maxSize = (bucketSize > maxSize) ? bucketSize : maxSize;

      String sizeLabel = "(" + bucketSize + "):";

      System.out.print(bucketLabel + " " + sizeLabel);

      printBucket(bucket);
    }

    System.out.println();
    System.out.println("minBucketSize: " + minSize);
    System.out.println("maxBucketSize: " + maxSize);
  }

  private static void printBucket(List<Entry> bucket) {
    String closer = "";
    if (bucket.size() > 0) {
      System.out.print(" {");
      System.out.print(bucket.get(0).getKey());
      closer = "}";
    }
    for(int i = 1; i < bucket.size(); i++) {
      Entry e = bucket.get(i);
      System.out.print(", " + e.getKey());
    }

    System.out.println(closer);
  }

  // from http://www.java2s.com/Tutorial/Java/0180__File/LoadatextfilecontentsasaString.htm
  private static String deserializeString(File file) throws IOException {
    int len;
    char[] chr = new char[4096];
    final StringBuffer buffer = new StringBuffer();
    final FileReader reader = new FileReader(file);
    try {
      while ((len = reader.read(chr)) > 0) {
        buffer.append(chr, 0, len);
      }
    } finally {
      reader.close();
    }
    return buffer.toString();
  }
}
