package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

  public List<List<String>> anagramCorrected(String[] strs) {
    // Create a map to store groups of anagrams
    Map<String, List<String>> anagramGroups = new HashMap<>();
    
    for (String word : strs) {
      // Convert string to char array, sort it, and convert back to string to create a key
      char[] chars = word.toCharArray();
      Arrays.sort(chars);
      String sortedKey = new String(chars);
      
      // If the key doesn't exist in the map, create a new list for it
      if (!anagramGroups.containsKey(sortedKey)) {
        anagramGroups.put(sortedKey, new ArrayList<>());
      }
      
      // Add the original word to its corresponding group
      anagramGroups.get(sortedKey).add(word);
    }
    
    // Convert the map values to a list of lists and return
    return new ArrayList<>(anagramGroups.values());
  }

  public void anagram(String[] strs) {
    List<String> validated = new ArrayList<>();

    // 1. take the first value
    for (int i=0; i < strs.length; i++) {
      // convert value to array
      char[] first = strs[i].toCharArray();

      // 2. take the second value
      for (int j=1; j < strs.length; j++){
        // 3. conver it to array
        char[] second = strs[j].toCharArray();
          for (int x = 0; x < second.length; x++) {
          // check if the compare char is exist in the value char
          for (int y = 0; y < first.length; y++) {
            if (first[y] == second[x]) {
              System.out.println(second[x] + " is exist");
            } else {
              System.out.println(second[x] + " is not exist");
              break;
            }
          }
          validated.add(String.valueOf(second));
        }
      }
    }
    System.out.println(validated);
  }

  public static void main(String[] args) {
    Main main = new Main();
    main.anagram(new String[] {"eat","tea","tan","ate","nat","bat"});
    }
  }
