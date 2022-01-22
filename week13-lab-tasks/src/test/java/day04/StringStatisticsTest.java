package day04;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StringStatisticsTest {
    @Test
    void testCountVowels() {
        String text = "Ez nem egy angol szöveg.";
        Map<Character, Integer> result = StringStatistics.countVowels(text);
        assertEquals(3, result.keySet().size());
        assertEquals(Map.of('A', 1, 'E', 4, 'O', 1), result);
    }
}