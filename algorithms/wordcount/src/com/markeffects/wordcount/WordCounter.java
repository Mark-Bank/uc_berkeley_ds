package com.markeffects.wordcount;

import java.io.*;
import java.util.*;


/**
 * Mark Bank
 * description
 * markbank@markeffects.com
 * 2/3/2016
 */

public class WordCounter {
  static Map<String, Integer> countWords(String fileName) {
    Map<String, Integer> occurrences = new HashMap<>();

    // credit for file i/o:
    // https://www.caveofprogramming.com/java/java-file-reading-and-writing-files-in-java.html
    String line = null;

    try {
      FileReader fReader = new FileReader(fileName);

      BufferedReader bReader = new BufferedReader(fReader);

      while ((line = bReader.readLine()) != null) {
        String[] words = line.split("\\s+");
        mapWords(occurrences, words);
      }

    } catch (FileNotFoundException ex) {
      System.out.println(
        "unable to open file '" + fileName + "'");
    } catch (IOException ex) {
      System.out.println(
        "error reading file '" + fileName + "'");
    }

    return occurrences;

  }

  // credit for regex replacement:
  // http://stackoverflow.com/questions/11149759/remove-all-non-alphabetic-characters-from-a-string-array-in-java
  private static String[] toAlphabetical(String[] line) {
    for (int i = 0; i < line.length; i++) {
      line[i] = line[i].replaceAll("[^a-zA-Z]", "");
      line[i] = line[i].toLowerCase();
    }

    return line;
  }

  // maps String key to the number of times it has been mapped
  private static void mapWords(Map<String, Integer> occurrences, String[] words) {
    // remove non-alpha characters
    words = toAlphabetical(words);
    for (String word : words) {
      if (word.isEmpty()) {
        continue;
      }
      Integer count = occurrences.get(word);
      if (count != null) {
        count++;
      } else {
        occurrences.put(word, 1);
      }
    }
  }

  // sorts occurrences map by value
  static Map<Integer, List<String>> sortByOccurrences(
    Map<String, Integer> occurrences) {

    Map<Integer, List<String>> sortedMap = new TreeMap<>();

    for (Map.Entry<String, Integer> entry : occurrences.entrySet()) {
      String word   = entry.getKey();
      Integer count = entry.getValue();

      if (! sortedMap.containsKey(count)) {
        List<String> words = new ArrayList<>();
        words.add(word);
        sortedMap.put(count, words);
      } else {
        sortedMap.get(count).add(word);
      }
    }

    return sortedMap;
  }


  static void printSortedCount(SortedMap<Integer, List<String>> sortedMap) {
    int maxCount  = sortedMap.lastKey();
    int maxDigits = (int) Math.log10(maxCount) + 1;

    char[] wordPadders = new char[maxDigits];
    Arrays.fill(wordPadders, ' ');
    String wordPadding = new String(wordPadders);

    for(Map.Entry<Integer, List<String>> countList : sortedMap.entrySet()) {
      int count = countList.getKey();
      String countPadding = getPadding(maxDigits, count);

      System.out.println(countPadding + count);

      for(String word : countList.getValue()) {
        System.out.println(wordPadding + word);
      }
    }
  }

  private static String getPadding(int maxDigits, int number) {
    int digits = (int) Math.log10(number) + 1;
    int padLength = maxDigits - digits;

    String padding = "";
    if (padLength != 0) {
      char[] padders = new char[padLength];
      Arrays.fill(padders, ' ');
      padding = new String(padders);
    }

    return padding;
  }
}
