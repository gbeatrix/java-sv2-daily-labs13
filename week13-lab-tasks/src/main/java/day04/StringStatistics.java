package day04;

import java.util.Map;
import java.util.TreeMap;

public class StringStatistics {
    public static Map<Character, Integer> countVowels(String text) {
        text = text.toUpperCase().replaceAll("[^AEIOU]+", "");
        return makeStatistics(text);
    }

    public static Map<Character, Integer> makeStatistics(String text) {
        Map<Character, Integer> result = new TreeMap<>();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            result.putIfAbsent(ch, 0);
            result.compute(ch, (k, v) -> v+1);
        }
        return result;
    }
}
