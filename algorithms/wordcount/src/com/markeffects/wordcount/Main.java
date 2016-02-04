package com.markeffects.wordcount;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;

public class Main {

  public static void main(String[] args) {
    Map<String, Integer> ulyssesWordCount = WordCounter.countWords("./resources/ulysses.txt");

    Map<Integer, List<String>> sortedCount =
      WordCounter.sortByOccurrences(ulyssesWordCount);

    WordCounter.printSortedCount((SortedMap<Integer, List<String>>) sortedCount);
    int i = 4;
  }
}
