package leetcode;

import java.util.HashMap;
import java.util.Optional;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines ;
 * otherwise, it will return false.
 * <p>
 * Each letter in the magazine string can only be used once in your ransom note.
 */

/*
    Example :

        canConstruct("a", "b") -> false
        canConstruct("aa", "ab") -> false
        canConstruct("aa", "aab") -> true
*/

public class RansomNote
{
    public boolean canConstruct(String ransomNote, String magazine)
    {

        HashMap<Character, Integer> magazineMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++)
        {
            magazineMap.put(magazine.charAt(i), magazineMap.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        HashMap<Character, Integer> ransomMap = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++)
        {
            ransomMap.put(ransomNote.charAt(i), ransomMap.getOrDefault(ransomNote.charAt(i), 0) + 1);
        }

        Optional<Integer> res = ransomMap.entrySet().stream()
                .map(e -> magazineMap.getOrDefault(e.getKey(), 0) - e.getValue())
                .filter(e -> e < 0)
                .findFirst();

        return !res.isPresent();
    }
}
